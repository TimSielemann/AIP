package de.haw.ants.aip.kunden.komponententest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import de.haw.ants.aip.kunden.entitys.Kunde;
import de.haw.ants.aip.kunden.facade.interfaces.IKundenService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=de.haw.ants.aip.kunden.komponententest.KundenKomponententest.ContextConfiguration.class)
public class KundenKomponententest {

	@ComponentScan(basePackages = "de.haw.ants.aip")
	@Configuration
    static class ContextConfiguration {}

	@Autowired
	private IKundenService kundenService;
	
    

    @Test
    public void createKunde() {
    	Kunde kunde = new Kunde();
    	kunde.setNachname("Test");
    	kunde.setVorname("Tim");
    	kunde.setStadt("Hamburg");
    	Kunde kundeCreated = kundenService.erstelleKunde(kunde);
    	Assert.notNull(kundeCreated);
    	Kunde getKunde = kundenService.getKunde(kundeCreated.getId());
    	Assert.isTrue(kundeCreated.equals(getKunde));
    }
}


