package com.petstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petstore.common.CommonConstants;
import com.petstore.dao.PetStoreDAO;
import com.petstore.model.Pet;
import com.petstore.model.PetCategory;
import com.petstore.model.PetTag;

/**
 * @author Mudit
 * 
 *         This is the REST API Implementation for Pet Store Application and
 *         contains methods for basic CRUD operations.
 *
 */
@RestController
@RequestMapping("/petStore")
public class PetstoreController {

	@Autowired
	private PetStoreDAO petStoreDAO;

	@GET
	@RequestMapping("/petDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Pet>> getAllPetDetails() {
		List<Pet> petList = new ArrayList<Pet>();
		petList = petStoreDAO.getAllPetDetails();
		return new ResponseEntity<List<Pet>>(petList, HttpStatus.OK);
	}

	@GET
	@RequestMapping("/searchPet/{petId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Pet> getPetDetail(@PathVariable("petId") long id) {
		Pet pet = petStoreDAO.getPetById(id);

		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}

	@POST
	@RequestMapping("/addPet")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> savePetDetails(@RequestBody Pet pet) {
		pet.setStatus(CommonConstants.AVAILABLE);
		petStoreDAO.savePetDetails(pet);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@DELETE
	@RequestMapping("/deletePet/{petId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> deletePet(@PathVariable("petId") long id) {
		petStoreDAO.deletePet(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GET
	@RequestMapping("/petCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<PetCategory>> getAllPetCategory() {
		List<PetCategory> petCategoryList = new ArrayList<PetCategory>();
		petCategoryList = petStoreDAO.getAllPetCategory();
		return new ResponseEntity<List<PetCategory>>(petCategoryList, HttpStatus.OK);
	}

	@GET
	@RequestMapping("/petTag")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<PetTag>> getAllPetTag() {
		List<PetTag> petTagList = new ArrayList<PetTag>();
		petTagList = petStoreDAO.getAllPetTag();
		return new ResponseEntity<List<PetTag>>(petTagList, HttpStatus.OK);
	}
}
