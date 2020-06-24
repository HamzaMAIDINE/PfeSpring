package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class AppelOffre implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@Size(max = 10)
	private String numAO;
	@Temporal(TemporalType.DATE)
	private Date dateAO;
	private String objet;
	private String localisation;
	private double estimation;

	@OneToOne(mappedBy = "appelOffre")
	@JsonIgnoreProperties(value = "appelOffre")
	private Soumission soumission;

	@OneToMany(mappedBy = "appelOffre")
	@JsonIgnoreProperties(value = "appelOffre")
	private List<InstallationChantier> installationChantiers;

	@OneToMany(mappedBy = "appelOffre")
//	@JsonIgnoreProperties(value = "appelOffre")
	private List<EtudePrice> etudePrix;

	@OneToOne(mappedBy = "appelOffre")
	@JsonIgnoreProperties("appelOffre")
	private Chantier chantier;

	public String getNumAO() {
		return numAO;
	}

	public void setNumAO(String numAO) {
		this.numAO = numAO;
	}

	public Date getDateAO() {
		return dateAO;
	}

	public void setDateAO(Date dateAO) {
		this.dateAO = dateAO;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public double getEstimation() {
		return estimation;
	}

	public void setEstimation(double estimation) {
		this.estimation = estimation;
	}

	public Soumission getSoumission() {
		return soumission;
	}

	public void setSoumission(Soumission soumission) {
		this.soumission = soumission;
	}

	public List<InstallationChantier> getInstallationChantiers() {
		return installationChantiers;
	}

	public void setInstallationChantiers(List<InstallationChantier> installationChantiers) {
		this.installationChantiers = installationChantiers;
	}

	public List<EtudePrice> getEtudePrix() {
		return etudePrix;
	}

	public void setEtudePrix(List<EtudePrice> etudePrix) {
		this.etudePrix = etudePrix;
	}

	public Chantier getChantier() {
		return chantier;
	}

	public void setChantier(Chantier chantier) {
		this.chantier = chantier;
	}

	public AppelOffre() {
		this.dateAO = new Date();
	}

}
