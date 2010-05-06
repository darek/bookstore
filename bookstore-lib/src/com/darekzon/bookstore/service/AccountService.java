package com.darekzon.bookstore.service;

import java.util.List;

import com.darekzon.bookstore.domain.Account;
import com.darekzon.bookstore.domain.AccountRole;
import com.darekzon.bookstore.exception.UserExistsException;

public interface AccountService {
	
	public void registerAccount(Account account, List<AccountRole> ar) throws UserExistsException;

	public List<Account> listAccounts(List<String> roles);
	
}
