package org.sid.controller;

import java.util.List;

import org.sid.entities.LocationChantier;
import org.sid.services.LocationChantierService;
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
@RequestMapping("/LocationsChantier")
public class LocationChantierController {

	@Autowired
	private LocationChantierService lcs;

	@PostMapping("/add/{id}")
	public List<LocationChantier> addLocation(@PathVariable("id") String id, @RequestBody List<LocationChantier> l) {
		return lcs.addLocation(id, l);
	}

	@PutMapping("/edit")
	public LocationChantier editLocation(@RequestBody LocationChantier l) {
		return lcs.editLocation(l);
	}

	@DeleteMapping("/delete/{id}")
	public boolean Deletelocation(@PathVariable("id") int id) {
		try {
			lcs.Deletelocation(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
