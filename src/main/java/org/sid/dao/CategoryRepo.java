package org.sid.dao;

import org.sid.entities.Category;
import org.sid.projection.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = CategoryProjection.class)
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
