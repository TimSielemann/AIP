package de.haw.ants.aip.kunden.facade.interfaces;

import de.haw.ants.aip.kunden.entitys.Kunde;

public interface IKundenService {
	public Kunde erstelleKunde(Kunde kunde);
	
	public Kunde getKunde(long id);
}
