package org.sid.services;

import org.sid.dao.BesoinTransverseRepo;
import org.sid.dao.ChantierRepo;
import org.sid.entities.BesoinTransverse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BesoinTransverseServiceImp implements BesoinTransverseService {

	@Autowired
	private BesoinTransverseRepo btr;

	@Autowired
	private ChantierRepo cr;

	public BesoinTransverse addBT(String id, BesoinTransverse bt) {
		bt.setChantier(cr.getOne(id));
		return btr.save(bt);
	}

	public BesoinTransverse editBT(String id, BesoinTransverse bt) {
		bt.setChantier(cr.getOne(id));
		return btr.save(bt);
	}

	public void deleteBt(int id) {
		btr.deleteById(id);
	}

}
