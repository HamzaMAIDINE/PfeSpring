package org.sid.services;

import java.util.Date;
import java.util.List;

import org.sid.dao.AppelOffreRepo;
import org.sid.dao.InstallationChantierRepo;
import org.sid.dao.SoumissionRepo;
import org.sid.entities.AppelOffre;
import org.sid.entities.Soumission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppelOffreServiceImp implements AppelOffreService {
	@Autowired
	public AppelOffreRepo appelOffreRepository;
	
	@Autowired
	public SoumissionRepo soumissionRepository;
	
	@Autowired
	public InstallationChantierRepo icr;
	
	public boolean saveAppelOffre(AppelOffre ao) {
		if(!appelOffreRepository.existsById(ao.getNumAO())) {
			Soumission s = new Soumission();
			AppelOffre a = appelOffreRepository.save(ao);
			s.setAppelOffre(a);
			s.setDate(new Date());
			soumissionRepository.save(s);
		return true;
		}else
		return false;
	}

	public List<AppelOffre> getAllAppleOffre() {
		return appelOffreRepository.findAll();
	}

	public void deleteAppelOffre(String id) {
		appelOffreRepository.deleteById(id);
	}

	public AppelOffre modAppelOffre(AppelOffre ao) {
		return appelOffreRepository.save(ao);
	}

	public AppelOffre getAppleOffre(String id) {
		return appelOffreRepository.findById(id).get();
	}
	
}
