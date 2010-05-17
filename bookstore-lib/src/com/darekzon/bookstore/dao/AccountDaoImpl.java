package com.darekzon.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.darekzon.bookstore.domain.Account;
import com.darekzon.bookstore.exception.UserNotFoundException;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	HibernateTemplate template;

	@Autowired
	SessionFactory session;

	public Account findUsername(String username) throws UserNotFoundException {
		DetachedCriteria dc = DetachedCriteria.forClass(Account.class);
		dc.add(Property.forName("username").eq(username));
		List users = template.findByCriteria(dc, 0, 1);

		if (users.size() > 0) {
			return (Account) users.get(0);
		}

		throw new UserNotFoundException();
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
