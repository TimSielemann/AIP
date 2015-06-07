package com.mondula.training.spring.web.test;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


import de.haw.ants.aip.auftrag.entity.Auftrag;

public class RestTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestTest.class);

	private static final String URL1 		= "http://localhost:8080";
	private static final String URL2 		= "http://localhost:8081";

    
    @Test
    public void findAuftragByKunde() {
    	LOGGER.debug("start test");
    	RestTemplate restTemplate = new RestTemplate();
    	List u = restTemplate.getForObject(URL1+"/aufträge/2", List.class, 1L);
    	System.out.println(u);
    	List u2 = restTemplate.getForObject(URL2+"/aufträge/2", List.class, 1L);
    	System.out.println(u2);
    }
}
