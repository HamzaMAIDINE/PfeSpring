package org.sid.services;

import java.util.List;

import org.sid.entities.Engin;
import org.sid.entities.EnginCamion;
import org.sid.entities.EnginExterne;
import org.sid.entities.EnginInterne;
import org.sid.entities.EnginVehicule;

public interface EnginService {
	public List<Engin> getAllEngin();

	public List<EnginExterne> getEnginExt();

	public List<EnginInterne> getEnginInt();

	public List<EnginVehicule> getEnginVehicule();

	public List<EnginCamion> getEnginCamion();

	public Engin getEngin(int id);

	public EnginExterne addEnginExt(EnginExterne en);

	public EnginInterne addEnginInt(EnginInterne en);

	public EnginVehicule addEnginVehicule(EnginVehicule en);

	public EnginCamion addEnginCamion(EnginCamion en);

	public EnginExterne editEnginExt(EnginExterne en);

	public EnginInterne editEnginInt(EnginInterne en);

	public EnginVehicule editEnginVehicule(EnginVehicule en);

	public EnginCamion editEnginCamion(EnginCamion en);

	public void deleteEngin(int id);

	public Engin editEngin(Engin en);
}
