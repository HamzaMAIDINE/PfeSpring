package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Chantier implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	private String numCh;

	@Temporal(TemporalType.DATE)
	private Date date;
	@Size(max = 10)
	private String etat;

	@OneToOne
//	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnore
	private AppelOffre appelOffre;

	@OneToMany(mappedBy = "chantier")
	@JsonIgnoreProperties("chantier")
	private List<BesoinTransverse> besoinTransverses;

	@OneToMany(mappedBy = "chantier")
	@JsonIgnoreProperties("chantier")
	private List<LocationChantier> locationChantiers;

	@ManyToMany
	private List<Personne> personnes;

	@OneToMany(mappedBy = "chantier")
	@JsonIgnoreProperties("chantier")
	private List<Decompte> decomptes;

	@OneToMany(mappedBy = "chantier", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("chantier")
	private List<AchatMaterielChantier> achatMaterielChantiers;

	@OneToMany(mappedBy = "chantier")
	private List<Reparation> reparations;

	public String getNumCh() {
		return numCh;
	}

	public void setNumCh(String numCh) {
		this.numCh = numCh;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}

	public List<BesoinTransverse> getBesoinTransverses() {
		return besoinTransverses;
	}

	public void setBesoinTransverses(List<BesoinTransverse> besoinTransverses) {
		this.besoinTransverses = besoinTransverses;
	}

	public List<LocationChantier> getLocationChantiers() {
		return locationChantiers;
	}

	public void setLocationChantiers(List<LocationChantier> locationChantiers) {
		this.locationChantiers = locationChantiers;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public List<Decompte> getDecomptes() {
		return decomptes;
	}

	public void setDecomptes(List<Decompte> decomptes) {
		this.decomptes = decomptes;
	}

	public List<AchatMaterielChantier> getAchatMaterielChantiers() {
		return achatMaterielChantiers;
	}

	public void setAchatMaterielChantiers(List<AchatMaterielChantier> achatMaterielChantiers) {
		this.achatMaterielChantiers = achatMaterielChantiers;
	}

	public List<Reparation> getReparations() {
		return reparations;
	}

	public void setReparations(List<Reparation> reparations) {
		this.reparations = reparations;
	}

	public Chantier() {
		this.date = new Date();
		this.etat = "en_cours";
	}

}
