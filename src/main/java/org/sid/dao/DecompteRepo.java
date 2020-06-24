package org.sid.dao;

import java.util.List;

import org.sid.entities.Chantier;
import org.sid.entities.Decompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DecompteRepo extends JpaRepository<Decompte, Integer> {

	@Modifying
	@Query(nativeQuery = true, value = "insert into decompte_ouvrage(do_idd, ouv_id_ouvrage, qte) values(?1, ?2 , ?3)")
	public void insertIntoDecompteOuvrage(int decompteId, int ouvrageId, int qnt);

	public Decompte findByChantier(Chantier chantier);

	@Query(nativeQuery = true, value = "select decompte_ouvrage.iddo,ouvrage.designation,ouvrage.unite,\n"
			+ " ouvrage.prixu,ouvrage.prixv,decompte_ouvrage.qte, decomptes.date, chantier.num_ch\n"
			+ "  from decompte_ouvrage,decomptes, ouvrage, chantier \n"
			+ " where (decompte_ouvrage.decompte_idd = decomptes.idd\n"
			+ " and decompte_ouvrage.ouvrage_id_ouvrage = ouvrage.id_ouvrage and decomptes.chantier_num_ch = chantier.num_ch )")
	public List<Object[]> getAllDecomptesOuvrages();

	@Modifying
	@Query(nativeQuery = true, value = "delete from decompte_ouvrage where decompte_idd = ?1")
	public void deleteDecompteOuvrage(int idDecompte);

	@Modifying
	@Query(nativeQuery = true, value = "delete from decomptes where chantier_num_ch = ?1")
	public void deleteDecompte(String idOuvrage);

	@Query(nativeQuery = true, value = "select * from decomptes where decomptes.chantier_num_ch = ?1 ")
	public List<Object[]> getDecompteByNum_ch(String num_ch);

}
