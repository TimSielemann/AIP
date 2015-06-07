package de.haw.ants.aip.auftrag.facade.interfaces;

import java.util.Collection;
import java.util.List;

import de.haw.ants.aip.auftrag.entity.Auftrag;

public interface IAuftragService {
	
	public Auftrag erstelleAuftrag(Auftrag auftrag);
	
	/**
	 * Nicht im akutellen Usecase benötigt
	 * @param auftragsnr
	 * @return
	 */
	public Auftrag auftragAusliefern(Long auftragsnr);
	
	/**
	 * Nicht im aktuellen Usecase benötigt
	 * @param auftragsnr
	 * @return
	 */
	public Auftrag auftragBezahlen(Long auftragsnr);
	
	/**
	 * gibt alle Aufträge für einen Kunden aus
	 */
	public List<Auftrag> getAuftragForKunde(long kundennr);
}
