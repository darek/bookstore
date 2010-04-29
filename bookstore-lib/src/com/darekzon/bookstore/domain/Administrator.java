package com.darekzon.bookstore.domain;


import java.util.Date;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Administrator extends Account {
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	Date lastLogin;
	
	public Date getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
}
