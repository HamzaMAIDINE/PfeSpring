package org.sid.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class Reporting {

	@Autowired
	EntityManager entityManager;

	public List<Object[]> getNbPersonnesPerChantier() {
		Query query = entityManager.createNativeQuery(
				"select count(cp.personnes_idp) as personnes ,cp.chantier_num_ch from chantier_personnes cp group by cp.chantier_num_ch");
		@SuppressWarnings("unchecked")
		List<Object[]> objects = query.getResultList();
		return objects;
	}

	public List<Object[]> getNbReparationsPerChantier() {
		Query query = entityManager.createNativeQuery(
				"select count(r.idr) , c.num_ch from reparation r, chantier c where r.chantier_num_ch= c.num_ch  group by r.chantier_num_ch");
		@SuppressWarnings("unchecked")
		List<Object[]> objects = query.getResultList();
		return objects;
	}

	public List<Object[]> getNbChantierPerAppelOffre() {
		Query query = entityManager.createNativeQuery(
				"select count(c.num_ch), c.appel_offre_numao from chantier c group by c.appel_offre_numao");
		@SuppressWarnings("unchecked")
		List<Object[]> objects = query.getResultList();
		return objects;
	}
} 
 