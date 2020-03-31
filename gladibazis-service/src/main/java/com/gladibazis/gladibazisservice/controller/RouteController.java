package com.gladibazis.gladibazisservice.controller;

import com.gladibazis.gladibazisservice.controller.dto.GladiCredentials;
import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import com.gladibazis.gladibazisservice.service.GladiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RouteController {

    @Autowired
    private GladiolusRepository gladiolusRepository;

    @Autowired
    private GladiService gladiService;

    @GetMapping("/all_gladiolus")
    public List<Gladiolus> getAllGladiolus(){
        return gladiolusRepository.findAll();
    }

    @PostMapping("/create_new_gladi")
    public ResponseEntity<String> createNewGladi(@RequestBody GladiCredentials gladiolus){
        String resp = gladiService.registerNewVariety(gladiolus);
        return ResponseEntity.ok(resp);
    }
}
