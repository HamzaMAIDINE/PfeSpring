package org.sid.services;

import java.util.List;

import org.sid.entities.Chantier;

public interface ChantierService {
	
	public Chantier addChantier(Chantier ch);

	public Chantier editChantier(Chantier ch);

	public List<Chantier> getChantiers();

	public Chantier getChantier(String id);

	public void deleteChantier(String id);
	
	public List<Chantier> getChantiersFini();
	
	public List<Chantier> getChantiersNonFini();

}
