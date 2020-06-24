package org.sid.services;

import org.sid.dao.InstallationChantierRepo;
import org.sid.entities.InstallationChantier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstallationChantierServiceImp implements InstallationChantierService {
	
	@Autowired
	private InstallationChantierRepo icr;

	public InstallationChantier saveIC(InstallationChantier ic) {
		return icr.save(ic);
	}


	public InstallationChantier editIC(InstallationChantier ic) {
		
		return icr.save(ic);
	}

	public void deleteIc(int ic) {
		icr.deleteById(ic);
	}

}
