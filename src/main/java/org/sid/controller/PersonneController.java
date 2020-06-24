package org.sid.controller;

import java.util.Date;
import java.util.List;

import org.sid.entities.Personne;
import org.sid.services.PersonneService;
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
@RequestMapping("/Personnels")
public class PersonneController {

	@Autowired
	private PersonneService ps;

	@PostMapping("/Add")
	public Personne addPersonnel(@RequestBody Personne p) {
		p.setDateEm(new Date());
		return ps.addPersonnel(p);
	}

	@GetMapping("/All")
	public List<Personne> getPersonnel() {
		return ps.getPersonnel();
	}

	@PutMapping("/edit/{id}")
	public Personne editPersonnel(@PathVariable("id") int id, @RequestBody Personne p) {
		return ps.editPersonnel(p);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePersonnel(@PathVariable("id") int id) {
		try {
			ps.deletePersonnel(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
