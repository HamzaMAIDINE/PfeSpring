package org.sid.services;

import org.sid.entities.EtudePrice;

public interface EtudePriceService {
	public EtudePrice addEtudePrix(String id, EtudePrice et);

	public EtudePrice editEtudePrix(EtudePrice et);

	public void deleteEtudePrix(int et);
}
