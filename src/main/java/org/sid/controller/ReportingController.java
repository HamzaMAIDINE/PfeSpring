package org.sid.controller;

import java.util.List;

import org.sid.services.Reporting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingController {

	@Autowired
	private Reporting reporting;

	@GetMapping("/getNbPersonnesPerChantier")
	public List<Object[]> getNbPersonnesPerChantier() {
		return reporting.getNbPersonnesPerChantier();
	}

	@GetMapping("/getNbReparationsPerChantier")
	public List<Object[]> getNbReparationsPerChantier() {
		return reporting.getNbReparationsPerChantier();
	}

	@GetMapping("/getNbChantierPerAppelOffre")
	public List<Object[]> getNbChantierPerAppelOffre() {
		return reporting.getNbChantierPerAppelOffre();
	}
}
