package com.darekzon.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.darekzon.bookstore.dao.AccountDao;
import com.darekzon.bookstore.domain.Account;
import com.darekzon.bookstore.exception.UserExistsException;

public interface AccountService {
	
	public void registerAccount(Account account) throws UserExistsException;
	
}
