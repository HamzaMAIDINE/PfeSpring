package org.sid.projection;

import org.sid.entities.CategorieMateriel;
import org.sid.entities.Materiel;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "materielPro", types = Materiel.class)
public interface MaterielProjection {

	public int getIdMateriel();

	public String getDesignation();

	public double getPrix();

	public CategorieMateriel getCategorieMateriel();
}
 