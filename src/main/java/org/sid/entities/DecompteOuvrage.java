package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DecompteOuvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDO;
	private int qte;
	@ManyToOne
	private Ouvrage ouvrage;

	@ManyToOne
	private Decompte decompte;

	public int getIdDO() {
		return idDO;
	}

	public void setIdDO(int idDO) {
		this.idDO = idDO;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public Decompte getDecompte() {
		return decompte;
	}

	public void setDecompte(Decompte decompte) {
		this.decompte = decompte;
	}


}
