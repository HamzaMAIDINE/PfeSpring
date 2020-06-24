package org.sid.services;

import java.util.List;

import org.sid.entities.AchatMaterielChantier;
import org.sid.entities.AchatMaterielEtudePrice;

public interface AchatMaterielService {
	
	public List<AchatMaterielEtudePrice> addMaterielEt(int id, List<AchatMaterielEtudePrice> mat);

	public List<AchatMaterielChantier> addMaterielCh(String id, List<AchatMaterielChantier> mat);

	public AchatMaterielChantier addMaterielCh(String id, AchatMaterielChantier mat);

	public void deleteAchatMateriel(int id);

	public AchatMaterielEtudePrice editMaterielEt(int id, AchatMaterielEtudePrice mat);

	public AchatMaterielChantier editMaterielCh(String id, AchatMaterielChantier mat);
}
