package com.gladibazis.gladibazisservice;

import com.gladibazis.gladibazisservice.model.Comment;
import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.repository.CommentRepository;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class GladibazisServiceApplication {

	@Autowired
	private GladiolusRepository gladiolusRepository;

	@Autowired
	private CommentRepository commentRepository;

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

			Gladiolus flevo_beach1 = Gladiolus.builder()
					.name("Flevo Beach1")
					.height(140)
					.color("Orange")
					.picture("https://i.dailymail.co.uk/i/pix/2011/06/16/article-2004158-0C8DDB0C00000578-229_224x284.jpg")
					.build();
			Gladiolus flevo_beach2 = Gladiolus.builder()
					.name("Flevo Beach2")
					.height(140)
					.color("Orange")
					.picture("https://i.dailymail.co.uk/i/pix/2011/06/16/article-2004158-0C8DDB0C00000578-229_224x284.jpg")
					.build();
			Gladiolus flevo_beach3 = Gladiolus.builder()
					.name("Flevo Beach3")
					.height(140)
					.color("Orange")
					.picture("https://i.dailymail.co.uk/i/pix/2011/06/16/article-2004158-0C8DDB0C00000578-229_224x284.jpg")
					.build();
			Gladiolus flevo_beach4 = Gladiolus.builder()
					.name("Flevo Beach4")
					.height(140)
					.color("Orange")
					.picture("https://i.dailymail.co.uk/i/pix/2011/06/16/article-2004158-0C8DDB0C00000578-229_224x284.jpg")
					.build();

			Comment comment = Comment.builder()
					.commentText("Ez egy nagyon szep virag")
					.date(LocalDateTime.now())
					.userName("Mester")
					.build();

			Gladiolus red_balance = Gladiolus.builder()
					.name("Red Balance")
					.height(140)
					.color("Red")
					.comment(comment)
					.picture("https://www.stoopflowerbulb.nl/site/assets/files/1071/website_stoop_groot_bloemig26.jpg")
					.build();
			Gladiolus red_balance1 = Gladiolus.builder()
					.name("Red Balance1")
					.height(140)
					.color("Red")
					.picture("https://www.stoopflowerbulb.nl/site/assets/files/1071/website_stoop_groot_bloemig26.jpg")
					.build();
			Gladiolus red_balance2 = Gladiolus.builder()
					.name("Red Balance2")
					.height(140)
					.color("Red")
					.picture("https://www.stoopflowerbulb.nl/site/assets/files/1071/website_stoop_groot_bloemig26.jpg")
					.build();
			Gladiolus red_balance3 = Gladiolus.builder()
					.name("Red Balance3")
					.height(140)
					.color("Red")
					.picture("https://www.stoopflowerbulb.nl/site/assets/files/1071/website_stoop_groot_bloemig26.jpg")
					.build();

			comment.setGladiolus(red_balance);

			gladiolusRepository.save(red_balance);
			gladiolusRepository.save(flevo_beach);
			gladiolusRepository.save(flevo_beach1);
			gladiolusRepository.save(flevo_beach2);
			gladiolusRepository.save(flevo_beach3);
			gladiolusRepository.save(flevo_beach4);
			gladiolusRepository.save(red_balance1);
			gladiolusRepository.save(red_balance2);
			gladiolusRepository.save(red_balance3);
		};
	}

}
