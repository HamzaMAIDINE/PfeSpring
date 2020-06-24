package org.sid.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("etudePrice")
public class AchatMaterielEtudePrice extends AchatMateriel implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@ManyToOne
	private EtudePrice etudePrice;

	public EtudePrice getEtudePrice() {
		return etudePrice;
	}
	public void setEtudePrice(EtudePrice etudePrice) {
		this.etudePrice = etudePrice;
	}

	@Override
	public String toString() {
		return "AchatMaterielEt [getType()=" + getType() + ", getIdAM()=" + getIdAM() + ", getQte()=" + getQte()
				+ ", getPrix()=" + getPrix() + ", getDate()=" + getDate() + "]";
	}
	

}
