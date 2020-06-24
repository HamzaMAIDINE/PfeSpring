package org.sid.dao;

import org.sid.entities.DecompteOuvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DecompteOuvrageRepo extends JpaRepository<DecompteOuvrage, Integer> {

}
