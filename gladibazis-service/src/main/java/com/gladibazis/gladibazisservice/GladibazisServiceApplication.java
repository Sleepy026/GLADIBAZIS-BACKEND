package com.gladibazis.gladibazisservice;

import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GladibazisServiceApplication {

	@Autowired
	private GladiolusRepository gladiolusRepository;

	public static void main(String[] args) {
		SpringApplication.run(GladibazisServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(){
		return args -> {
			Gladiolus flevo_sunset = Gladiolus.builder()
					.name("Flevo Beach")
					.height(160)
					.build();
			gladiolusRepository.save(flevo_sunset);
		};
	}

}
