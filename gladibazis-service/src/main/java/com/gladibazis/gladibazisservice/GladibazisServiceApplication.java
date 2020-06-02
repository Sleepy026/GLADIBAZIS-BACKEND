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
					.picture("https://i.pinimg.com/originals/60/82/8e/60828eac675883b67696d3bbf9d8b807.jpg")
					.build();

			Gladiolus pinkLady = Gladiolus.builder()
					.name("Pink Lady")
					.height(130)
					.color("Pink")
					.picture("https://florium.ua/media/catalog/product/cache/1/file/9df78eab33525d08d6e5fb8d27136e95/g/l/gladiolus-pink-lady-2_1.jpg")
					.picture("https://www.tocadoverde.com.br/media/catalog/product/cache/1/thumbnail/500x500/9df78eab33525d08d6e5fb8d27136e95/g/l/gladiolos-pink-lady-3.jpg")
					.build();



			Gladiolus flevoBreezer = Gladiolus.builder()
					.name("Flevo Breezer")
					.height(145)
					.color("Yellow")
					.picture("https://www.gapphotos.com/images/LargeWebPreview/0982/0982790.jpg")
					.picture("https://vankampenbulbs.eu/images/virtuemart/product/resized/Flevo%20Breezer_358x552.jpg")
					.build();

			Gladiolus extasi = Gladiolus.builder()
					.name("Extazy")
					.height(135)
					.color("Pink")
					.picture("https://i.pinimg.com/736x/b6/2e/41/b62e417d502093ff66e74974323b0a6f--gladiolus-flower-lilies.jpg")
					.picture("https://s3.amazonaws.com/cdn0.dutchbulbs.com/images/500/01203.jpg")
					.picture("https://image.jimcdn.com/app/cms/image/transf/none/path/s8166bc22bf9d2184/image/i429356c3c2d58445/version/1584219548/image.jpg")
					.build();

			Comment comment = Comment.builder()
					.commentText("Ez egy nagyon szep virag")
					.date(LocalDateTime.of(2019,12,21,12, 0))
					.author("Imre")
					.build();

			Comment comment2 = Comment.builder()
					.commentText("Ezt jol gondolja kedves kollega! Szerintem is ez a legszebb piros fajta, es meg a meleget is jol birja! Tudna segiteni nekem abban, kitol erdemes venni ilyen hagymat Horn kornyeken?")
					.date(LocalDateTime.now())
					.author("Gyuri")
					.build();

			Comment comment3 = Comment.builder()
					.commentText("Szerintem erdemes lenne megkeresnie Oud Koper-t vagy a Stoop-ot, naluk igen gazdag a valasztek.")
					.date(LocalDateTime.now())
					.author("Imre")
					.build();

			Comment comment4 = Comment.builder()
					.commentText("Ez a legkedveltebb piros fajta Maria napkor, mast nem tudtunk eladni 3 eve mar ilyenkor!")
					.date(LocalDateTime.now())
					.author("Kata")
					.build();

			Comment comment5 = Comment.builder()
					.commentText("Nyaron a tuzo meleg is jol birja, nem is szokott megegni mas fajtakkal ellentetben!! Csak ajanlani tudom!!")
					.date(LocalDateTime.now())
					.author("Jakab")
					.build();

			Gladiolus red_balance = Gladiolus.builder()
					.name("Red Balance")
					.height(140)
					.color("Red")
					.comment(comment)
					.comment(comment2)
					.comment(comment3)
					.comment(comment4)
					.comment(comment5)
					.picture("https://www.stoopflowerbulb.nl/site/assets/files/1071/website_stoop_groot_bloemig26.jpg")
					.picture("https://www.stoopflowerbulb.nl/site/assets/files/1192/website_stoop_groot_bloemig105.jpg")
					.build();


			comment.setGladiolus(red_balance);
			comment2.setGladiolus(red_balance);
			comment3.setGladiolus(red_balance);
			comment4.setGladiolus(red_balance);
			comment5.setGladiolus(red_balance);

			gladiolusRepository.save(red_balance);
			gladiolusRepository.save(extasi);
			gladiolusRepository.save(flevo_beach);
			gladiolusRepository.save(pinkLady);
			gladiolusRepository.save(flevoBreezer);

		};
	}

}
