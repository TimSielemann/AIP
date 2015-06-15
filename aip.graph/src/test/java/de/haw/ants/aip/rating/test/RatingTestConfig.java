package de.haw.ants.aip.rating.test;

import de.haw.ants.aip.config.AppConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;



//@Configuration // not necessary as this is only used directly from the @ContextConfiguration or via subclasses
@PropertySource("classpath:application.properties") // this allows us to configure our database via the application.properties file
@ComponentScan(basePackageClasses={
		AppConfiguration.class,
		GraphStartupInitializer.class})
public class RatingTestConfig {}
