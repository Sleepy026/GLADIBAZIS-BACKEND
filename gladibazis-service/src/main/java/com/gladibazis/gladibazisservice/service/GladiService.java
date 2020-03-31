package com.gladibazis.gladibazisservice.service;

import com.gladibazis.gladibazisservice.controller.dto.GladiCredentials;
import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                            .height(gladiCredentials.getHeigth())
                            .build()
            );
        } catch (Exception e){
            response = "This variety already exist.";
        };
        return response;
    }

}
