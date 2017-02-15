package com.petstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Mudit
 * 
 *         This is the Entity class corresponding to the T_PETDETAILS database
 *         object used for mapping.
 *
 */
@Entity
@Table(name = "T_PETDETAILS")
public class Pet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4281942020292019626L;

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_PETID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private long petId;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private PetCategory petCategory;

	@Column(name = "PET_NAME")
	private String petName;

	@Column(name = "PHOTOURLS")
	private String photoURLS;

	@ManyToOne
	@JoinColumn(name = "TAG_ID")
	private PetTag petTag;

	@Column(name = "PET_STATUS")
	private String status;

	public Pet() {

	}

	public Pet(PetCategory petCategory, String petName, String photoURLS, PetTag petTag, String status) {
		super();
		this.petCategory = petCategory;
		this.petName = petName;
		this.photoURLS = photoURLS;
		this.petTag = petTag;
		this.status = status;
	}

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public PetCategory getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(PetCategory petCategory) {
		this.petCategory = petCategory;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPhotoURLS() {
		return photoURLS;
	}

	public void setPhotoURLS(String photoURLS) {
		this.photoURLS = photoURLS;
	}

	public PetTag getPetTag() {
		return petTag;
	}

	public void setPetTag(PetTag petTag) {
		this.petTag = petTag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petCategory=" + petCategory + ", petName=" + petName + ", photoURLS="
				+ photoURLS + ", petTag=" + petTag + ", status=" + status + "]";
	}

}
