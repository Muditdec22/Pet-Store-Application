package com.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.petstore.common.CommonConstants;
import com.petstore.dao.UserDao;
import com.petstore.service.PetStoreUserService;

/**
 * @author Mudit
 * 
 *         This is the Custom Security Configuration class for our Pet Store
 *         Application.
 * 
 */
@Configuration
@EnableWebSecurity
class PetStoreSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDao userDao;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean());
	}

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new PetStoreUserService(userDao);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(CommonConstants.VIEWPET_ACCESS, CommonConstants.SEARCHPET_ACCESS)
				.permitAll().antMatchers(CommonConstants.ADDPET_ACCESS, CommonConstants.DELETEPET_ACCESS)
				.hasAuthority(CommonConstants.ADMIN).anyRequest().authenticated().and().formLogin().and().logout();
		http.csrf().disable();
	}

}