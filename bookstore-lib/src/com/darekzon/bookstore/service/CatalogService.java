package com.darekzon.bookstore.service;

import java.util.Collection;

import com.darekzon.bookstore.domain.Book;
import com.darekzon.bookstore.domain.Category;

public interface CatalogService{
	
	public Collection<Category> getTopCategories();
	
	public void saveCategory(Category category);

	public Category findCategory(Integer id);

	public void insertBook(Book book);

	public Book getBook(Long id);
	
	public void updateBook(Book b);

	public Collection<Book> search(String phrase);

	public void updateCategory(Category category);
		
}
