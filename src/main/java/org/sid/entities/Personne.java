package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idP;
	private String nom;
	private String Prenom;
	private String tel;
	private String qualification;
	private double cnss;
	private String salaire;
	private String fonction;
	@Temporal(TemporalType.DATE)
	private Date dateEm;
 
	public int getIdP() {
		return idP;
	} 

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Date getDateEm() {
		return dateEm;
	}

	public void setDateEm(Date dateEm) {
		this.dateEm = dateEm;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public double getCnss() {
		return cnss;
	}

	public void setCnss(double cnss) {
		this.cnss = cnss;
	}

	public Personne() {
		this.dateEm = new Date();
	}

}
