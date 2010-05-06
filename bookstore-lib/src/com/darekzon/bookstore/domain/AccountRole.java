package com.darekzon.bookstore.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account_role")
public class AccountRole {

	public AccountRole() {
		this.setRole("ROLE_ANONYMOUS");
	}

	public AccountRole(String role) {
		this.setRole(role);
	}

	@Id
	@GeneratedValue(generator = "role_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "role_id", sequenceName = "account_role_id_seq", initialValue = 1)
	Integer roleId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Basic
	String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ManyToOne(targetEntity = Account.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId", nullable = true)
	Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
