package com.darekzon.bookstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.darekzon.bookstore.domain.Account;
import com.darekzon.bookstore.exception.UserNotFoundException;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	HibernateTemplate template;

	@Autowired
	SessionFactory session;
	
	@PersistenceContext
	EntityManager entityManager;

	public Account findUsername(String username) throws UserNotFoundException {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> c = cb.createQuery(Account.class);
		Root<Account> r = c.from(Account.class);
		c.select(r).where(cb.equal(r.get("username"), username));
		try{
			return entityManager.createQuery(c).getSingleResult();
		}catch(NoResultException nre){
			throw new UserNotFoundException();
		}
	}

	public void save(Account account) {
		template.save(account);

	}

	@Override
	public List<Account> listAccounts(List<String> roles) {
		Criteria criteria = session.openSession().createCriteria(Account.class);
		criteria.addOrder(Order.asc("username"));
		criteria.createCriteria("accountRole").add(Restrictions.in("role",roles));
		return criteria.list();
	}
	
	
}
