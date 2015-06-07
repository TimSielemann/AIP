package de.haw.ants.aip.auftrag.buisnesslogic;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.repositories.AuftragsRepository;

@Component
public class AuftragBusinessLogic {
	
	@Autowired
	private AuftragsRepository repo;
	
	@Autowired
	//private IFertigungsservice fertigungskomp; 
	
	private static final long TWOWEEKS = 1000*60*60*24*14;
	
	public Auftrag erstelleAuftrag(Auftrag auftrag) {
		//TODO Fertigungsauftrag erstellen
	    auftrag.setFertigungsauftrag(1L);
		repo.save(auftrag);
		return auftrag;
	}
	
	public List<Auftrag> getAuftragForKunde(long kundennr) {
		return repo.findByKunde(kundennr);
	}
	
	
}
