package com.petstore;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.petstore.dao.UserDao;
import com.petstore.model.User;

/**
 * @author Mudit
 *
 *         Test class for testing the user dao service class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserDao userDao;

	static Properties prop = new Properties();

	/**
	 * Loading the properties file to get the data for testing
	 */
	@BeforeClass
	public static void initialSetup() {
		try {
			prop.load(new FileReader(new File("src//test//java//Junit.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test for Loading user by user name
	 */
	@Test
	public void testLoadUserByUsername() {
		User userDetails = userDao.getUserByUserName(prop.getProperty("loadUserByUsername.username"));
		Assert.assertNotNull(userDetails);
	}

}
