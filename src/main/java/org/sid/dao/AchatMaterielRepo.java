package org.sid.dao;

import org.sid.entities.AchatMateriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource 
public interface AchatMaterielRepo extends JpaRepository<AchatMateriel, Integer>{

//	public List<AchatMateriel> findByType(String type);
	
}
