package org.sid.dao;

import java.util.List;

import org.sid.entities.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface AppelOffreRepo extends JpaRepository<AppelOffre, String> {

	@Query(nativeQuery = true, value = "select * from appel_offre order by dateao;")
	public List<AppelOffre> getAllAppelOffres();

	@Query(nativeQuery = true, value = "select numao, ouvrage.designation,ouvrage.unite,soumission_ouvrage.qte ,ouvrage.prixu, (soumission_ouvrage.qte * ouvrage.prixu) as total from appel_offre,soumission, soumission_ouvrage , ouvrage \n"
			+ "where (appel_offre.numao= soumission.appel_offre_numao and soumission.id_soumission= soumission_ouvrage.soumission_id_soumission \n"
			+ "and soumission_ouvrage.ouvrage_id_ouvrage =ouvrage.id_ouvrage) and numao = ?1 ")
	public List<Object[]> getTableBord(String appelOffreId);

//	@Query(nativeQuery = true, value = "")
//	public List<Object[]> getAllAppelOffres();

}
