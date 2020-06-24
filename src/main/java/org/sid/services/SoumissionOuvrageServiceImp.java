package org.sid.services;

import java.util.List;

import org.sid.dao.SoumissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SoumissionOuvrageServiceImp  /* implements SoumissionOuvrageService  */{
	@Autowired
	private SoumissionRepo soumissionRepo;
//	

//	
//	public List<SoumissionOuvrage> addSos(String id,List<SoumissionOuvrage> so) {
//		AppelOffre ao = appelOffreRepository.getOne(id);
//		for(SoumissionOuvrage s: so) s.setSoum(ao.getSoumission()); 
//		return soRepository.saveAll(so);
//	}
//	
//	public void deleteSo(int id) {
//		soRepository.deleteById(id);
//	}
//	
//	public SoumissionOuvrage editSo(String id,SoumissionOuvrage so) {
//		AppelOffre ao = appelOffreRepository.getOne(id);
//		so.setSoum(ao.getSoumission());
//		return soRepository.save(so);
//	}
//	public SoumissionOuvrage addSo(String id, SoumissionOuvrage so) {
//		AppelOffre ao = appelOffreRepository.getOne(id);
//		so.setSoum(ao.getSoumission());
//		return soRepository.save(so);
//	}

}
