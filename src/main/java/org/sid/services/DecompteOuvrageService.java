package org.sid.services;

import org.sid.entities.DecompteOuvrage;

public interface DecompteOuvrageService {

	public DecompteOuvrage addDO(int id,DecompteOuvrage d);
	
	public DecompteOuvrage editDO(int id,DecompteOuvrage d);
	
	public void deleteDO(int id);
	
}
