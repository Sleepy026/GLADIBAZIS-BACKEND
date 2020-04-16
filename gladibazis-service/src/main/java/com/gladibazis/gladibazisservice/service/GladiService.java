package com.gladibazis.gladibazisservice.service;

import com.gladibazis.gladibazisservice.controller.dto.CommentCredentials;
import com.gladibazis.gladibazisservice.controller.dto.GladiCredentials;
import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GladiService {

    @Autowired
    private GladiolusRepository gladiolusRepository;

    public String registerNewVariety(GladiCredentials gladiCredentials){
        String response = "The flower has successfuly created.";
        try {
            gladiolusRepository.save(
                    Gladiolus.builder()
                            .color(gladiCredentials.getColor())
                            .name(gladiCredentials.getName())
                            .height(gladiCredentials.getHeight())
                            .pictures(gladiCredentials.getPictures())
                            .totalScore(0)
                            .numberOfVotes(0)
                            .build()
            );
        } catch (Exception e){
            response = "This variety already exist.";
        };
        return response;
    }

    public String addNewComment(CommentCredentials commentCredentials){
        String resp = "New comment added.";
        Gladiolus gladi = gladiolusRepository.findById(commentCredentials.flowerId).orElseThrow();
        return "ok";
    }

}
