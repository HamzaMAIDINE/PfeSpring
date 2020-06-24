package org.sid.controller;

import org.sid.entities.BesoinTransverse;
import org.sid.services.BesoinTransverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/BT")
public class BesoinTransverseController {
	
	@Autowired
	private BesoinTransverseService bts;

	@PostMapping("/Add/{id}")
	public BesoinTransverse addBT(@PathVariable("id") String id,@RequestBody BesoinTransverse bt) {
		return bts.addBT(id,bt);
	}

	@PutMapping("/Edit/{id}")
	public BesoinTransverse editBT(@PathVariable("id") String id,@RequestBody BesoinTransverse bt) {
		return bts.editBT(id,bt);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBt(@PathVariable("id") int id) {
		bts.deleteBt(id);
	}
	
	
}
