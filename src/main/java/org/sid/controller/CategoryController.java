package org.sid.controller;

import java.util.List;

import org.sid.entities.Category;
import org.sid.entities.Ouvrage;
import org.sid.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	@Autowired
	private CategorieService categorieService;

	@RequestMapping(value = "/Categories/add", method = RequestMethod.POST)
	public Category saveCategories(@RequestBody Category c) {
		return categorieService.saveCategories(c);
	}

	@RequestMapping(value = "/Categories/All", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categorieService.getAllCategories();
	}

	@RequestMapping(value = "/Categories/edit/{id}", method = RequestMethod.PUT)
	public Category updateCategories(@PathVariable("id") int c, @RequestBody Ouvrage o) {
		return categorieService.editCategorie(c, o);
	}
}
 