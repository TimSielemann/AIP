package de.haw.ants.aip.web.boot;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import de.haw.ants.aip.config.AppConfiguration;
import de.haw.ants.aip.web.controller.MainController;


@Configuration
@EnableAutoConfiguration
@PropertySource("classpath:application-dump.properties") // this allows us to configure our database via the application.properties file
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {

    	ConfigurableApplicationContext ctx = SpringApplication.run(
    			new Object[]{
    					Application.class, // the application
    					AppConfiguration.class, // the configuration of this application services and entities (see spring.services)
    					StartupInitializerWeb.class, // the data population
    					MainController.class // the main controller to supply the rest interface to the outside world
    			}, args); 
    }
}
