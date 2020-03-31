package com.gladibazis.gladibazisservice;

import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.model.Picture;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import com.gladibazis.gladibazisservice.repository.PictureRepository;
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

	@Autowired
	private PictureRepository pictureRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(GladibazisServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(){
		return args -> {

			Gladiolus flevo_beach = Gladiolus.builder()
					.name("Flevo Beach")
					.height(140)
					.color("Orange")
					.picture("https://i.dailymail.co.uk/i/pix/2011/06/16/article-2004158-0C8DDB0C00000578-229_224x284.jpg")
					.build();

			Gladiolus red_balance = Gladiolus.builder()
					.name("Red Balance")
					.height(140)
					.color("Red")
					.comment("Ez szep")
					.picture("https://www.stoopflowerbulb.nl/site/assets/files/1071/website_stoop_groot_bloemig26.jpg")
					.build();

			gladiolusRepository.save(flevo_beach);
			gladiolusRepository.save(red_balance);

		};
	}

}
