package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LocationChantier implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLCH;

	private double prixGaz;

	private int nbrHeure;

	@ManyToOne
	private Engin engin;

	@ManyToOne
	private Chantier chantier;

	@ManyToOne
	private Personne chauffeur;

	public int getIdLCH() {
		return idLCH;
	}

	public void setIdLCH(int idLCH) {
		this.idLCH = idLCH;
	}

	public double getPrixGaz() {
		return prixGaz;
	}

	public void setPrixGaz(double prixGaz) {
		this.prixGaz = prixGaz;
	}

	public int getNbrHeure() {
		return nbrHeure;
	}

	public void setNbrHeure(int nbrHeure) {
		this.nbrHeure = nbrHeure;
	}

	public Engin getEngin() {
		return engin;
	}

	public void setEngin(Engin engin) {
		this.engin = engin;
	}

	public Chantier getChantier() {
		return chantier;
	}

	public void setChantier(Chantier chantier) {
		this.chantier = chantier;
	}

	public Personne getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Personne chauffeur) {
		this.chauffeur = chauffeur;
	}

}
