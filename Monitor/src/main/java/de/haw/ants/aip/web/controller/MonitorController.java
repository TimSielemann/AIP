package de.haw.ants.aip.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerMapping;


@RestController
public class MonitorController {

	private HashMap<String, Long> aliveList = new HashMap<String, Long>();

	@RequestMapping(value="/alive", 
			  method=RequestMethod.POST)
			  //produces=MediaType.APPLICATION_JSON_VALUE)
			public void postAlive(HttpServletRequest request) {
				  aliveList.put(request.getRemoteAddr() + ":" + request.getRemotePort(), System.currentTimeMillis());
				  System.out.println("alive called: " + request.getRemoteAddr());
				  //return "ok";
			}
	
	@RequestMapping(value="/isAlive", 
			  method=RequestMethod.GET,
			  produces=MediaType.APPLICATION_JSON_VALUE)
			public Object getAlive() {	
				  StringBuilder builder = new StringBuilder();
				  builder.append("Following Servers are alive: " );
				  for (String key: this.aliveList.keySet()){
					  if (System.currentTimeMillis() - this.aliveList.get(key).longValue() < 30000){
						  builder.append(key + "	");
					  }
				  }
				  return builder.toString();
			}
		    
}