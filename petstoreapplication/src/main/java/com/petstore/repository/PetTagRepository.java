package com.petstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.petstore.model.PetTag;

/**
 * @author Mudit
 * 
 *         Repository for CRUD operations on PetTag object
 *
 */
public interface PetTagRepository extends CrudRepository<PetTag, Long> {

}
