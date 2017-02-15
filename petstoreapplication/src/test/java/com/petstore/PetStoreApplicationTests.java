package com.petstore;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.petstore.controller.PetstoreController;
import com.petstore.model.Pet;
import com.petstore.model.PetCategory;
import com.petstore.model.PetTag;

/**
 * @author Mudit
 *
 *         Test class for testing the REST API used for Pet Store Application
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PetStoreApplicationTests {

	@Autowired
	private PetstoreController petstoreController;

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
	 * Test method to test search pet by petId
	 */
	@Test
	public void testSearchPet() {
		ResponseEntity<Pet> responseEntity = petstoreController
				.getPetDetail(Long.parseLong(prop.getProperty("search.petId")));
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	/**
	 * Test method to test fetch all pets
	 */
	@Test
	public void testFetchAllPets() {
		ResponseEntity<List<Pet>> responseEntity = petstoreController.getAllPetDetails();
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	/**
	 * Test method to test delete pet by petId
	 */
	@Test
	public void testDeletePet() {
		ResponseEntity<String> responseEntity = petstoreController
				.deletePet(Long.parseLong(prop.getProperty("delete.petId")));
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	/**
	 * Test method to test Add pet
	 */
	@Test
	public void testAddPet() {
		Pet pet = new Pet(new PetCategory(Long.parseLong(prop.getProperty("add.petCategory"))),
				prop.getProperty("add.petName"), prop.getProperty("add.petPhotoUrl"),
				new PetTag(Long.parseLong(prop.getProperty("add.petTag"))), "Available");
		ResponseEntity<String> responseEntity = petstoreController.savePetDetails(pet);
		Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	/**
	 * Test method to test fetch all PetCategory
	 */
	@Test
	public void testFetchAllPetCategory() {
		ResponseEntity<List<PetCategory>> responseEntity = petstoreController.getAllPetCategory();
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	/**
	 * Test method to test fetch all PetTag
	 */
	@Test
	public void testFetchAllPetTag() {
		ResponseEntity<List<PetTag>> responseEntity = petstoreController.getAllPetTag();
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
