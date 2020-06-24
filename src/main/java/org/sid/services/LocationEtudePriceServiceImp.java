package org.sid.services;

import java.util.List;

import org.sid.dao.EtudePrixRepo;
import org.sid.dao.LocationEtudePriceRepo;
import org.sid.entities.LocationEtudePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationEtudePriceServiceImp implements LocationEtudePriceService {

	@Autowired
	private LocationEtudePriceRepo lr;

	@Autowired
	private EtudePrixRepo etr;

	public List<LocationEtudePrice> addLocation(int id, List<LocationEtudePrice> ls) {
		for (LocationEtudePrice l : ls)
			l.setEtudePrice(etr.getOne(id));
		return lr.saveAll(ls);
	}

	public void Deletelocation(int id) {
		lr.deleteById(id);
	}

	public LocationEtudePrice editLocation(LocationEtudePrice l) {
		return lr.save(l);
	}

}
