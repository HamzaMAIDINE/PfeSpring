package org.sid.services;

import java.util.List;

import org.sid.dao.ChantierRepo;
import org.sid.entities.Chantier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChantierServiceImpl implements ChantierService {

	@Autowired
	private ChantierRepo chantierRepo;
	
	
	public Chantier addChantier(Chantier ch) {
		ch.setEtat("enCours");
		return chantierRepo.save(ch);
	}

	public Chantier editChantier(Chantier ch) {
		return chantierRepo.save(ch);
	}

	public List<Chantier> getChantiers() {
		return chantierRepo.findAll();
	}

	public Chantier getChantier(String id) {
		return chantierRepo.findById(id).get();
	}

	public void deleteChantier(String id) {
		chantierRepo.deleteById(id);
	}

	@Override
	public List<Chantier> getChantiersFini() {
		  
		return chantierRepo.findByEtat("fini");
	}

	@Override
	public List<Chantier> getChantiersNonFini() {
		 
		return chantierRepo.findByEtat("en_cours");
	}

}
