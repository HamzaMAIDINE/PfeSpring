package org.sid.services;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.AchatMaterielRepo;
import org.sid.dao.ChantierRepo;
import org.sid.dao.EtudePrixRepo;
import org.sid.entities.AchatMateriel;
import org.sid.entities.AchatMaterielChantier;
import org.sid.entities.AchatMaterielEtudePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchatMaterielServiceImp implements AchatMaterielService {

	@Autowired
	private AchatMaterielRepo amRepository;

	@Autowired
	private AchatMaterielRepo am;

	@Autowired
	private EtudePrixRepo lr;

	@Autowired
	private ChantierRepo chr;

	public void deleteMateriel(int id) {
		am.deleteById(id);
	}

	public List<AchatMaterielEtudePrice> addMaterielEt(int id, List<AchatMaterielEtudePrice> mat) {
		for (AchatMaterielEtudePrice matr : mat)
			matr.setEtudePrice(lr.getOne(id));
		return amRepository.saveAll(mat);
	}

	public AchatMaterielChantier addMaterielCh(String id, AchatMaterielChantier mat) {
		mat.setChantier(chr.getOne(id));
		return amRepository.save(mat);
	}

	public void deleteAchatMateriel(int id) {
		am.deleteById(id);
	}

	public AchatMaterielEtudePrice editMaterielEt(int id, AchatMaterielEtudePrice mat) {
		mat.setEtudePrice(lr.getOne(id));
		return amRepository.save(mat);
	}

	public AchatMaterielChantier editMaterielCh(String id, AchatMaterielChantier mat) {
		mat.setChantier(chr.getOne(id));
		return amRepository.save(mat);
	}

	public List<AchatMaterielChantier> addMaterielCh(String id, List<AchatMaterielChantier> mat) {
		for (AchatMaterielChantier matr : mat)
			matr.setChantier(chr.getOne(id));
		return amRepository.saveAll(mat);
	}

	public List<AchatMaterielChantier> getAchatMaterielCh() {
		List<AchatMaterielChantier> achatMaterielChs= new ArrayList<>();
		for (AchatMateriel a : amRepository.findAll()) {
			if (a instanceof AchatMaterielChantier) {
				achatMaterielChs.add((AchatMaterielChantier) a);
			}
		}
		return achatMaterielChs;
	}
	
	public List<AchatMaterielEtudePrice> getAchatMaterielET() {
		List<AchatMaterielEtudePrice> achatMaterielEts= new ArrayList<>();
		for (AchatMateriel a : amRepository.findAll()) {
			if (a instanceof AchatMaterielEtudePrice) {
				System.out.println(a);
				achatMaterielEts.add((AchatMaterielEtudePrice) a);
			}
		}
		return achatMaterielEts;
	}

}
