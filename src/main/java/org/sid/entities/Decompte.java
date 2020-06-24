package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "decomptes")
public class Decompte implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idD;

	@Temporal(TemporalType.DATE)
	private Date date;

	@OneToMany(mappedBy = "decompte", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("decompte")
	private List<DecompteOuvrage> decompteOuvrages;

	@ManyToOne
	private Chantier chantier;

	public int getIdD() {
		return idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<DecompteOuvrage> getDecompteOuvrages() {
		return decompteOuvrages;
	}

	public void setDecompteOuvrages(List<DecompteOuvrage> decompteOuvrages) {
		this.decompteOuvrages = decompteOuvrages;
	}

	public Chantier getChantier() {
		return chantier;
	}

	public void setChantier(Chantier chantier) {
		this.chantier = chantier;
	}

	public Decompte() {
		this.date = new Date();
		this.decompteOuvrages = new ArrayList<>();
	}

}
