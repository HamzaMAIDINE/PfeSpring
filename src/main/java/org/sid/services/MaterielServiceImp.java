package org.sid.services;

import java.util.List;

import org.sid.dao.CategorieMaterielRepo;
import org.sid.dao.MaterielRepo;
import org.sid.entities.CategorieMateriel;
import org.sid.entities.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterielServiceImp implements MaterielService {

	@Autowired
	private MaterielRepo mr;

	@Autowired
	private CategorieMaterielRepo cmr;

	public Materiel addMateriel(Materiel m) {
		return mr.save(m);
	}

	public Materiel editMateriel(Materiel m) {
		return mr.save(m);
	}

	public void deleteMateriel(int id) {
		mr.deleteById(id);
	}

	public List<Materiel> getMateriel() {
		return mr.findAll();
	}

	public List<CategorieMateriel> getCatMat() {
		return cmr.findAll();
	}

	public CategorieMateriel addCatMat(CategorieMateriel cm) {
		return cmr.save(cm);
	}

}
