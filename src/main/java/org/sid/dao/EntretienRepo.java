package org.sid.dao;

import java.util.List;

import org.sid.entities.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EntretienRepo extends JpaRepository<Entretien, Integer> {
	@Query(nativeQuery = true, value = "select e.ide, e.date, e.designation as e1, e.pu, g.designation as g1  from entretien e, engin g where e.engin_interne_id_engin = g.id_engin")
	public List<Object[]> getAllEntretiens();

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE entretien SET designation = ?2 , pu = ?3 WHERE (ide = ?1) ")
	public void updateEntretien(int idE, String designation, double pu);
}
 