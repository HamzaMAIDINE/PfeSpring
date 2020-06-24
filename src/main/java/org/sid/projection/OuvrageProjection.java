package org.sid.projection;

import org.sid.entities.Category;
import org.sid.entities.Ouvrage;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ouvrageP", types = Ouvrage.class)
public interface OuvrageProjection {
	
	public int getIdOuvrage();

	public String getDesignation();

	public String getUnite();

	public double getPrixU();

	public double getPrixV();

	public Category getCategory();
}
