package de.haw.ants.aip.Fertigungskomponente.facade;

import java.sql.Date;

import de.haw.ants.aip.Fertigungskomponente.entity.Fertigungsauftrag;

public interface IFertigungsservice {
	public Fertigungsauftrag erstelleFertigungsauftrag(long bauteilId,Date endtermin);
	public boolean loescheFertigungsauftrag(long fertigungsAuftragId);
	public boolean speichereFertigungsauftrag(Fertigungsauftrag fertigungsAuftrag);
	public Fertigungsauftrag holeFertigungsauftrag(long fertigungsAuftragId);
}
