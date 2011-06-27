package com.darekzon.bookstore.domain;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({@NamedQuery(name="Category.selectTop",query="SELECT c FROM Category c WHERE c.parentId=0")})
public class Category {

	@Id
	@GeneratedValue(generator="category_id", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="category_id",sequenceName="category_id_seq")
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty
	@Size(min=1,max=32)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Size(max=32)
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Basic
	private Integer parentId;
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@ManyToOne(fetch=FetchType.LAZY,optional=true,targetEntity=Category.class)
	@JoinColumn(name="parentId",nullable=true,insertable=false,updatable=false)
	private Category parent;

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parentId",orphanRemoval=true,targetEntity=Category.class)
	private Collection<Category> childrens;

	public Collection<Category> getChildrens() {
		return childrens;
	}

	public void setChildrens(Collection<Category> childrens) {
		this.childrens = childrens;
	}
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Book.class,mappedBy="categoryId")
	private Collection<Book> books;

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	
}
