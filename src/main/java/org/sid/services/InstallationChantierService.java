package org.sid.services;

import org.sid.entities.InstallationChantier;

public interface InstallationChantierService {
	
	public InstallationChantier saveIC(InstallationChantier ic);
	public InstallationChantier editIC(InstallationChantier ic);
	public void deleteIc(int ic);

}
