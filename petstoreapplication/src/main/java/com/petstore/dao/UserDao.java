package com.petstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petstore.model.User;
import com.petstore.repository.UserRepository;

/**
 * @author Mudit
 * 
 *         This class is the DAO implementation for accessing User objects from
 *         database.
 *
 */
@Repository
@Transactional
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	/**
	 * For fetching a user by username
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
