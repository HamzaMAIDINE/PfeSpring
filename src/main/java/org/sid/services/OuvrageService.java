package org.sid.services;

import java.util.List;

import org.sid.entities.Ouvrage;

public interface OuvrageService {
	
	public Ouvrage saveOuvrage(int id, Ouvrage o);
	
	public Ouvrage saveOuvrage2(String designation, String unite, double prixU, double prixV, int category_id_categorie);

	public void delete(int id);

	public List<Ouvrage> getAllOuvrage();
}
