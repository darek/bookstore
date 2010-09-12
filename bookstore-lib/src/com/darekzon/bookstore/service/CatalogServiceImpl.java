package com.darekzon.bookstore.service;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.darekzon.bookstore.domain.Book;
import com.darekzon.bookstore.domain.Category;

@Transactional
@Repository
public class CatalogServiceImpl implements CatalogService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Category> getTopCategories(){
		return (Collection<Category>) entityManager.createNamedQuery("Category.selectTop", Category.class).getResultList(); 
	}
	
	@Override
	public void saveCategory(Category category){
		entityManager.persist(category);
	}
	
	@Override
	@Transactional(readOnly=true)
 	public Category findCategory(Integer id){
  		return entityManager.find(Category.class, id);
	}

	@Override
	public void insertBook(Book book) {
		entityManager.persist(book);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Book getBook(Long id) {
		return (Book) entityManager.find(Book.class, id);
	}

	@Override
	public void updateBook(Book b) {
		entityManager.merge(b);
		
	}
	
	
	
		
}
