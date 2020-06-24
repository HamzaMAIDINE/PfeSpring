 package org.sid.services;
import java.util.List;

import org.sid.dao.ReparationRepo;
import org.sid.entities.Reparation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReparationServiceImp implements ReparationService {
	
	@Autowired
	private ReparationRepo rr;

	public List<Reparation> addReparation(List<Reparation> r) {
		
		return rr.saveAll(r);
	}

	public Reparation editReparation(Reparation r) {
		return rr.save(r);
	}

	public void deleteReparation(int id) {
		rr.deleteById(id);
	}

}
