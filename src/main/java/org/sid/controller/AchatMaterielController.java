package org.sid.controller;

import java.util.List;

import org.sid.dao.AchatMaterielRepo;
import org.sid.dao.ChantierRepo;
import org.sid.dao.MaterielRepo;
import org.sid.entities.AchatMaterielChantier;
import org.sid.entities.AchatMaterielEtudePrice;
import org.sid.entities.Chantier;
import org.sid.entities.Materiel;
import org.sid.services.AchatMaterielServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/achatMateriels")
public class AchatMaterielController {
	@Autowired
	private AchatMaterielServiceImp ams;
	@Autowired
	private AchatMaterielRepo achatMaterielRepo;
	@Autowired
	private ChantierRepo chantierRepo;
	@Autowired
	private MaterielRepo materielRepo;

	@PostMapping("/{id}/et/add")
	public List<AchatMaterielEtudePrice> addMaterielEt(@PathVariable("id") int id,
			@RequestBody List<AchatMaterielEtudePrice> mat) {
		return ams.addMaterielEt(id, mat);
	}

	@PostMapping("/{id}/ch/add")
	public AchatMaterielChantier addMaterielCh(@PathVariable("id") String id, @RequestBody AchatMaterielChantier mat) {
		return ams.addMaterielCh(id, mat);
	}
	//////////////////////////////////////////////////////////

	@PostMapping("/{chantierId}/{materielId}/Add")
	public void addMaterielEtudePrice(@PathVariable("chantierId") String chantierId,
			@PathVariable("materielId") int materielId, @RequestBody AchatMaterielChantier achatMaterielChantier) {
		Chantier chantier = chantierRepo.findById(chantierId).get();
		Materiel materiel = materielRepo.findById(materielId).get();

		achatMaterielChantier.setChantier(chantier);
		achatMaterielChantier.setMateriel(materiel);
		achatMaterielRepo.save(achatMaterielChantier);

	}
//
//	@PostMapping("/{id}/ch/add")
//	public AchatMaterielChantier addMaterielChantier(@PathVariable("id") String id,@RequestBody AchatMaterielChantier mat) {
//		return ams.addMaterielCh(id, mat);
//	}

	@PostMapping("/{id}/ch/adds")
	public List<AchatMaterielChantier> addMaterielChs(@PathVariable("id") String id,
			@RequestBody List<AchatMaterielChantier> mat) {
		return ams.addMaterielCh(id, mat);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAchatMateriel(@PathVariable("id") int id) {
		ams.deleteAchatMateriel(id);
	}

	@PutMapping("/et/edit/{id}")
	public AchatMaterielEtudePrice editMaterielEt(@PathVariable("id") int id,
			@RequestBody AchatMaterielEtudePrice mat) {
		return ams.editMaterielEt(id, mat);
	}

	@PutMapping("/ch/edit/{id}")
	public AchatMaterielChantier editMaterielCh(@PathVariable("id") String id, @RequestBody AchatMaterielChantier mat) {
		return ams.editMaterielCh(id, mat);
	}

	@GetMapping("/AchatMaterielCH")
	public List<AchatMaterielChantier> getAchatMaterielCh() {
		return ams.getAchatMaterielCh();
	}

	@GetMapping("/AchatMaterielEt")
	public List<AchatMaterielEtudePrice> getAchatMaterielET() {
		return ams.getAchatMaterielET();
	}

	@PostMapping("/AddET")
	public void addAchatMaterielETTest(@RequestBody AchatMaterielEtudePrice mat) {
		System.out.println(mat);
		achatMaterielRepo.save(mat);
	}

	@PostMapping("/AddCH")
	public void addAchatMaterielCHTest(@RequestBody AchatMaterielChantier mat) {
		System.out.println(mat);
		achatMaterielRepo.save(mat);
	}

	public List<AchatMaterielChantier> getAchatMaterielChantier(@PathVariable(value = "chantieId") String chantieId) {
		Chantier chantier = chantierRepo.findById(chantieId).get();
		System.out.println(chantier.getEtat().toString());
//		achatMaterielRepo  
		return null;
	}

}
