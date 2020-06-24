package org.sid.projection;

import java.util.Date;

import org.sid.entities.Engin;
import org.sid.entities.Reparation;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "reparationP", types = { Reparation.class })
public interface ReparationProjection {

	public int getIdR();

	public String getDesignation();

	public Date getDate();

	public double getPu();

	public Engin getEngin();

}
