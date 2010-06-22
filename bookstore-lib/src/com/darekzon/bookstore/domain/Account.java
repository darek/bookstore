package com.darekzon.bookstore.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends User implements UserDetails {


	public Account(){
		super("NONE", "NONE", false, false,false, false, new ArrayList<GrantedAuthority>());
	}

	@Id
	@GeneratedValue(generator = "account_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "account_id", sequenceName = "account_id_seq")
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@NotNull
	@Size(min = 5, max = 20)
	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Size(min = 8, max = 20)
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String repeatedPassword;

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	@Basic
	@DateTimeFormat(iso = ISO.DATE_TIME)
	Date addDate = new Date();

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.EAGER, targetEntity = AccountRole.class)
	List<AccountRole> accountRole = new ArrayList<AccountRole>();

	public List<AccountRole> getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(List<AccountRole> accountRole) {
		for (AccountRole ar : accountRole) {
			this.addAccountRole(ar);
		}
	}

	public void addAccountRole(AccountRole accountRole) {
		if (!this.accountRole.contains(accountRole)) {
			accountRole.setAccount(this);
			this.accountRole.add(accountRole);
		}
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> ga = new HashSet<GrantedAuthority>();
		for (AccountRole ar : this.accountRole) {
			ga.add(new GrantedAuthorityImpl(ar.getRole()));
		}
		return ga;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isEnabled();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isEnabled();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isEnabled();
	}

	@Override
	public boolean isEnabled() {
		if (this.accountRole.size() > 0) {
			return true;
		}
		return false;
	}

}
