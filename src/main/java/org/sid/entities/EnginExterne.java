package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("externe")
public class EnginExterne extends Engin {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private int consommationH;
	
	private double prixLocation;

	public int getConsommationH() {
		return consommationH;
	}

	public void setConsommationH(int consommationH) {
		this.consommationH = consommationH;
	}

	public double getPrixLocation() {
		return prixLocation;
	}

	public void setPrixLocation(double prixLocation) {
		this.prixLocation = prixLocation;
	}

}
