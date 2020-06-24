package org.sid.controller;

import java.util.List;

import org.sid.dao.EnginRepo;
import org.sid.dao.ReparationRepo;
import org.sid.entities.Reparation;
import org.sid.services.ReparationService;
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
@RequestMapping("/Reparations")
public class ReparationController {

	@Autowired
	private ReparationService rs;

	@Autowired
	private EnginRepo enginRepo;

	@Autowired
	private ReparationRepo reparationRepo;

	@GetMapping("/All")
	public List<Object[]> getReparation() {
		return reparationRepo.getReparationWithEnginAndChantier();
	}

	@PostMapping("/reparation/{id}/Add")
	public Reparation addReparationWithEngin(@PathVariable("id") int idEngin, @RequestBody Reparation reparation) {
		reparation.setEngin(enginRepo.findById(idEngin).get());
		return reparationRepo.save(reparation);
	}

	@Transactional
	@PutMapping("/{id}/edit")
	public Reparation editReparationWithEngin(@PathVariable("id") int id, @RequestBody Reparation reparation) {
//		Reparation r = reparationRepo.findById(id).get();
		System.out.println(id);
		System.out.println(reparation.getDesignation());
		reparationRepo.updateReparation(id, reparation.getDesignation(), reparation.getPu());
		return null;
	}

	@Transactional
	@GetMapping("/{idReparation}")
	public void removeReparationByIdAndChantier(@PathVariable("idReparation") int idReparation) {
		System.out.println(idReparation);
		reparationRepo.removeReparationByIdAndChantier(idReparation);
	}
//	@PostMapping("/add/{id}") 
//	public List<Reparation> addReparation(@PathVariable("id") String id,@RequestBody List<Reparation> r) {
//		for(Reparation re : r)
//		return rs.addReparation(r);
//	}

//	@PutMapping("/edit/{id}")
//	public Reparation editReparation(@PathVariable("id") String id,@RequestBody Reparation r) { 
//		r.setChantier(cs.getChantier(id));
//		return rs.editReparation(r);
//	} 

	@DeleteMapping("/delete/{id}")
	public void deleteReparation(@PathVariable("id") int id) {
		rs.deleteReparation(id);
	}

}
