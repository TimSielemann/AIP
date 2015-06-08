package de.haw.ants.aip.web.controller;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

public class MonitorThread implements Runnable {
	
	private RestTemplate restTemplate = new RestTemplate();
	private int port;
	private Thread thread;
	
	public MonitorThread(int port, Thread thread){
		this.port = port;
		this.thread = thread;
	}
	
	@Override
	public void run() {
		while (thread.isAlive()){
			RequestEntity<String> entity;
				entity = new RequestEntity<String>(HttpMethod.POST, URI.create("http://localhost:8081/active"));
			
				restTemplate.exchange("http://localhost:8081/alive", HttpMethod.POST, entity, String.class);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
