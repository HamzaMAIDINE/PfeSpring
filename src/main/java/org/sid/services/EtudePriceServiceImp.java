package org.sid.services;

import org.sid.dao.AppelOffreRepo;
import org.sid.dao.EtudePrixRepo;
import org.sid.entities.EtudePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudePriceServiceImp implements EtudePriceService {

	@Autowired
	private EtudePrixRepo etudePrixRepository;
	
	@Autowired
	private AppelOffreRepo appelOffreRepository;
	
	public EtudePrice addEtudePrix(String id, EtudePrice et) {
		et.setAppelOffre(appelOffreRepository.getOne(id));
		return etudePrixRepository.save(et);
	}

	public void deleteEtudePrix(int et) {
		etudePrixRepository.deleteById(et);
	}

	public EtudePrice editEtudePrix(EtudePrice et) {
		return etudePrixRepository.save(et);
	}

}
