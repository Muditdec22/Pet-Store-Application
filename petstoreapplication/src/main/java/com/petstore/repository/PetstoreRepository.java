package com.petstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petstore.model.Pet;

/**
 * @author Mudit
 * 
 *         Repository for CRUD operations on Pet object
 *
 */
@Repository
public interface PetstoreRepository extends CrudRepository<Pet, Long> {

}
