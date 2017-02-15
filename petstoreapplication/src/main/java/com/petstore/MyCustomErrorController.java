package com.petstore;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mudit
 * 
 *         This is the Custom implementation of ErrorController class.
 *
 */
@RestController
class PetStoreErrorController implements ErrorController {
	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "You are not authorized to access this page!!!";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
