package de.haw.ants.aip.web.boot;

import java.sql.SQLException;

import org.h2.tools.Server;

import de.haw.ants.aip.web.controller.MainController;
import de.haw.ants.aip.web.controller.MonitorThread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import de.haw.ants.aip.config.AppConfiguration;
public class MultiApplication {
	
	@Configuration
	@PropertySource("classpath:application-dump.properties") // this allows us to configure our database via the application.properties file
	public static class DatabaseSetupConfiguration{}
	
	public static class BaseApplication {
		private int port = 8080;
		public void setPort(int port) {this.port = port;}
		public int getPort(){return this.port;}
	
		public BaseApplication(){
			super();
			Thread thread = new Thread(new MonitorThread(this.port, Thread.currentThread()));
			thread.start();
		}
		// This is necessary to programmatically define the port of the application
		@Bean
		public EmbeddedServletContainerFactory servletContainer() {
			System.out.println("Starting server at port: "+port);
			return new JettyEmbeddedServletContainerFactory(getPort());
		}
		
		
	}
	
	@Configuration
	@EnableAutoConfiguration
	@ConfigurationProperties(prefix="application1") // the port property is prefixed by the application name
	@PropertySource("classpath:application-nodump.properties") // different properties for different spring contexts.
	public static class Application1 extends BaseApplication {}
	
	@Configuration
	@EnableAutoConfiguration
	@ConfigurationProperties(prefix="application2") // the port property is prefixed by the application name
	@PropertySource("classpath:application-nodump.properties") // different properties for different spring contexts.
	public static class Application2 extends BaseApplication {}
	
	public static void main(String[] args) throws SQLException {
		// setup database server
		try {
			new Server().runTool(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Database Server started");
		
		// populate data with configuration application.properties
		try(ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(
				DatabaseSetupConfiguration.class, // the application
				AppConfiguration.class, // the configuration of this application services and entities (see spring.services)
				StartupInitializerWeb.class // the data population
			)) {
		}
		
		startServer(Application1.class);
		
		startServer(Application2.class);
	}

	private static void startServer(Class<?/* extends BaseApplication*/> config) {
		Thread serverThread = new Thread(()->{
	    	ConfigurableApplicationContext ctx = SpringApplication.run(
	    			new Object[]{
	    					config, // the application
	    					AppConfiguration.class, // the configuration of this application services and entities (see spring.services)
	    					MainController.class // the main controller to supply the rest interface to the outside world
	    			}, new String[0]);
		});
		serverThread.start();
	}
}
