package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SoumissionOuvrage implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSO;

	@ManyToOne
	private Soumission soumission;

	@ManyToOne
	private Ouvrage ouvrage;

	private int qte;

	private double prix;

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Soumission getSoumission() {
		return soumission;
	}

	public void setSoumission(Soumission soumission) {
		this.soumission = soumission;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public int getIdSO() {
		return idSO;
	}

	public void setIdSO(int idSO) {
		this.idSO = idSO;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
