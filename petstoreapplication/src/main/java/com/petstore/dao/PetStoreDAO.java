package com.petstore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petstore.model.Pet;
import com.petstore.model.PetCategory;
import com.petstore.model.PetTag;
import com.petstore.repository.PetCategoryRepository;
import com.petstore.repository.PetTagRepository;
import com.petstore.repository.PetstoreRepository;

/**
 * @author Mudit
 * 
 *         This class is the DAO implementation for accessing Pet Store related
 *         persistence objects. This class calls the corresponding methods of
 *         the Repositories.
 */
@Repository
@Transactional
public class PetStoreDAO {

	@Autowired
	private PetstoreRepository petstoreRepository;

	@Autowired
	private PetCategoryRepository petCategoryRepository;

	@Autowired
	private PetTagRepository petTagRepository;

	/**
	 * For persisting the Pet object to the database
	 * 
	 * @param pet
	 */
	public void savePetDetails(Pet pet) {
		petstoreRepository.save(pet);
	}

	/**
	 * For fetching all the Pet objects from the database
	 * 
	 * @return
	 */
	public List<Pet> getAllPetDetails() {
		List<Pet> petList = (List<Pet>) petstoreRepository.findAll();
		return petList;
	}

	/**
	 * For fetching a Pet object for a given identifier
	 * 
	 * @param petId
	 * @return
	 */
	public Pet getPetById(long petId) {
		Pet pet = (Pet) petstoreRepository.findOne(petId);
		return pet;
	}

	/**
	 * For deleting a Pet object from the database for the given identifier
	 * 
	 * @param petId
	 */
	public void deletePet(long petId) {
		petstoreRepository.delete(petId);
	}

	/**
	 * Get all the PetCategory objects from the database
	 * 
	 * @return
	 */
	public List<PetCategory> getAllPetCategory() {
		List<PetCategory> petCategoryList = (List<PetCategory>) petCategoryRepository.findAll();
		return petCategoryList;
	}

	/**
	 * Get all the PetTag objects from the database
	 * 
	 * @return
	 */
	public List<PetTag> getAllPetTag() {
		List<PetTag> petTagList = (List<PetTag>) petTagRepository.findAll();
		return petTagList;
	}

}
