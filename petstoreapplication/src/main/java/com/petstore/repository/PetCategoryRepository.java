package com.petstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.petstore.model.PetCategory;

/**
 * @author Mudit
 * 
 *         Repository for CRUD operations on PetCategory object
 *
 */
public interface PetCategoryRepository extends CrudRepository<PetCategory, Long> {

}
