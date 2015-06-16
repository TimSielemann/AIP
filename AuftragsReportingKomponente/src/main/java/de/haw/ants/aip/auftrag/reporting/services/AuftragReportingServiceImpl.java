package de.haw.ants.aip.auftrag.reporting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ants.aip.rating.graph.nodes.KundeNode;
import de.ants.aip.rating.graph.nodes.ProduktNode;
import de.ants.aip.rating.services.RatingService;
import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.facade.AuftragServiceImpl;
import de.haw.ants.aip.auftrag.facade.interfaces.IAuftragService;
import de.haw.ants.aip.kunden.entitys.Kunde;
import de.haw.ants.aip.kunden.facade.interfaces.IKundenService;
@Service
public class AuftragReportingServiceImpl extends AuftragServiceImpl implements
		IAuftragService {
	
	@Autowired 
	private RatingService ratingService;
	
	@Autowired
	private IKundenService kundenService;
	
	
	@Override
	public Auftrag erstelleAuftrag(Auftrag auftrag) {
		Auftrag retAuftrag = super.erstelleAuftrag(auftrag);
		Kunde kunde = kundenService.getKunde(auftrag.getId());
		
		KundeNode kundeNode = ratingService.getOrCreateKunde(kunde.getId(), kunde.getNachname(), kunde.getStadt());		
		ProduktNode produktNode = ratingService.getOrCreateProdukt(auftrag.getBauteilnr(), "Test");
		
		ratingService.addBestellung(kundeNode, produktNode, 1);
		
		return retAuftrag;
		
		
	}
	
	

}
