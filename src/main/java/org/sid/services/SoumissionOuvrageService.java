package org.sid.services;

import java.util.List;

import org.sid.entities.SoumissionOuvrage;

public interface SoumissionOuvrageService {
	public List<SoumissionOuvrage> addSos(String id, List<SoumissionOuvrage> so);

	public SoumissionOuvrage addSo(String id, SoumissionOuvrage so);

	public void deleteSo(int id);

	public SoumissionOuvrage editSo(String id, SoumissionOuvrage so);
}
