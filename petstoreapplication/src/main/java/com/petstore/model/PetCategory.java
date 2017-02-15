package com.petstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mudit
 * 
 *         This is the Entity class corresponding to the T_PETCATEGORY database
 *         object used for mapping.
 *
 */
@Entity
@Table(name="T_PETCATEGORY")
public class PetCategory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2383957612726909248L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "CATEGORY_ID")
	private long categoryId;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	public PetCategory() {
	}
	
	public PetCategory(long categoryId) {
		super();
		this.categoryId = categoryId;
	}
	
	public PetCategory(long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
