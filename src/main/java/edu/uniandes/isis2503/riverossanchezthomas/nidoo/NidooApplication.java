package edu.uniandes.isis2503.riverossanchezthomas.nidoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:auth0.properties") })
public class NidooApplication {

	public static void main(String[] args) {
		SpringApplication.run(NidooApplication.class, args);
	}
}
