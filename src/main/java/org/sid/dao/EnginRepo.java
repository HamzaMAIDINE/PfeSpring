package org.sid.dao;

import java.util.List;

import org.sid.entities.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnginRepo extends JpaRepository<Engin, Integer>{
	
	@Query(nativeQuery = true, value = "select * from engin order by type ")
	public List<Engin> getAllEngins();
}
