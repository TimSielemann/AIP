package de.haw.ants.aip.kunden.businesslogic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import de.haw.ants.aip.kunden.entitys.Kunde;
import de.haw.ants.aip.kunden.repositories.KundenRepository;

public class KundenBusinessLogic {
	


	public Kunde erstelleKunde(Kunde kunde, KundenRepository userRepository){
		//entityManager.persist(kunde);
		userRepository.save(kunde);
		return kunde;
	}
	
	public Kunde findKundeById(long kundenNr, KundenRepository userRepository){
		return userRepository.findOne(kundenNr);//entityManager.find(Kunde.class, kundenNr);
	}
}
