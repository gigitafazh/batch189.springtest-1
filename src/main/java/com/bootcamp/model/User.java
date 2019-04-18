package com.bootcamp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User implements Serializable {
	@Id
	@Column(name = "user_id", length = 10, nullable = false)
	private String userID;

	@Column(name = "nama", length = 100, nullable = false)
	private String nama;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "username", length = 20, nullable = false)
	private String username;

	@Column(name = "password", length = 10, nullable = false)
	private String password;

	@JoinColumn(name = "role_id", updatable = false, insertable = false)
	private String roleId;
	
	@ManyToOne
	@JoinColumn(name = "role_id", updatable = false, insertable = false)
	private UserRole userRole;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}