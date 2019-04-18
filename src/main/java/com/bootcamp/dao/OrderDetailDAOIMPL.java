package com.bootcamp.dao;

import org.springframework.stereotype.Repository;

import com.bootcamp.model.OrderDetail;

@Repository
public class OrderDetailDAOIMPL extends AbstractHibernateDAO<OrderDetail> implements OrderDetailDAO {
	public OrderDetailDAOIMPL() {
		setClazz(OrderDetail.class);
	}
}