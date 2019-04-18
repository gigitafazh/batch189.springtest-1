package com.bootcamp.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.model.Barang;
import com.bootcamp.model.User;

@Repository
public class UserDAOIMPL extends AbstractHibernateDAO<User> implements UserDAO {
	public UserDAOIMPL() {
		setClazz(User.class);
	}

	public User seachByUsernamePassword(final String username, final String password) {
		String hql = "FROM User U" + " WHERE U.username = :username "
				+ "AND U.password = :password";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("username", username);
		q.setParameter("password", password);

		User result = (User) q.uniqueResult();
		return result;
	}
}