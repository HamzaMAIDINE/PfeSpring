package org.sid.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("achatChantier")
public class AchatMaterielChantier extends AchatMateriel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@ManyToOne
	private Chantier chantier;
	
	public Chantier getChantier() {
		return chantier;
	}
	
	public void setChantier(Chantier chantier) {
		this.chantier = chantier;
	}
	@Override
	public String toString() {
		return "AchatMaterielEt [getType()=" + getType() + ", getIdAM()=" + getIdAM() + ", getQte()=" + getQte()
				+ ", getPrix()=" + getPrix() + ", getDate()=" + getDate() + "]";
	}
	
	
}
