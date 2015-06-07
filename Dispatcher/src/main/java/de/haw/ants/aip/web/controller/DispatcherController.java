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
public class DispatcherController {

	private static final String URL1 = "http://localhost:47583";
	private static final String URL2 = "http://localhost:23847";

	private int lastRequest = 1;
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value="**", method = RequestMethod.POST)
	public Object doPost(@RequestBody() String body, RequestEntity<String> request, HttpServletRequest httprequest) {
		System.out.println("POST!");
		System.out.println("Body: " + body);
		System.out.println("Length: " + httprequest.getContentLength());
		String url = getNextUrl()
				+ (String) httprequest
				.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		System.out.println("URL: " + url);
		return restTemplate
				.postForObject(url, request, String.class);
	}

	private synchronized String getNextUrl() {
		if (this.lastRequest == 1) {
			this.lastRequest = 2;
			System.out.println("URL Anfrage an:" + URL2);
			return URL2;
		}
		System.out.println("URL Anfrage an:" + URL1);
		this.lastRequest = 1;
		return URL1;
	}

	
	@RequestMapping(value="*.html", 
			  method=RequestMethod.GET)
			  //produces=MediaType.APPLICATION_JSON_VALUE)
			public Object doIndex(HttpServletRequest request) {
				  System.out.println((String) request.getAttribute(
					        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
				  System.out.println("index....");
				  HttpHeaders headers = new HttpHeaders();
				  headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
				  HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

				  ResponseEntity<String> response = this.restTemplate.exchange(getNextUrl() + (String) request.getAttribute(
					        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE), HttpMethod.GET, entity, String.class);
				  String responseBody = response.getBody();
				  return responseBody;

			}
	

//	
	@RequestMapping(value="**", 
			  method=RequestMethod.GET)
			  //produces=MediaType.APPLICATION_JSON_VALUE)
			public Object doGet(HttpServletRequest request) {
				  System.out.println((String) request.getAttribute(
					        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
				  Object o = restTemplate.getForObject(getNextUrl() + (String) request.getAttribute(
					        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE), Object.class);
				  System.out.println("Ergebnis: " + o);
				  System.out.println(o.getClass());
				  return o;
			}
		    
}