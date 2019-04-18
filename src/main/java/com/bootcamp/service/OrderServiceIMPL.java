package com.bootcamp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dao.OrderDAO;
import com.bootcamp.dao.OrderDetailDAO;
import com.bootcamp.model.Order;
import com.bootcamp.model.OrderDetail;
import com.bootcamp.modelView.OrderModelView;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Override
	public Order findOne(String id) {
		return orderDAO.findOne(id);
	}

	@Override
	public Collection<Order> findAll() {
		return orderDAO.findAll();
	}

	@Override
	public Order update(Order order) {
		return orderDAO.update(order);
	}

	@Override
	public void delete(Order order) {
		orderDAO.delete(order);
	}

	@Override
	public void deleteById(String id) {
		orderDAO.deleteById(id);
	}

	@Override
	public void save(OrderModelView orderModelView) {
		Order order = new Order();

		order.setKode(orderModelView.getKode());
		order.setNamaPelanggan(orderModelView.getNamaPelanggan());
		order.setTglTransaksi(orderModelView.getTglTransaksi());

		orderDAO.save(order);

		long grandTotal = 0;

		for (OrderDetail od : orderModelView.getOrderDetails()) {
			od.setSubTotal(od.getHargaSatuan() * od.getJumlahBarang());
			orderDetailDAO.save(od);
			grandTotal += od.getSubTotal();
		}

		order.setGrandTotal(grandTotal);
		orderDAO.update(order);

	}

	@Override
	public Collection<Order> findAllList() {
		return orderDAO.findAllList();
	}
}