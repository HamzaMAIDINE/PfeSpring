package org.sid.dao;

import java.util.List;

import org.sid.entities.Chantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ChantierRepo extends JpaRepository<Chantier, String> {

	public List<Chantier> findByEtat(String etat);

	@Modifying
	@Query(nativeQuery = true, value = "select chantier.num_ch, chantier.date, appel_offre.numao,appel_offre.estimation, chantier.etat from chantier, appel_offre where (appel_offre.numao = chantier.appel_offre_numao )")
	public List<Object[]> getAllChantiersWithAppelOffre();

	@Query(nativeQuery = true, value = "select chantier.num_ch, chantier.date, appel_offre.numao,appel_offre.estimation, chantier.etat from chantier, appel_offre \n"
			+ "where (appel_offre.numao = chantier.appel_offre_numao ) and chantier.appel_offre_numao= ?1 and chantier.num_ch= ?2")
	public Object[] getOneChantierByNumChAndNumAO(String appel_offre_numao, String num_ch);

	@Query(nativeQuery = true, value = "select besoin_transverses.idbt,besoin_transverses.designation, besoin_transverses.adresse,besoin_transverses.type, besoin_transverses.tel,besoin_transverses.montant \n"
			+ "from besoin_transverses where besoin_transverses.chantier_num_ch = ?1")
	public List<Object[]> getBesionsTravers(String num_ch);

	@Query(nativeQuery = true, value = "select reparation.idr, reparation.designation as desigantionR, reparation.pu,"
			+ " reparation.date, engin.designation as desigantionE from reparation,engin  where reparation.engin_id_engin = engin.id_engin and"
			+ " reparation.chantier_num_ch = ?1 ")
	public List<Object[]> getReparations(String num_ch);

	@Query(nativeQuery = true, value = "select ac.idam, ac.date,ac.prix,ac.qte, materiel.designation, (ac.prix*ac.qte) as total from achat_materiel ac, materiel where\n"
			+ "	 (ac.materiel_id_materiel =materiel.id_materiel) and ac.type='achatChantier' and ac.chantier_num_ch= ?1 ")
	public List<Object[]> getAchatmaterielChantier(String num_ch);

	@Query(nativeQuery = true, value = "select ouvrage.designation,ouvrage.unite,decomptes.date, ouvrage.prixu,ouvrage.prixv,decompte_ouvrage.qte \n"
			+ ",(ouvrage.prixv * decompte_ouvrage.qte) as total from decompte_ouvrage,decomptes, ouvrage where\n"
			+ " (decomptes.idd= decompte_ouvrage.decompte_idd and \n"
			+ "decompte_ouvrage.ouvrage_id_ouvrage= ouvrage.id_ouvrage ) and decomptes.chantier_num_ch= ?1 ")
	public List<Object[]> getAvancementChantier(String num_ch);

	@Query(nativeQuery = true, value = "select p.idp, p.nom,p.prenom, p.fonction, p.salaire from personne p where p.idp not in (select cp.personnes_idp\n"
			+ " from chantier_personnes cp where cp.chantier_num_ch = ?1 )")
	public List<Object[]> getPersonnesNonAffecter(String num_ch);

	@Modifying
	@Query(nativeQuery = true, value = "delete from chantier_personnes where chantier_num_ch = ?1 and personnes_idp  = ?2")
	public void removePersonneFromChantier(String num_ch, int idPersonne);

}
