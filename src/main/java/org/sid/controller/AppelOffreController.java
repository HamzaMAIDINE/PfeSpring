package org.sid.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.sid.dao.AppelOffreRepo;
import org.sid.dao.EnginRepo;
import org.sid.dao.EtudePrixRepo;
import org.sid.dao.InstallationChantierRepo;
import org.sid.dao.OuvrageRepo;
import org.sid.entities.AppelOffre;
import org.sid.entities.EnginCamion;
import org.sid.entities.EtudePrice;
import org.sid.entities.InstallationChantier;
import org.sid.services.AppelOffreServiceImp;
import org.sid.services.InstallationChantierService;
import org.sid.util.ExcelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/AppelOffres")
public class AppelOffreController {
	@Autowired
	private AppelOffreRepo appelOffreRepo;
	@Autowired
	private AppelOffreServiceImp appelOffreService;
	@Autowired
	private InstallationChantierRepo installationChantierRepo;
	@Autowired
	private EtudePrixRepo etudePrixRepo;
	@Autowired
	private OuvrageRepo ouvrageRepo;
	@Autowired
	private EnginRepo enginRepo;
	@Autowired
	private InstallationChantierService isc;

	@PostMapping("/Add")
	public Boolean addAO(@RequestBody AppelOffre ao) {
		ao.setDateAO(new Date());
		return appelOffreService.saveAppelOffre(ao);
	}

	@PutMapping("/Mod")
	public AppelOffre modifyAO(@RequestBody AppelOffre ao) {
		return appelOffreService.modAppelOffre(ao);
	}

	@GetMapping("/All")
	public List<AppelOffre> getAllAo() {
		return appelOffreRepo.getAllAppelOffres();
	}

	@GetMapping("/{id}")
	public AppelOffre getAo(@PathVariable("id") String id) {
		return appelOffreService.getAppleOffre(id);
	}

	@DeleteMapping("/{id}/delete")
	public Boolean delete(@PathVariable("id") String id) {
		try {
			appelOffreService.deleteAppelOffre(id);
			return true;
		} catch (RuntimeException e) {
			return false;
		}

	}

	@GetMapping("/{id}/soumissionDownload")
	public ResponseEntity<InputStreamResource> SoumissionReport(@PathVariable("id") String id) throws IOException {
		AppelOffre ao = appelOffreService.getAppleOffre(id);
		ByteArrayInputStream in = ExcelGenerator.exportSoumission(ao);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=soumission-" + ao.getNumAO() + ".xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

	@PostMapping("/{id}/ic/add")
	public InstallationChantier addIC(@PathVariable("id") String id, @RequestBody InstallationChantier ic) {
		ic.setAppelOffre(appelOffreService.getAppleOffre(id));
		return isc.saveIC(ic);
	}

	@GetMapping(value = "/getTableBord/{appelOffreId}")
	public List<Object[]> getTableBord(@PathVariable("appelOffreId") String appelOffreId) {
		return appelOffreRepo.getTableBord(appelOffreId);
	}

	@PostMapping("/{idApplelOffre}/Add")
	public InstallationChantier addInstallationChantier(@PathVariable("idApplelOffre") String idApplelOffre,
			@RequestBody InstallationChantier installationChantier) {
		AppelOffre appelOffre = appelOffreRepo.findById(idApplelOffre).get();
		installationChantier.setAppelOffre(appelOffre);
		InstallationChantier installationChantier2 = installationChantierRepo.save(installationChantier);
		System.out.println(installationChantier2.getDesignation().toString());
		return installationChantier2;
	}

	@PostMapping("/{idApplelOffre}/{idOuvrage}/{idCamion}/AddEtudePrice")
	public EtudePrice addEtudePrice(@PathVariable("idApplelOffre") String idApplelOffre,
			@PathVariable("idOuvrage") int idOuvrage, @PathVariable("idCamion") int idCamion,
			@RequestBody EtudePrice etudePrice) {
		AppelOffre appelOffre = appelOffreRepo.findById(idApplelOffre).get();
		etudePrice.setAppelOffre(appelOffre);
		etudePrice.setEnginCamion((EnginCamion) enginRepo.findById(idCamion).get());
		etudePrice.setOuvrage(ouvrageRepo.findById(idOuvrage).get());
		EtudePrice etudePrice2 = etudePrixRepo.save(etudePrice);
		return etudePrice2;
	}

	@PutMapping("/{id}/ic/edit")
	public InstallationChantier editIC(@PathVariable("id") String id, @RequestBody InstallationChantier ic) {
		ic.setAppelOffre(appelOffreService.getAppleOffre(id));
		return isc.saveIC(ic);
	}

	@DeleteMapping("/ic/delete/{id}")
	public boolean deleteIc(@PathVariable("id") int ic) {
		try {
			isc.deleteIc(ic);
			return true;
		} catch (RuntimeException e) {
			return false;
		}

	}

}
