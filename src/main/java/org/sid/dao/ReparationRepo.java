package org.sid.dao;

import java.util.List;

import org.sid.entities.Reparation;
import org.sid.projection.ReparationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ReparationProjection.class)
public interface ReparationRepo extends JpaRepository<Reparation, Integer> {

	@Query(nativeQuery = true, value = "select r.idr, r.designation as reparationD,r.date,r.pu,  e.designation as enginD, c.num_ch \n"
			+ "from reparation r, engin e ,chantier c where r.engin_id_engin = e.id_engin and r.chantier_num_ch = c.num_ch ")
	public List<Object[]> getReparationWithEnginAndChantier();

	@Modifying
	@Query(nativeQuery = true, value = "delete from reparation  where idr = ?1")
	public void removeReparationByIdAndChantier(int idReparation);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE reparation SET designation = ?2 , pu = ?3  WHERE (idr = ?1)" )
	public void updateReparation(int id, String designation, double pu);
}
