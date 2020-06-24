package org.sid.services;

import java.util.List;

import org.sid.dao.PersonneRepo;
import org.sid.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneServiceImp implements PersonneService {

	@Autowired
	private PersonneRepo pr;
	
	
	public Personne addPersonnel(Personne p) {
		return pr.save(p);
	}

	public List<Personne> getPersonnel() {
		return pr.findAll();
	}

	public Personne editPersonnel(Personne p) {
		return pr.save(p);
	}

	public void deletePersonnel(int id) {
		pr.deleteById(id);
	}

}
