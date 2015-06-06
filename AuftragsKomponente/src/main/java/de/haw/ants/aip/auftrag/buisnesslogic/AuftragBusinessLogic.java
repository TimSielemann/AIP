package de.haw.ants.aip.auftrag.buisnesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.repositories.AuftragsRepository;

@Component
public class AuftragBusinessLogic {
	
	@Autowired
	private AuftragsRepository repo;
	
	public Auftrag erstelleAuftrag(Auftrag auftrag) {
		//TODO Fertigungsauftrag erstellen
		auftrag.setFertigungsauftrag(1L);
		repo.save(auftrag);
		return auftrag;
	}
	
	
}
