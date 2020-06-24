package org.sid.services;

import org.sid.dao.ChantierRepo;
import org.sid.dao.DecompteRepo;
import org.sid.entities.Decompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecomptesServiceImp implements DecomptesService {

	@Autowired
	private DecompteRepo dr;

	@Autowired
	private ChantierRepo ch;

	public Decompte addDecompte(String id, Decompte d) {
		d.setChantier(ch.getOne(id));
		return dr.save(d);
	}

	public void deleteDecomptes(int id) {
		dr.deleteById(id);
	}

}
