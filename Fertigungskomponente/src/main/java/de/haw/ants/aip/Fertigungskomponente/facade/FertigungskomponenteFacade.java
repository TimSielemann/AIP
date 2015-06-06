package de.haw.ants.aip.Fertigungskomponente.facade;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import de.haw.ants.aip.Fertigungskomponente.businesslogic.FertigungBusinessLogic;
import de.haw.ants.aip.Fertigungskomponente.entity.Fertigungsauftrag;

public class FertigungskomponenteFacade implements IFertigungsservice {

	@Autowired
	private FertigungBusinessLogic feBuLo;
	@Override
	public Fertigungsauftrag erstelleFertigungsauftrag(long bauteilId,Date endtermin) {
	return	feBuLo.erstelleFertigungsauftrag(bauteilId,endtermin);
	}
	@Override
	public boolean loescheFertigungsauftrag(long fertigungsAuftragId) {
		
		return feBuLo.loescheFertigungsauftrag(fertigungsAuftragId);
	}
	@Override
	public boolean speichereFertigungsauftrag(
			Fertigungsauftrag fertigungsAuftrag) {
		// TODO Auto-generated method stub
		return feBuLo.speichereFertigungauftrag(fertigungsAuftrag);
	}
	@Override
	public Fertigungsauftrag holeFertigungsauftrag(long fertigungsAuftragId) {
		// TODO Auto-generated method stub
		return feBuLo.holeFertigungsauftrag(fertigungsAuftragId);
	}

}
