package com.petstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mudit
 * 
 *         This is the Entity class corresponding to the T_USER database
 *         object used for mapping.
 *
 */
@Entity
@Table(name="T_USER")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2986198652064235637L;

	@Id
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "USER_ROLE")
	private String userRole;
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
