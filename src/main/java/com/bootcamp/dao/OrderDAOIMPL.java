package com.bootcamp.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.model.Order;

@Repository
public class OrderDAOIMPL extends AbstractHibernateDAO<Order> implements OrderDAO {
	public OrderDAOIMPL() {
		setClazz(Order.class);
	}

	@Override
	public Collection<Order> findAllList() {
		String hql = "SELECT D.barang.kode FROM OrderDetail D";
		Query q = getCurrentSession().createQuery(hql);

		Collection<Order> result = q.list();
		return result;
	}
}