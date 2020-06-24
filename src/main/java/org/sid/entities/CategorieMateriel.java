package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategorieMateriel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */ 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCM;
	
	private String designation;
	
	@OneToMany(mappedBy = "categorieMateriel")
	private List<Materiel> materiels ;
	
	public int getIdCM() {
		return idCM;
	}
	public void setIdCM(int idCM) {
		this.idCM = idCM;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public List<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	
 
}
