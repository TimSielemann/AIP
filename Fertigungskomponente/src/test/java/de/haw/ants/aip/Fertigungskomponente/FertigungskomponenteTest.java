package de.haw.ants.aip.Fertigungskomponente;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import de.haw.ants.aip.Fertigungskomponente.entity.Bauteil;
import de.haw.ants.aip.Fertigungskomponente.entity.Fertigungsauftrag;
import de.haw.ants.aip.Fertigungskomponente.entity.Stueckliste;
import de.haw.ants.aip.Fertigungskomponente.entity.StuecklistePosition;
import de.haw.ants.aip.Fertigungskomponente.facade.IFertigungsservice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = de.haw.ants.aip.Fertigungskomponente.FertigungskomponenteTest.ContextConfiguration.class)
public class FertigungskomponenteTest {

	@Configuration
	@ComponentScan(basePackages = "de.haw.ants.aip")
	static class ContextConfiguration {
	}

	@Autowired
	private IFertigungsservice fertService;

	@Test
	public void erstelleFertAuftragTest() {
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
		
		fertService.speichereBauteil(b);
		long week = 7 * 24 * 60 * 60 * 1000l;
		Date endtermin = new Date(System.currentTimeMillis() + week);
		Fertigungsauftrag auftrag = fertService.erstelleFertigungsauftrag(
				b.getId(), endtermin);
		Assert.notNull(auftrag);
		Assert.notNull(auftrag.getId());
	}

	@Test
	public void speichereFertAuftragTest() {
		Bauteil b = new Bauteil();
		b.setAnzahl(1);
		;
		b.setModellnummer("A123456");
		b.setName("Schraube");
		StuecklistePosition pos = new StuecklistePosition();
		pos.setBauteil(b);
		pos.setPosition(1l);
		ArrayList<StuecklistePosition> liste = new ArrayList<StuecklistePosition>();
		Stueckliste stueckliste = new Stueckliste();
		stueckliste.setBauteil(b);
		liste.add(pos);
		stueckliste.setPos(liste);
		fertService.speichereBauteil(b);
		long week = 7 * 24 * 60 * 60 * 1000l;
		Date endtermin = new Date(System.currentTimeMillis() + week);
		Fertigungsauftrag auftrag = fertService.erstelleFertigungsauftrag(
				b.getId(), endtermin);
		auftrag.setEndtermin(new Date(System.currentTimeMillis()));
		Fertigungsauftrag neuerAuftrag = auftrag;
		fertService.speichereFertigungsauftrag(neuerAuftrag);
		Assert.isTrue(fertService.holeFertigungsauftrag(auftrag.getId())
				.getEndtermin() != neuerAuftrag.getEndtermin());
	}

}
