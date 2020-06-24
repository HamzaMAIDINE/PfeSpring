package org.sid.projection;

import java.util.List;

import org.sid.entities.Category;
import org.sid.entities.Ouvrage;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "categoryP", types = Category.class)
public interface CategoryProjection {
	
	public int getIdCategorie();

	public String getDesignation();

	public List<Ouvrage> getOuvrages();
}
