package org.sid.projection;

import java.util.List;

import org.sid.entities.CategorieMateriel;
import org.sid.entities.Materiel;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "categoryMatP", types = CategorieMateriel.class)
public interface CategoryMatereielProjection {
	
	public int getIdCM();
	
	public String getDesignation();

	public List<Materiel> getMateriels();
} 
