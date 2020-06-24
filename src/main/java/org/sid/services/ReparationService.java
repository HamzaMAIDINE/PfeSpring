package org.sid.services;

import java.util.List;

import org.sid.entities.Reparation;

public interface ReparationService {

	public List<Reparation> addReparation(List<Reparation> r);

	public Reparation editReparation(Reparation r);

	public void deleteReparation(int id);

}
