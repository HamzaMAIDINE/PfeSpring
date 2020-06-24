package org.sid.dao;

import org.sid.entities.Ouvrage;
import org.sid.projection.OuvrageProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = OuvrageProjection.class) 
public interface OuvrageRepo extends JpaRepository<Ouvrage, Integer>{
	@Modifying
	@Query(nativeQuery = true, value = "insert into ouvrage(designation,unite, prixU, prixV, category_id_categorie) value(?1, ?2, ?3, ?4, ?5) ")
	public Ouvrage saveOuvrage(String designation, String unite, double prixU, double prixV, int category_id_categorie);

}
