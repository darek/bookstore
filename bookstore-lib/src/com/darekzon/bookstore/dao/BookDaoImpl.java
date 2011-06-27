package com.darekzon.bookstore.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.darekzon.bookstore.domain.Book;

public class BookDaoImpl implements BookDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Collection<Book> list() {
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b",
				Book.class).getResultList();
		return books;
	}

	@Override
	public Book getDetails(Long id) {
		Book book = entityManager.find(Book.class, id);
		
		//AuditReader reader = AuditReaderFactory.get(entityManager);
		//System.out.println(book.getId());
		/*List<Book> revisions = reader.createQuery().forRevisionsOfEntity(BookAud.class, true, false)
									.add(new SimpleAuditExpression(new OriginalIdPropertyName("id"),book.getId(),"=")).getResultList();
		
		for(BookAud b : book.getAuditedPrices()){
			System.out.println(b.getPrice()+"   -   "+b.getId());
		}*/
		//book.setAuditedPrices(revisions);
		return book;
	}

}
