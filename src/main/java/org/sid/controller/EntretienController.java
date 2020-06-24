package org.sid.controller;

import java.util.List;

import org.sid.dao.EnginRepo;
import org.sid.dao.EntretienRepo;
import org.sid.entities.EnginInterne;
import org.sid.entities.Entretien;
import org.sid.services.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Entretiens")
public class EntretienController {

	@Autowired
	private EntretienService es;

	@Autowired
	private EnginRepo enginRepo;
	@Autowired
	private EntretienRepo entretienRepo;

	@PostMapping("/entretien/{id}/Add")
	public Entretien addEntretienWithEnginInterne(@PathVariable("id") int idEnginInteren,
			@RequestBody Entretien entretien) {
		entretien.setEnginInterne((EnginInterne) enginRepo.findById(idEnginInteren).get());
		return entretienRepo.save(entretien);
	}

	@Transactional
	@PutMapping("/{id}/edit")
	public void editEntretien(@PathVariable("id") int entretienId, @RequestBody Entretien entretien) {
		entretienRepo.updateEntretien(entretienId, entretien.getDesignation(), entretien.getPu());
	}

	@GetMapping("/All")
	public List<Object[]> getAllEntretiens() {
		return entretienRepo.getAllEntretiens();
	}

//	@PostMapping("/add/{id}")
//	public List<Entretien> addEntretien(@PathVariable("id") String id, @RequestBody List<Entretien> e) {
//		for (Entretien en : e) {
//			en.setChantier(cs.getChantier(id));
//		}
//		return es.addEntretien(e);
//	}

//	@PutMapping("/edit/{id}")
//	public Entretien editEntretien(@PathVariable("id") String id, @RequestBody Entretien e) {
//		e.setChantier(cs.getChantier(id));
//		return es.editEntretien(e);
//	}

	@DeleteMapping("/delete/{id}")
	public void deleteEntretien(@PathVariable("id") int id) {
		es.deleteEntretien(id);
	}

}
