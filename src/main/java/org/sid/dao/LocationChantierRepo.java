package org.sid.dao;

import org.sid.entities.LocationChantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource 
public interface LocationChantierRepo extends JpaRepository<LocationChantier, Integer> {

}
