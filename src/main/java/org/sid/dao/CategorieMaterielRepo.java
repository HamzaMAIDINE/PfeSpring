package org.sid.dao;

import org.sid.entities.CategorieMateriel;
import org.sid.projection.CategoryMatereielProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = CategoryMatereielProjection.class)
public interface CategorieMaterielRepo extends JpaRepository<CategorieMateriel, Integer>{

}
