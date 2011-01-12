package com.darekzon.bookstore.service;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.darekzon.bookstore.dao.BookDao;
import com.darekzon.bookstore.domain.Book;
import com.darekzon.bookstore.domain.Category;

@Transactional
@Repository
public class CatalogServiceImpl implements CatalogService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	BookDao bookDao;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Category> getTopCategories(){
		return (Collection<Category>) entityManager.createNamedQuery("Category.selectTop", Category.class).getResultList(); 
	}
	
	@Override
	public void saveCategory(Category category){
		System.out.println(category.getParentId());
		//entityManager.persist(category);
	}
	
	@Override
	public void updateCategory(Category category){
		entityManager.merge(category);
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
		return entityManager.find(Book.class, id);
	}

	@Override
	public void updateBook(Book b) {
		if(entityManager.find(Book.class, b.getId())==null){
			throw new IllegalArgumentException("Unknown book id: " + b.getId());
		}
		entityManager.merge(b);
		
	}
	
	@Transactional(readOnly=true)
	public Collection<Book> search(String phrase){
		FullTextEntityManager fullTextEntityManager = 
		    org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);

		// tworzenie natywnego zapytania Lucene
		String[] fields = new String[]{"title", "subtitle", "authors.name", "publicationDate"};
		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_29,fields, new SimpleAnalyzer());
		org.apache.lucene.search.Query query = null;
		try {
			query = parser.parse( phrase );
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// opakowanie zapytania Lucene w zapytanie Javax Persistence
		javax.persistence.Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Book.class);

		// Wykonujemy zapytanie
		@SuppressWarnings("unchecked")
		List<Book> resultList = (List<Book>) persistenceQuery.getResultList();
		return resultList;
		
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Book> listBooks() {
		return bookDao.list();
	}
	@Override
	@Transactional(readOnly=true)
	public Book getBookDetails(Long id){
		return bookDao.getDetails(id);
	}
	
		
}
