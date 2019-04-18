package com.bootcamp.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.model.Barang;

@Repository
public class BarangDAOIMPL extends AbstractHibernateDAO<Barang> implements BarangDAO {
	public BarangDAOIMPL() {
		setClazz(Barang.class);
	}
	
	public Collection<Barang> searchByNama(final String nama) {
		String hql = "FROM Barang B WHERE LOWER(B.nama) LIKE LOWER(:nama)";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("nama", "%" + nama + "%");
		
		Collection<Barang> result = q.list();
		return result;
	}
}