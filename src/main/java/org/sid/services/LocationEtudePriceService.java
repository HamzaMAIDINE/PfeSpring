package org.sid.services;

import java.util.List;

import org.sid.entities.LocationEtudePrice;

public interface LocationEtudePriceService {
	
	public List<LocationEtudePrice> addLocation(int id, List<LocationEtudePrice> l);

	public LocationEtudePrice editLocation(LocationEtudePrice l);

	public void Deletelocation(int id);
}
