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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Soumission implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSoumission;
	 
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToOne
	private AppelOffre appelOffre; 
	
	@OneToMany(mappedBy="soumission",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = "soumission")
	private List<SoumissionOuvrage> soumissionOuvrages;
	
	public int getIdSoumission() {
		return idSoumission;
	}
	public void setIdSoumission(int idSoumission) {
		this.idSoumission = idSoumission;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@JsonIgnore
	public AppelOffre getAppelOffre() {
		return appelOffre;
	}
	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}
	@JsonIgnore
	public List<SoumissionOuvrage> getSoumissionOuvrages() {
		return soumissionOuvrages;
	}
	public void setSoumissionOuvrages(List<SoumissionOuvrage> soumissionOuvrages) {
		this.soumissionOuvrages = soumissionOuvrages;
	}
	
	public Soumission() {
		this.date =new Date();
		this.soumissionOuvrages= new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Soumission [idSoumission=" + idSoumission + ", date=" + date + "]";
	}
	
}
