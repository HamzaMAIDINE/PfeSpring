package org.sid.dao;

import org.sid.entities.Materiel;
import org.sid.projection.MaterielProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "materiels", excerptProjection = MaterielProjection.class) 
public interface MaterielRepo extends JpaRepository<Materiel, Integer>{
		
}
  