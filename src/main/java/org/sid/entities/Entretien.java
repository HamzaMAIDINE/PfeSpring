package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entretien implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idE;

	private String designation;

	@Temporal(TemporalType.DATE)
	private Date date;

	private double pu;

	@ManyToOne
	private EnginInterne enginInterne;

//	@ManyToOne
//	@JsonIgnoreProperties("entretients")
//	private Chantier chantier;

	public int getIdE() {
		return idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPu() {
		return pu;
	}

	public void setPu(double pu) {
		this.pu = pu;
	}

	public EnginInterne getEnginInterne() {
		return enginInterne;
	}

	public void setEnginInterne(EnginInterne enginInterne) {
		this.enginInterne = enginInterne;
	}

	public Entretien() {
		this.date = new Date();
	}
}
