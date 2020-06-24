package org.sid.services;

import org.sid.entities.Decompte;

public interface DecomptesService {
	
	public Decompte addDecompte(String id,Decompte d);
	
	public void deleteDecomptes(int id);
}
