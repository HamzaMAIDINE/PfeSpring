package org.sid.controller;

import java.util.List;

import org.sid.dao.CategorieMaterielRepo;
import org.sid.dao.MaterielRepo;
import org.sid.entities.CategorieMateriel;
import org.sid.entities.Materiel;
import org.sid.services.MaterielService;
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
@RequestMapping(value = "Materiels")
@CrossOrigin(origins = "http://localhost:4200")
public class MaterielController {
	@Autowired
	private CategorieMaterielRepo categorieMaterielRepo;
	@Autowired
	private MaterielRepo materielRepo;
	@Autowired
	private MaterielService ms;

	@GetMapping("/All")
	public List<Materiel> getMateriel() {
		return ms.getMateriel();
	}

	@PostMapping("/{id}/Add")
	public Materiel addMateriel(@PathVariable("id") int idCat, @RequestBody Materiel materiel) {
		System.out.println(idCat);
		CategorieMateriel categorieMateriel = categorieMaterielRepo.findById(idCat).get();
		materiel.setCategorieMateriel(categorieMateriel);
		Materiel materiel2 = materielRepo.save(materiel);
		System.out.println(materiel2.getDesignation().toString());
		return materiel2;
	}

	@PutMapping("/{id}/edit")
	public Materiel EditMateriel(@PathVariable("id") int idCat, @RequestBody Materiel materiel) {
		System.out.println(idCat);
		CategorieMateriel categorieMateriel = categorieMaterielRepo.findById(idCat).get();
		materiel.setCategorieMateriel(categorieMateriel);
		Materiel materiel2 = materielRepo.save(materiel);
		System.out.println(materiel2.getDesignation().toString());
		return materiel2;
	}

	@PutMapping("/edit")
	public Materiel editMateriel(@RequestBody Materiel m) {
		return ms.editMateriel(m);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteMateriel(@PathVariable("id") int id) {
		ms.deleteMateriel(id);
	}

	@GetMapping("/Categories")
	public List<CategorieMateriel> getCatMat() {
		return ms.getCatMat();
	}

	@PostMapping("/Categories/add")
	public CategorieMateriel addCategorie(@RequestBody CategorieMateriel cm) {
		return ms.addCatMat(cm);
	}

}
