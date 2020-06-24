package org.sid.dao;

import java.util.List;

import org.sid.entities.EtudePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource 
public interface EtudePrixRepo extends JpaRepository<EtudePrice, Integer>{

	@Query(nativeQuery = true, value = "select e.idet, e.distance, e.foisonnement, e.nbr_ouvrier, e.rendement, e.salaire_chef_equipe, e.salaire_ouvrier, e.appel_offre_numao, g.designation as enginDes, o.designation as ouvrageDesi\n" + 
			" from etude_price e, engin g, ouvrage o where e.engin_camion_id_engin = g.id_engin and e.ouvrage_id_ouvrage =o.id_ouvrage")
	public List<Object[]> getAllEtudeprices();
}
