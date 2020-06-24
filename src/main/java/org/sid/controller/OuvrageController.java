package org.sid.controller;

import java.util.List;

import org.sid.dao.CategoryRepo;
import org.sid.dao.OuvrageRepo;
import org.sid.entities.Category;
import org.sid.entities.Ouvrage;
import org.sid.services.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Ouvrages")
public class OuvrageController {
	@Autowired
	private OuvrageService ouvrageService;
	@Autowired
	private OuvrageRepo ouvrageRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@PostMapping("/{id}/add")
	public Ouvrage saveOuvrage(@PathVariable("id") final int c, @RequestBody Ouvrage o) {
//		return ouvrageService.saveOuvrage(c, o);
		Category category = categoryRepo.findById(c).get();
		System.out.println(category.getDesignation().toString());
		o.setCategory(category);
		Ouvrage o2 = ouvrageRepo.save(o);
		System.out.println(o2.getCategory().getDesignation().toString());
		return o2;
	}

	@PutMapping("/{id}/edit")
	public Ouvrage editOuvrage(@PathVariable("id") int c, @RequestBody Ouvrage o) {
//		return ouvrageService.saveOuvrage(c, o);
		Category category = categoryRepo.findById(c).get();
		System.out.println(category.getDesignation().toString());
		o.setCategory(category);
		Ouvrage o2 = ouvrageRepo.save(o);
		System.out.println(o2.getCategory().getDesignation().toString());
		return o2;
	}

	@GetMapping("/All")
	public List<Ouvrage> getAllOuvrage() {
		return ouvrageService.getAllOuvrage();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteOuvrage(@PathVariable("id") int id) {
		ouvrageService.delete(id);
	}

}
