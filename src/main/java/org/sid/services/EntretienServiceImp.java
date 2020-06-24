package org.sid.services;

import java.util.List;

import org.sid.dao.EntretienRepo;
import org.sid.entities.Entretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EntretienServiceImp implements EntretienService {
	
	@Autowired
	private EntretienRepo er;

	public List<Entretien> addEntretien(List<Entretien> e) {
		return er.saveAll(e);
	}

	public Entretien editEntretien(Entretien e) {
		return er.save(e);
	}

	public void deleteEntretien(int id) {
		er.deleteById(id);
	}

}
