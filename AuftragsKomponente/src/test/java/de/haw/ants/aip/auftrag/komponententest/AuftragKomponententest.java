package de.haw.ants.aip.auftrag.komponententest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.facade.interfaces.IAuftragService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=de.haw.ants.aip.auftrag.komponententest.AuftragKomponententest.ContextConfiguration.class)
public class AuftragKomponententest {

	@ComponentScan(basePackages = "de.haw.ants.aip")
	@Configuration
    static class ContextConfiguration {}

	@Autowired
	private IAuftragService auftragService;
	
    

    @Test
    public void createAuftrag() {
    	Auftrag auftrag = new Auftrag(1L, 374.23, 1L);
    	auftrag = this.auftragService.erstelleAuftrag(auftrag);
    	Assert.notNull(auftrag.getId());    	
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void createAuftragFail(){
    	Auftrag auftrag = new Auftrag(1L, 374.23, 1L);
    	auftrag.setId(1L);
    	auftrag = this.auftragService.erstelleAuftrag(auftrag);  
    }
}


