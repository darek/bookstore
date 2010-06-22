package com.darekzon.bookstore.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder.In;

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
	public List<Account> listAccounts(List<AccountRole> roles){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> c = cb.createQuery(Account.class);
		Root<Account> r = c.from(Account.class);
		try{
			/*In<Object> in = cb.in(r.get("accountRole"));
			for(AccountRole ar : roles){
				in.value(ar);
			}*/
			c.select(r);//.in(r.get("accountRole").get("role")).value("ROLE_ADMIN"));
			return entityManager.createQuery(c).getResultList();
		}catch(NoResultException nre){
			return new ArrayList<Account>();
		}
	}
	
	
}
