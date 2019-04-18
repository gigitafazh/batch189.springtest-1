package com.bootcamp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dao.OrderDetailDAO;
import com.bootcamp.model.OrderDetail;

@Service
@Transactional
public class OrderDetailServiceIMPL implements OrderDetailService {
	@Autowired
	private OrderDetailDAO orderDetailDao;

	@Override
	public OrderDetail findOne(String id) {
		return orderDetailDao.findOne(id);
	}

	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
	}

	@Override
	public Collection<OrderDetail> findAll() {
		return orderDetailDao.findAll();
	}

	@Override
	public OrderDetail update(OrderDetail orderDetail) {
		return orderDetailDao.update(orderDetail);
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		orderDetailDao.delete(orderDetail);
	}

	@Override
	public void deleteById(String id) {
		orderDetailDao.deleteById(id);
	}
}