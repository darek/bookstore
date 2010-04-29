package com.darekzon.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.darekzon.bookstore.domain.Account;
import com.darekzon.bookstore.exception.UserNotFoundException;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	HibernateTemplate template;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Account findUsername(String username) throws UserNotFoundException{
		DetachedCriteria dc = DetachedCriteria.forClass(Account.class);
		dc.add(Property.forName("username").eq(username));
		List users = template.findByCriteria(dc,0,1);
		
		if(users.size()>0){
			return (Account) users.get(0);
		}
		
		throw new UserNotFoundException();
	}

	public void save(Account account) {
		template.save(account);
		
	}


}
