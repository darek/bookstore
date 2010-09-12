package com.darekzon.bookstore.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.annotations.TypeDef;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RevisionTimestamp;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * @author darek
 */
@Entity
@Indexed
public class Book {
	
	@Id
	@DocumentId
	@GeneratedValue(generator="book_id_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="book_id_seq",initialValue=1,sequenceName="book_id_seq")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Audited
	BigDecimal price = new BigDecimal(0);

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Basic
	@NotEmpty
	@Length(min=2,max=128)
	@Field(index=Index.TOKENIZED,store=Store.YES)
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Length(max=128)
	private String originalTitle = null;
	
	
	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	@NotEmpty
	@Column(length=2,nullable=false)
	private String language = null;
	
	
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@NotEmpty
	@Column(length=250,nullable=true)
	@Field(index=Index.TOKENIZED,store=Store.YES)
	private String shortDescription = null;

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Column(length=65535,nullable=true)
	@Field(index=Index.TOKENIZED,store=Store.NO)
	private String description;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@NotEmpty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String publishDate = null;

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	@Basic
	@NotEmpty
	@Field(index=Index.UN_TOKENIZED,store=Store.NO)
	private String isbn10 = null;

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

}
