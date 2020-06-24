package org.sid.controller;

import java.util.List;

import org.sid.dao.EnginRepo;
import org.sid.entities.Engin;
import org.sid.entities.EnginCamion;
import org.sid.entities.EnginExterne;
import org.sid.entities.EnginInterne;
import org.sid.entities.EnginVehicule;
import org.sid.services.EnginServiceImp;
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
@RequestMapping("/engins")
public class EnginController {
	@Autowired
	private EnginServiceImp es;
	@Autowired private EnginRepo enginRepo; 

	@GetMapping("/All")
	public List<Engin> getAllEngin() {
		return enginRepo.getAllEngins();
	}

	@GetMapping("/{id}/get")
	public Engin getEngin(@PathVariable("id") int id) {
		return es.getEngin(id);
	}

	@GetMapping("/externe")
	public List<EnginExterne> getEnginExt() {
		return es.getEnginExt();
	}

	@GetMapping("/interne")
	public List<EnginInterne> getEnginInt() {
		return es.getEnginInt();
	}

	@GetMapping("/vehicule")
	public List<EnginVehicule> getEnginVehicule() {
		return es.getEnginVehicule();
	}

	@GetMapping("/camion")
	public List<EnginCamion> getEnginCamion() {
		return es.getEnginCamion();
	}

	@PostMapping("/Add/externe")
	public EnginExterne addEnginExt(@RequestBody EnginExterne en) {
		return es.addEnginExt(en);
	}

	@PostMapping("/Add/interne")
	public EnginInterne addEnginInt(@RequestBody EnginInterne en) {
		return es.addEnginInt(en);
	}

	@PostMapping("/Add/vehicule")
	public EnginVehicule addEnginVehicule(@RequestBody EnginVehicule en) {
		return es.addEnginVehicule(en);
	}

	@PostMapping("/Add/camion")
	public EnginCamion addEnginCamion(@RequestBody EnginCamion en) {
		return es.addEnginCamion(en);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEngin(@PathVariable("id") int id) {
		es.deleteEngin(id);
	}

	@PutMapping("/edit/externe")
	public EnginExterne editEnginExt(@RequestBody EnginExterne en) {
		return es.editEnginExt(en);
	}

	@PutMapping("/edit/interne")
	public EnginInterne editEnginInt(@RequestBody EnginInterne en) {
		return es.editEnginInt(en);
	}

	@PutMapping("/edit/vehicule")
	public EnginVehicule editEnginVehicule(@RequestBody EnginVehicule en) {
		return es.editEnginVehicule(en);
	}

	@PutMapping("/edit/camion")
	public EnginCamion editEnginCamion(@RequestBody EnginCamion en) {
		return es.editEnginCamion(en);
	}
 
}
