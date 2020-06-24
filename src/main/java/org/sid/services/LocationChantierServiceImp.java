package org.sid.services;

import java.util.List;

import org.sid.dao.ChantierRepo;
import org.sid.dao.LocationChantierRepo;
import org.sid.entities.LocationChantier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocationChantierServiceImp implements LocationChantierService{

	@Autowired
	private LocationChantierRepo lchr;
	
	@Autowired
	private ChantierRepo ch;
	
	public List<LocationChantier> addLocation(String id, List<LocationChantier> l) {
		for(LocationChantier la: l)
		la.setChantier(ch.getOne(id));
		return lchr.saveAll(l);
	}

	public LocationChantier editLocation(LocationChantier l) {
		return lchr.save(l);
	}

	public void Deletelocation(int id) {
		lchr.deleteById(id);
	}

}
