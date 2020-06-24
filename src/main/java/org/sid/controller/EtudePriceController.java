package org.sid.controller;

import java.util.List;

import org.sid.dao.EtudePrixRepo;
import org.sid.entities.EtudePrice;
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
@RequestMapping("/EtudePrix")
public class EtudePriceController {

	@Autowired
	private org.sid.services.EtudePriceService ets;
	@Autowired
	private EtudePrixRepo etudePrixRepo;
	
	@GetMapping("/getAllEtudeprices")
	public List<Object[]> getAllEtudeprices() {
		return etudePrixRepo.getAllEtudeprices();
	}

	@PostMapping("/{id}/Add")
	public EtudePrice addEtudePrix(@PathVariable("id") String id, @RequestBody EtudePrice et) {
		return ets.addEtudePrix(id, et);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteEtudePrix(@PathVariable("id") int et) {
		try {
			ets.deleteEtudePrix(et);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@PutMapping("/edit")
	public EtudePrice editEtudePrix(EtudePrice et) {
		return ets.editEtudePrix(et);
	}

}
