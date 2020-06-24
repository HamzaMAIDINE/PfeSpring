package org.sid.projection;

import java.util.Date;
import java.util.List;

import org.sid.entities.AppelOffre;
import org.sid.entities.EtudePrice;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "appelOffreP", types = { AppelOffre.class })
public interface AppelOffreProjection {

	public String getNumAO();

	public Date getDateAO();

	public String getObjet();

	public String getLocalisation();

	public double getEstimation();

	// public Soumission getSoumission();

	// public List<InstallationChantier> getInstallationChantiers();

	public List<EtudePrice> getEtudePrix();

	// public Chantier getChantier();

}
