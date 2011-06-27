package com.darekzon.bookstore.dao;

import java.util.Collection;

import com.darekzon.bookstore.domain.Book;

public interface BookDao{	
	
	public Collection<Book> list();
	
	public Book getDetails(Long id);
	
}
