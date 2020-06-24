package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ouvrage implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOuvrage;

	private String designation;

	private String unite;

	private double prixU;

	private double prixV;

	@ManyToOne
	private Category category;

	public int getIdOuvrage() {
		return idOuvrage;
	}

	public void setIdOuvrage(int idOuvrage) {
		this.idOuvrage = idOuvrage;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public double getPrixU() {
		return prixU;
	}

	public void setPrixU(double prixU) {
		this.prixU = prixU;
	}

	public double getPrixV() {
		return prixV;
	}

	public void setPrixV(double prixV) {
		this.prixV = prixV;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Ouvrage [idOuvrage=" + idOuvrage + ", designation=" + designation + ", unite=" + unite + ", prixU="
				+ prixU + ", prixV=" + prixV + "]";
	}

}
