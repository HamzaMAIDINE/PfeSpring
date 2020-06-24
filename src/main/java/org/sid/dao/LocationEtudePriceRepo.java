package org.sid.dao;

import org.sid.entities.LocationEtudePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "locationEPes")
public interface LocationEtudePriceRepo extends JpaRepository<LocationEtudePrice, Integer>{

}
