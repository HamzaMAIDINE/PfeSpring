package org.sid.dao;

import java.util.List;

import org.sid.entities.AppelOffre;
import org.sid.entities.Soumission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface SoumissionRepo extends JpaRepository<Soumission, Integer> {

	public Soumission findByAppelOffre(AppelOffre appelOffre);

	@Modifying
	@Query(nativeQuery = true, value = " select so.idso, so.prix, so.qte, o.designation, s.date, ap.numao  from soumission_ouvrage so, soumission s, ouvrage o , appel_offre ap\n" + 
			"where so.ouvrage_id_ouvrage = o.id_ouvrage and so.soumission_id_soumission= s.id_soumission and s.appel_offre_numao =ap.numao  ")
	public List<Object[]> getAllSoumissionsOuvrages();

	@Modifying
	@Query(nativeQuery = true, value = "delete from soumission_ouvrage where soumission_id_soumission= ?1")
	public void deleteSoumissionOuvrage(int soumissionId);

	@Modifying
	@Query(nativeQuery = true, value = "delete from soumission where id_soumission = ?1")
	public void deleteSoumission(int soumissionId);

	@Query(nativeQuery = true, value = "select * from soumission s where s.appel_offre_numao=?1 ")
	public List<Object[]> getNumAppelOffreAndIdSoumission(String numAo);
	
} 
