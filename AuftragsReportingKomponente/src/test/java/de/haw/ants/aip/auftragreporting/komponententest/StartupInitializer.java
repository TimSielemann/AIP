package de.haw.ants.aip.auftragreporting.komponententest;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.haw.ants.aip.Fertigungskomponente.entity.Bauteil;
import de.haw.ants.aip.Fertigungskomponente.entity.Stueckliste;
import de.haw.ants.aip.Fertigungskomponente.entity.StuecklistePosition;
import de.haw.ants.aip.Fertigungskomponente.repository.BauteilRepository;
import de.haw.ants.aip.kunden.entitys.Kunde;
import de.haw.ants.aip.kunden.repositories.KundenRepository;


@Component
@Transactional
public class StartupInitializer implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartupInitializer.class);
	
	@Autowired
	private BauteilRepository bauteilRepository;
	
	@Autowired
	private KundenRepository userRepository;
//
//	@Autowired
//	private TodoRepository todoRepository;
//	
//	@Autowired
//	private TopicRepository topicRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// startup of root context, refresh will trigger for initialization and refresh of context
		if (event.getApplicationContext().getParent() == null) {
			configure();
		}
	}

	private void configure() {
		LOGGER.info("setup db.");
		
		Bauteil b = new Bauteil();
		b.setAnzahl(1);

		b.setModellnummer("A123456");
		b.setName("Schraube");
		StuecklistePosition pos = new StuecklistePosition();
		pos.setBauteil(b);
		pos.setPosition(1l);
		ArrayList<StuecklistePosition> list = new ArrayList();
		Stueckliste stueckliste = new Stueckliste();
		list.add(pos);
		stueckliste.setBauteil(b);
		stueckliste.setPos(list);
		
		bauteilRepository.save(b);
		
		Kunde k = new Kunde();
		k.setNachname("Mustermann");
		k.setVorname("Max");
		k.setStadt("Hamburg");
		
		this.userRepository.save(k);
	}
}
