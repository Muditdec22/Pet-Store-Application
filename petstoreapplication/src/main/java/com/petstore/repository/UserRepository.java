package com.petstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.petstore.model.User;

/**
 * @author Mudit
 * 
 *         Repository for CRUD operations on User object
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUserName(String userName);

}
