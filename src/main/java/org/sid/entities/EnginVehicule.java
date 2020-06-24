package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vehicule")
public class EnginVehicule extends Engin{
 
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private double PrixAchat;
	
	
	public double getPrixAchat() {
		return PrixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		PrixAchat = prixAchat;
	}
	
	
	
}
