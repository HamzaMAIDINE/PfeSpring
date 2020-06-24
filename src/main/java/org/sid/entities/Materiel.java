package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Materiel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMateriel;

	private String designation;

	private double prix;

	@ManyToOne
	private CategorieMateriel categorieMateriel;

	@OneToMany(mappedBy = "materiel")
	private List<AchatMateriel> achatMateriels;

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public CategorieMateriel getCategorieMateriel() {
		return categorieMateriel;
	}

	public void setCategorieMateriel(CategorieMateriel categorieMateriel) {
		this.categorieMateriel = categorieMateriel;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
