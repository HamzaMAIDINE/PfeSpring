package org.sid.services;

import org.sid.dao.DecompteOuvrageRepo;
import org.sid.dao.DecompteRepo;
import org.sid.entities.DecompteOuvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DecompteOuvrageServiceImp implements DecompteOuvrageService{

	@Autowired
	private DecompteOuvrageRepo dr;
	@Autowired
	private DecompteRepo der;
	
	public DecompteOuvrage addDO(int id, DecompteOuvrage d) {
		d.setDecompte(der.getOne(id));
		return dr.save(d);
	}

	public DecompteOuvrage editDO(int id, DecompteOuvrage d) {
		d.setDecompte(der.getOne(id));
		return dr.save(d);
	}

	public void deleteDO(int id) {
		dr.deleteById(id);
	}



}
