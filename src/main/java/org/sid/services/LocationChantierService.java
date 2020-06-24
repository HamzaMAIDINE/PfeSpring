package org.sid.services;

import java.util.List;

import org.sid.entities.LocationChantier;

public interface LocationChantierService {
	
	public List<LocationChantier> addLocation(String id, List<LocationChantier> l);

	public LocationChantier editLocation(LocationChantier l);

	public void Deletelocation(int id);
}
