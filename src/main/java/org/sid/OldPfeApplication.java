package org.sid;

import org.sid.entities.AchatMateriel;
import org.sid.entities.AchatMaterielChantier;
import org.sid.entities.AchatMaterielEtudePrice;
import org.sid.entities.AppelOffre;
import org.sid.entities.BesoinTransverse;
import org.sid.entities.CategorieMateriel;
import org.sid.entities.Category;
import org.sid.entities.Chantier;
import org.sid.entities.Decompte;
import org.sid.entities.Engin;
import org.sid.entities.Entretien;
import org.sid.entities.EtudePrice;
import org.sid.entities.InstallationChantier;
import org.sid.entities.Materiel;
import org.sid.entities.Ouvrage;
import org.sid.entities.Personne;
import org.sid.entities.Reparation;
import org.sid.entities.Role;
import org.sid.entities.Soumission;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class OldPfeApplication implements CommandLineRunner {
	@Autowired private RepositoryRestConfiguration configuration;
	public static void main(String[] args) {
		SpringApplication.run(OldPfeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(User.class, Role.class, AchatMateriel.class, AchatMaterielChantier.class,
				AchatMaterielEtudePrice.class, AppelOffre.class, BesoinTransverse.class, CategorieMateriel.class,
				Category.class, Chantier.class, Decompte.class, Engin.class, Entretien.class, EtudePrice.class,
				Materiel.class, Ouvrage.class, Personne.class, Reparation.class, Soumission.class,
				InstallationChantier.class);


	}

}
