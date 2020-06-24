package org.sid.controller;

import java.util.List;

import org.sid.dao.AppelOffreRepo;
import org.sid.dao.BesoinTransverseRepo;
import org.sid.dao.ChantierRepo;
import org.sid.dao.EnginRepo;
import org.sid.dao.PersonneRepo;
import org.sid.dao.ReparationRepo;
import org.sid.entities.AppelOffre;
import org.sid.entities.BesoinTransverse;
import org.sid.entities.Chantier;
import org.sid.entities.Engin;
import org.sid.entities.Personne;
import org.sid.entities.Reparation;
import org.sid.services.ChantierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Chantiers")
public class ChantierController {

	@Autowired
	private BesoinTransverseRepo besoinTransverseRepo;

	@Autowired
	private ChantierService chantierService;
	@Autowired
	private ChantierRepo chantierRepo;
	@Autowired
	private AppelOffreRepo appelOffreRepo;
	@Autowired
	private PersonneRepo personneRepo;
	@Autowired
	private EnginRepo enginRepo;
	@Autowired
	private ReparationRepo reparationRepo;

	@PostMapping("/{idApplelOffre}/Add")
	@Transactional
	public Chantier addChantier(@PathVariable("idApplelOffre") String idApplelOffre, @RequestBody Chantier chantier) {
		System.out.println(chantier);
		AppelOffre appelOffre = appelOffreRepo.findById(idApplelOffre).get();
		chantier.setAppelOffre(appelOffre);
		Chantier chantier2 = chantierRepo.save(chantier);
		System.out.println(chantier2.getNumCh().toString());
		return chantier2;
	}

	@PutMapping("/Edit")
	public Chantier editChantier(@RequestBody Chantier ch) {
		return chantierService.editChantier(ch);
	}

	@GetMapping("/All")
	public List<Chantier> getChantiers() {
		return chantierService.getChantiers();
	}

	@GetMapping("/fini")
	public List<Chantier> getChantiersFini() {

		return chantierService.getChantiersFini();
	}

	@GetMapping("/notFini")
	public List<Chantier> getChantiersNonFini() {

		return chantierService.getChantiersNonFini();
	}

	@GetMapping("/{id}")
	public Chantier getChantier(@PathVariable("id") String id) {
		return chantierService.getChantier(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteChantier(@PathVariable("id") String id) {
		chantierService.deleteChantier(id);
	}

	@GetMapping("/getAllChantiersWithAppelOffre")
	public List<Object[]> getAllChantiersWithAppelOffres() {
		System.out.println(" getAllChantiersWithAppelOffres ");
		return chantierRepo.getAllChantiersWithAppelOffre();
	}

	@GetMapping("/getOneChantierByNumChAndNumAO/{appel_offre_numao}/{num_ch}")
	public Object[] getOneChantierByNumChAndNumAO(@PathVariable("appel_offre_numao") String appel_offre_numao,
			@PathVariable("num_ch") String num_ch) {
		return chantierRepo.getOneChantierByNumChAndNumAO(appel_offre_numao, num_ch);
	}

	@GetMapping("/getBesionsTravers/{num_ch}")
	public List<Object[]> getBesionsTravers(@PathVariable("num_ch") String num_ch) {
		return chantierRepo.getBesionsTravers(num_ch);
	}

	@GetMapping("/getPersonnes/{num_ch}")
	public List<Personne> getPersonnes(@PathVariable("num_ch") String num_ch) {
		Chantier chantier = chantierRepo.findById(num_ch).get();
		return chantier.getPersonnes();
	}

	@GetMapping("/getReparations/{num_ch}")
	public List<Object[]> getReparations(@PathVariable("num_ch") String num_ch) {
		return chantierRepo.getReparations(num_ch);
	}

	@GetMapping("/getAchatmaterielChantier/{num_ch}")
	public List<Object[]> getAchatmaterielChantier(@PathVariable("num_ch") String num_ch) {
		return chantierRepo.getAchatmaterielChantier(num_ch);
	}

	@GetMapping("/getAvancementChantier/{num_ch}")
	public List<Object[]> getAvancementChantier(@PathVariable("num_ch") String num_ch) {
		return chantierRepo.getAvancementChantier(num_ch);
	}

	@GetMapping("/getPersonnesNonAffecter/{num_ch}")
	public List<Object[]> getPersonnesNonAffecter(@PathVariable("num_ch") String num_ch) {
		return chantierRepo.getPersonnesNonAffecter(num_ch);
	}

	@Transactional
	@GetMapping("/affecterPersonneToChantier/{num_ch}/{idPersonne}")
	public void affecterPersonneToChantier(@PathVariable("num_ch") String num_ch,
			@PathVariable("idPersonne") int idPersonne) {
		Chantier chantier = chantierRepo.findById(num_ch).get();
		Personne personne = personneRepo.findById(idPersonne).get();
		chantier.getPersonnes().add(personne);
		chantierRepo.save(chantier);
	}

	@PostMapping("/affecterReparation/{num_ch}/{enginId}")
	public void affecterReparation(@PathVariable("num_ch") String num_ch, @PathVariable("enginId") int enginId,
			@RequestBody Reparation reparation) {
		Chantier chantier = chantierRepo.findById(num_ch).get();
		reparation.setChantier(chantier);
		Engin engin = enginRepo.findById(enginId).get();
		reparation.setEngin(engin);
		reparationRepo.save(reparation);

	}

	@GetMapping("/affecterBesoinsTravers/{num_ch}/{designation}/{adresse}/{montant}/{tel}/{type}")
	public void affecterBesoinsTravers(@PathVariable("num_ch") String num_ch,
			@PathVariable("designation") String designation, @PathVariable("adresse") String adresse,
			@PathVariable("montant") int montant, @PathVariable("tel") String tel, @PathVariable("type") String type) {
		BesoinTransverse besoinTransverse = new BesoinTransverse();
		besoinTransverse.setAdresse(adresse);
		besoinTransverse.setDesignation(designation);
		besoinTransverse.setMontant(montant);
		besoinTransverse.setTel(tel);
		besoinTransverse.setType(type);
		Chantier chantier = chantierRepo.findById(num_ch).get();
		besoinTransverse.setChantier(chantier);
		besoinTransverseRepo.save(besoinTransverse);
	}

	@Transactional
	@GetMapping("/removePersonneFromChantier/{num_ch}/{idPersonne}")
	public void removePersonneFromChantier(@PathVariable("num_ch") String num_ch,
			@PathVariable("idPersonne") int idPersonne) {
		chantierRepo.removePersonneFromChantier(num_ch, idPersonne);
		System.out.println(idPersonne + " deleted from  " + num_ch);
	}
}
