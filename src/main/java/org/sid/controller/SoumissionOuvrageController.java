package org.sid.controller;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.AppelOffreRepo;
import org.sid.dao.OuvrageRepo;
import org.sid.dao.SoumissionRepo;
import org.sid.entities.AppelOffre;
import org.sid.entities.Ouvrage;
import org.sid.entities.Soumission;
import org.sid.entities.SoumissionOuvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SoumissionOuvrageController {

	@Autowired
	public AppelOffreRepo appelOffreRepository;
	@Autowired
	private SoumissionRepo soumissionRepository;
	@Autowired
	private OuvrageRepo ouvrageRepo;

	@GetMapping("/ouvragesByAppelOffre/{id}")
	public List<Ouvrage> getOuvragesByAppelOffre(@PathVariable(value = "id") String id) {
		Soumission s = soumissionRepository.findByAppelOffre(appelOffreRepository.findById(id).get());
		List<Ouvrage> ouvrages = new ArrayList<>();
		s.getSoumissionOuvrages().forEach(o -> {
			ouvrages.add(o.getOuvrage());
			System.out.println(o.toString());
		});

		return ouvrages;
	}

	@GetMapping("/getAllSoumissionsOuvrages")
	public List<Object[]> getAllSoumissionsOuvrages() {
		List<Object[]> objects = soumissionRepository.getAllSoumissionsOuvrages();
		return objects;
	}

	@PostMapping("/soumission/{numAo}/{idOuvrage}/Add")
	public void saveSoumissionByAppelOffre(@PathVariable("numAo") String numAo,
			@PathVariable("idOuvrage") int idOuvrage, @RequestBody SoumissionOuvrage soumissionOuvrage) {
		Soumission soumission = new Soumission();
		soumission.setAppelOffre(appelOffreRepository.findById(numAo).get());
		soumissionRepository.save(soumission);

		soumissionOuvrage
				.setSoumission(soumissionRepository.findByAppelOffre(appelOffreRepository.findById(numAo).get()));
		soumissionOuvrage.setOuvrage(ouvrageRepo.findById(idOuvrage).get());
		soumission.getSoumissionOuvrages().add(soumissionOuvrage);
		soumissionRepository.save(soumission);
	}

	@GetMapping("/addSoumissionOuvrage/{numAo}/{ouvrageId}/{qte}/{prix}")
	public void getNumAppelOffreAndIdSoumission(@PathVariable("numAo") String numAo,
			@PathVariable("ouvrageId") int ouvrageId, @PathVariable("qte") int qte, @PathVariable("prix") int prix) {
		List<Object[]> objects = soumissionRepository.getNumAppelOffreAndIdSoumission(numAo);
		objects.forEach(o -> {
			if (o[2] == numAo) {
				AppelOffre appelOffre = appelOffreRepository.findById(numAo).get();
				Ouvrage ouvrage = ouvrageRepo.findById(ouvrageId).get();
				Soumission soumission = soumissionRepository.findByAppelOffre(appelOffre);
				SoumissionOuvrage soumissionOuvrage = new SoumissionOuvrage();
				soumissionOuvrage.setOuvrage(ouvrage);
				soumissionOuvrage.setSoumission(soumission);
				soumissionOuvrage.setPrix(prix);
				soumissionOuvrage.setQte(qte);
				soumission.getSoumissionOuvrages().add(soumissionOuvrage);
				soumissionRepository.save(soumission);
				return;
			}
		});
		Soumission soumission = new Soumission();
		AppelOffre appelOffre = appelOffreRepository.findById(numAo).get();
		Ouvrage ouvrage = ouvrageRepo.findById(ouvrageId).get();
		soumission.setAppelOffre(appelOffre);
		Soumission soumission2 = soumissionRepository.save(soumission);
		SoumissionOuvrage soumissionOuvrage = new SoumissionOuvrage();
		soumissionOuvrage.setOuvrage(ouvrage);
		soumissionOuvrage.setSoumission(soumission2);
		soumissionOuvrage.setPrix(prix);
		soumissionOuvrage.setQte(qte);
		soumission.getSoumissionOuvrages().add(soumissionOuvrage);
		soumissionRepository.save(soumission);
		return;

	}

//	@RequestMapping(value="/SO/{id}/AddL",method=RequestMethod.POST)
//	public List<SoumissionOuvrage> addSos(@PathVariable("id") String id,@RequestBody List<SoumissionOuvrage> so) {
//		return soService.addSos(id, so);
//	}
//
//	@RequestMapping(value="/SO/{id}/Add",method=RequestMethod.POST)
//	public SoumissionOuvrage addSo(@PathVariable("id") String id,@RequestBody SoumissionOuvrage so) {
//		return soService.addSo(id, so);
//	}
//
	@Transactional
	@RequestMapping(value = "/soumission/{numAO}/Delete", method = RequestMethod.DELETE)
	public void deleteSo(@PathVariable("numAO") String numAO) {
		System.out.println(numAO);
		Soumission soumission = soumissionRepository.findByAppelOffre(appelOffreRepository.findById(numAO).get());
		System.out.println(soumission.getIdSoumission());
		soumissionRepository.deleteSoumissionOuvrage(soumission.getIdSoumission());
		soumissionRepository.deleteSoumission(soumission.getIdSoumission());
	}
//
//	@RequestMapping(value="/SO/{id}/Update",method=RequestMethod.PUT) 
//	public SoumissionOuvrage editSo(@PathVariable("id") String id,@RequestBody SoumissionOuvrage so) {
//		return soService.editSo(id,so);
//	} 

}
