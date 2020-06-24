package org.sid.services;

import java.util.List;

import org.sid.entities.CategorieMateriel;
import org.sid.entities.Materiel;

public interface MaterielService {
	
	public List<Materiel> getMateriel();

	public Materiel addMateriel(Materiel m);

	public Materiel editMateriel(Materiel m);

	public void deleteMateriel(int id);

	public List<CategorieMateriel> getCatMat();

	public CategorieMateriel addCatMat(CategorieMateriel cm);
}
