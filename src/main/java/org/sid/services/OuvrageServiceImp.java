package org.sid.services;

import java.util.List;

import org.sid.dao.CategoryRepo;
import org.sid.dao.OuvrageRepo;
import org.sid.entities.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OuvrageServiceImp implements OuvrageService {
	@Autowired
	public OuvrageRepo ouvrageRepository;
	@Autowired
	public CategoryRepo cr;

	@Override
	public Ouvrage saveOuvrage(int id, Ouvrage o) {
		o.setCategory(cr.getOne(id));
		return ouvrageRepository.save(o);
	}

	@Override
	public List<Ouvrage> getAllOuvrage() {
		return ouvrageRepository.findAll();
	}

	public void delete(int id) {
		ouvrageRepository.deleteById(id);

	}

	@Override
	public Ouvrage saveOuvrage2(String designation, String unite, double prixU, double prixV,
			int category_id_categorie) {
		 
		return ouvrageRepository.saveOuvrage(designation, unite, prixU, prixV, category_id_categorie);
	}

}
