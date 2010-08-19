package com.darekzon.bookstore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.darekzon.bookstore.domain.Account;
import com.darekzon.bookstore.domain.AccountRole;
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
		try{
			c.select(r).where(cb.equal(r.get("username"), username));
			return entityManager.createQuery(c).getSingleResult();
		}catch(NoResultException nre){
			throw new UserNotFoundException();
		}
	}

	public void save(Account account) {
		template.save(account);

	}

	@Override
	public Collection<Account> listAccounts(Collection<AccountRole> roles){
		List<String> c = new ArrayList<String>(roles.size());
		for(AccountRole in : roles){
			c.add(in.getRole());
		}
		List<Account> accounts = entityManager.createQuery("SELECT a FROM Account a JOIN a.accountRole r WHERE r.role IN(?1)",Account.class).setParameter(1,c).getResultList(); 
		return accounts;
	}
	
	
}
