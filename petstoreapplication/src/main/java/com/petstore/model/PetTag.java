package com.petstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mudit
 * 
 *         This is the Entity class corresponding to the T_TAGDETAILS database
 *         object used for mapping.
 *
 */
@Entity
@Table(name="T_TAGDETAILS")
public class PetTag implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2727664907918639363L;

	@Id
	@GeneratedValue
	@Column(name = "TAG_ID")
	private long tagId;
	
	@Column(name = "TAG_NAME")
	private String tagName;
	
	public PetTag() {
	}
	
	public PetTag(long tagId) {
		super();
		this.tagId = tagId;
	}

	public PetTag(long tagId, String tagName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
