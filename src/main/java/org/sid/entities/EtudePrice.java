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
public class EtudePrice implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idET;

	private double rendement;

	private double foisonnement;

	private double distance;

	private double salaireChefEquipe;

	private double salaireOuvrier;
 
	private int nbrOuvrier;

	@ManyToOne
	private EnginCamion enginCamion;

	@ManyToOne
	private AppelOffre appelOffre;

	@ManyToOne
	private Ouvrage ouvrage;

	@OneToMany(mappedBy = "etudePrice")
	private List<LocationEtudePrice> locationEtudePrices;

	@OneToMany(mappedBy = "etudePrice")
	private List<AchatMaterielEtudePrice> materielEtudePrices;

	public int getIdET() {
		return idET;
	}

	public void setIdET(int idET) {
		this.idET = idET;
	}

	public double getRendement() {
		return rendement;
	}

	public void setRendement(double rendement) {
		this.rendement = rendement;
	}

	public double getFoisonnement() {
		return foisonnement;
	}

	public void setFoisonnement(double foisonnement) {
		this.foisonnement = foisonnement;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getSalaireChefEquipe() {
		return salaireChefEquipe;
	}

	public void setSalaireChefEquipe(double salaireChefEquipe) {
		this.salaireChefEquipe = salaireChefEquipe;
	}

	public double getSalaireOuvrier() {
		return salaireOuvrier;
	}

	public void setSalaireOuvrier(double salaireOuvrier) {
		this.salaireOuvrier = salaireOuvrier;
	}

	public int getNbrOuvrier() {
		return nbrOuvrier;
	}

	public void setNbrOuvrier(int nbrOuvrier) {
		this.nbrOuvrier = nbrOuvrier;
	}

	public EnginCamion getEnginCamion() {
		return enginCamion;
	}

	public void setEnginCamion(EnginCamion enginCamion) {
		this.enginCamion = enginCamion;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public List<LocationEtudePrice> getLocationEtudePrices() {
		return locationEtudePrices;
	}

	public void setLocationEtudePrices(List<LocationEtudePrice> locationEtudePrices) {
		this.locationEtudePrices = locationEtudePrices;
	}

	public List<AchatMaterielEtudePrice> getMaterielEtudePrices() {
		return materielEtudePrices;
	}

	public void setMaterielEtudePrices(List<AchatMaterielEtudePrice> materielEtudePrices) {
		this.materielEtudePrices = materielEtudePrices;
	}

}
