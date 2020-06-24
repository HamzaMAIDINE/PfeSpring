package org.sid.controller;

import org.sid.entities.Decompte;
import org.sid.services.DecomptesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Decomptes")
public class DecomptesController {

	@Autowired
	private DecomptesService ds;

	@PostMapping("/Add/{id}")
	public Decompte addDecompte(@PathVariable("id") String id, @RequestBody Decompte d) {
		return ds.addDecompte(id, d);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteDecomptes(@PathVariable("id") int id) {
		ds.deleteDecomptes(id);
	}

}
