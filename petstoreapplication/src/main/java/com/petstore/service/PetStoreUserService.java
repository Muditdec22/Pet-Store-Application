package com.petstore.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.petstore.dao.UserDao;
import com.petstore.model.User;

/**
 * @author Mudit
 * 
 *         This class is the Custom implementation of UserDetailsService for
 *         fetching the user details from the database.
 *
 */
@Transactional
public class PetStoreUserService implements UserDetailsService {

	public PetStoreUserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userDao.getUserByUserName(username);
			if (user == null) {
				return null;
			}
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
					getAuthorities(user));
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found");
		}
	}

	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getUserRole());
		authorities.add(grantedAuthority);
		return authorities;
	}

}
