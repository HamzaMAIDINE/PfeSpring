package org.sid.dao;

import org.sid.entities.InstallationChantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InstallationChantierRepo extends JpaRepository<InstallationChantier, Integer> {

}
 