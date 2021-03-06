package de.haw.ants.aip.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Base configuration of Application referenced in web.xml or via spring setup
 *
 */
@Configuration
@ComponentScan(basePackages = "de")
public class AppConfiguration {
	public static final String PKG_PREFIX = "de";
}