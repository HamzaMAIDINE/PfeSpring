package org.sid.controller;

import java.util.List;

import org.sid.dao.ChantierRepo;
import org.sid.dao.DecompteRepo;
import org.sid.dao.OuvrageRepo;
import org.sid.entities.Chantier;
import org.sid.entities.Decompte;
import org.sid.entities.DecompteOuvrage;
import org.sid.entities.Ouvrage;
import org.sid.services.DecompteOuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Dos")
public class DecompteOuvrageController {

	@Autowired
	private DecompteOuvrageService dos;
	@Autowired
	private DecompteRepo decompteRepo;
	@Autowired
	private ChantierRepo chantierRepo;
	@Autowired
	private OuvrageRepo ouvrageRepo;

	@GetMapping("/getAllDecomptesOuvrages")
	private List<Object[]> getAllDecomptesOuvrages() {

		return decompteRepo.getAllDecomptesOuvrages();
	}

	@PostMapping("/decompte/{chantierId}/{ouvrageId}/Add")
	public void saveDecompteByAppelOffre(@PathVariable("chantierId") String chantierId,
			@PathVariable("ouvrageId") int idOuvrage, @RequestBody DecompteOuvrage decompteOuvrage) {

		Decompte decompte = new Decompte();
		decompte.setChantier(chantierRepo.findById(chantierId).get());
		decompteRepo.save(decompte);

		decompteOuvrage.setDecompte(decompte);
		decompteOuvrage.setOuvrage(ouvrageRepo.findById(idOuvrage).get());
		decompte.getDecompteOuvrages().add(decompteOuvrage);
		decompteRepo.save(decompte);
	}

	@GetMapping("/getNumchantierAndIdDecompte/{num_ch}/{ouvrageID}/{qte}")
	public void getNumchantierAndIdDecompte(@PathVariable("num_ch") String num_ch,
			@PathVariable("ouvrageID") int ouvrageID, @PathVariable("qte") int qte) {
		List<Object[]> objects = decompteRepo.getDecompteByNum_ch(num_ch);
		objects.forEach(o -> {
			System.out.println(o[2] + " and " + num_ch);
			if (o[2].equals(num_ch)) {
				System.out.println(" == ");
				Chantier chantier = chantierRepo.findById(num_ch).get();
				Ouvrage ouvrage = ouvrageRepo.findById(ouvrageID).get();
				Decompte decompte = decompteRepo.findByChantier(chantier);
				DecompteOuvrage decompteOuvrage = new DecompteOuvrage();
				decompteOuvrage.setDecompte(decompte);
				decompteOuvrage.setOuvrage(ouvrage);
				decompteOuvrage.setQte(qte);
				decompte.getDecompteOuvrages().add(decompteOuvrage);
				decompteRepo.save(decompte);
				return;
			}
		});
		Chantier chantier = chantierRepo.findById(num_ch).get();
		Decompte decompte = new Decompte();
		decompte.setChantier(chantier);
		Decompte decompte2 = decompteRepo.save(decompte);
		Ouvrage ouvrage = ouvrageRepo.findById(ouvrageID).get();
		DecompteOuvrage decompteOuvrage = new DecompteOuvrage();
		decompteOuvrage.setDecompte(decompte2);
		decompteOuvrage.setOuvrage(ouvrage);
		decompteOuvrage.setQte(qte);
		decompte.getDecompteOuvrages().add(decompteOuvrage);
		decompteRepo.save(decompte);
		return;

	}

	@PostMapping("/add/{id}")
	public DecompteOuvrage addDO(@PathVariable("id") int id, @RequestBody DecompteOuvrage d) {
		return dos.addDO(id, d);
	}

	@PutMapping("/edit/{id}")
	public DecompteOuvrage editDO(@PathVariable("id") int id, @RequestBody DecompteOuvrage d) {
		return dos.editDO(id, d);
	}

	@DeleteMapping("/delete/{idChantier}")
	public void deleteDO(@PathVariable("idChantier") String idChantier) {
		Decompte decompte = decompteRepo.findByChantier(chantierRepo.findById(idChantier).get());
		decompteRepo.deleteDecompteOuvrage(decompte.getIdD());
		decompteRepo.deleteDecompte(idChantier);
	}

}
