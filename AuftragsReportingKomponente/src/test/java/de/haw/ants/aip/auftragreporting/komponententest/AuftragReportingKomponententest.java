package de.haw.ants.aip.auftragreporting.komponententest;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import de.haw.ants.aip.Fertigungskomponente.entity.Bauteil;
import de.haw.ants.aip.Fertigungskomponente.entity.Fertigungsauftrag;
import de.haw.ants.aip.Fertigungskomponente.facade.IFertigungsservice;
import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.facade.interfaces.IAuftragService;
import de.haw.ants.aip.auftrag.reporting.services.AuftragReportingServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=de.haw.ants.aip.auftragreporting.komponententest.AuftragReportingKomponententest.ContextConfiguration.class)
public class AuftragReportingKomponententest {

	    @Configuration
		@ComponentScan(basePackages = "de")
		// Note: there is no @PropertySource("classpath:application.properties") as this is taken from DatabaseConfig.class
	    static class ContextConfiguration {
	    	@Bean
	    	public IAuftragService iAuftragService(){
	    		return new AuftragReportingServiceImpl();
	    	}
		}
	
	
	@Autowired
	private IAuftragService iAuftragService;
	

    @Test
    public void createAuftrag() {
    	Auftrag auftrag = new Auftrag(1L, 374.23, 1L);
    	auftrag = this.iAuftragService.erstelleAuftrag(auftrag);
    	Assert.notNull(auftrag.getId());    	
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void createAuftragFail(){
    	Auftrag auftrag = new Auftrag(1L, 374.23, 1L);
    	auftrag.setId(1L);
    	auftrag = this.iAuftragService.erstelleAuftrag(auftrag);  
    }
}


