package de.haw.ants.aip.kunden.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.haw.ants.aip.kunden.businesslogic.KundenBusinessLogic;
import de.haw.ants.aip.kunden.entitys.Kunde;
import de.haw.ants.aip.kunden.facade.interfaces.IKundenService;
import de.haw.ants.aip.repositories.KundenRepository;
@Service
public class KundenServiceImpl implements IKundenService {
	
	private KundenBusinessLogic businessLogic;
	
	@Autowired
	protected KundenRepository userRepository;
	
	protected EntityManager entityManager;
	
	
	 
	@PersistenceContext 
	public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	       
	}
	
	public KundenServiceImpl(){
		this.businessLogic = new KundenBusinessLogic();
	}
	
	@Override
	public Kunde erstelleKunde(Kunde kunde) {
		return businessLogic.erstelleKunde(kunde, userRepository);
	}

	@Override
	public Kunde getKunde(long id) {
		return businessLogic.findKundeById(id, userRepository);
	}

}
