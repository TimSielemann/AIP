package de.haw.ants.aip.auftrag.komponententest;

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

import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.facade.interfaces.IAuftragService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=de.haw.ants.aip.auftrag.komponententest.AuftragKomponententest.ContextConfiguration.class)
public class AuftragKomponententest {

	    //@Configuration
		@ComponentScan(basePackages = "de.haw.ants.aip")
		// Note: there is no @PropertySource("classpath:application.properties") as this is taken from DatabaseConfig.class
	    static class ContextConfiguration {
//
//			
//			@Bean(name="Fertigungsservice")
//			public de.haw.ants.aip.Fertigungskomponente.facade.IFertigungsservice Fertigungsservice() {
//				return new de.haw.ants.aip.Fertigungskomponente.facade.IFertigungsservice(){
//
//					@Override
//					public Fertigungsauftrag erstelleFertigungsauftrag(
//							long bauteilId, Date endtermin) {
//						Fertigungsauftrag fAuftrag = new Fertigungsauftrag();
//						fAuftrag.setId(1L);
//						return fAuftrag;
//					}
//
//					@Override
//					public boolean loescheFertigungsauftrag(
//							long fertigungsAuftragId) {
//						// TODO Auto-generated method stub
//						return false;
//					}
//
//					@Override
//					public boolean speichereFertigungsauftrag(
//							Fertigungsauftrag fertigungsAuftrag) {
//						// TODO Auto-generated method stub
//						return false;
//					}
//
//					@Override
//					public Fertigungsauftrag holeFertigungsauftrag(
//							long fertigungsAuftragId) {
//						Fertigungsauftrag fAuftrag = new Fertigungsauftrag();
//						fAuftrag.setId(1L);
//						return fAuftrag;
//					}
//
//					@Override
//					public boolean speichereBauteil(Bauteil b) {
//						// TODO Auto-generated method stub
//						return false;
//					}
//					
//				};
//			}
		}
	
	
	@Autowired
	private IAuftragService auftragService;
	
	@Autowired
//    private IFertigungsservice Fertigungsservice;

    @Test
    public void createAuftrag() {
//    	System.out.println(Fertigungsservice.erstelleFertigungsauftrag(1, new Date(0)));
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


