package org.sid.services;

import java.util.List;

import org.sid.entities.Entretien;

public interface EntretienService {

	public List<Entretien> addEntretien(List<Entretien> e);

	public Entretien editEntretien(Entretien e);

	public void deleteEntretien(int id);

}
