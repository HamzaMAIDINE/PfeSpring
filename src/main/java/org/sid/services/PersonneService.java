package org.sid.services;

import java.util.List;

import org.sid.entities.Personne;

public interface PersonneService {

	public Personne addPersonnel(Personne p);

	public List<Personne> getPersonnel();

	public Personne editPersonnel(Personne p);

	public void deletePersonnel(int id);
}
