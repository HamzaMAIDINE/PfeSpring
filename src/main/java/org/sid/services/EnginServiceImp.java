package org.sid.services;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.EnginRepo;
import org.sid.entities.Engin;
import org.sid.entities.EnginCamion;
import org.sid.entities.EnginExterne;
import org.sid.entities.EnginInterne;
import org.sid.entities.EnginVehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class EnginServiceImp implements EnginService {

	@Autowired
	private EnginRepo er;


	public List<Engin> getAllEngin() {

		return er.findAll();
	}

	public List<EnginExterne> getEnginExt() {
		 List<EnginExterne> enginExts=new ArrayList<>();
 		 for (Engin e : er.findAll()) {
			if (e instanceof EnginExterne) {
				 enginExts.add((EnginExterne) e);
			}
		}
		return  enginExts;
	}

	public List<EnginInterne> getEnginInt() {

		 List<EnginInterne> enginInts =new ArrayList<>();
 		 for (Engin e : er.findAll()) {
			if (e instanceof EnginInterne) {
				enginInts.add((EnginInterne) e);
			}
		}
		return  enginInts;
	}

	public List<EnginVehicule> getEnginVehicule() {

		 List<EnginVehicule> enginVehicules=new ArrayList<>();
 		 for (Engin e : er.findAll()) {
			if (e instanceof EnginVehicule) {
				enginVehicules.add((EnginVehicule) e);
			}
		}
		return  enginVehicules;
	}

	public List<EnginCamion> getEnginCamion() {

		 List<EnginCamion> enginCamions=new ArrayList<>();
 		 for (Engin e : er.findAll()) {
			if (e instanceof EnginCamion) {
				enginCamions.add((EnginCamion) e);
			}
		}
		return  enginCamions;
	}

	public EnginExterne addEnginExt(EnginExterne en) {

		return er.save(en);
	}

	public EnginInterne addEnginInt(EnginInterne en) {

		return er.save(en);
	}

	public EnginVehicule addEnginVehicule(EnginVehicule en) {

		return er.save(en);
	}

	public EnginCamion addEnginCamion(EnginCamion en) {

		return er.save(en);
	}

	public void deleteEngin(int id) {

		er.deleteById(id);
	}

	public Engin editEngin(Engin en) {

		return er.save(en);
	}

	public EnginExterne editEnginExt(EnginExterne en) {
		return er.save(en);
	}

	public EnginInterne editEnginInt(EnginInterne en) {
		return er.save(en);
	}

	public EnginVehicule editEnginVehicule(EnginVehicule en) {
		return er.save(en);
	}

	public EnginCamion editEnginCamion(EnginCamion en) {
		return er.save(en);
	}

	public Engin getEngin(int id) {
		return  er.findById(id).get();
	}

}