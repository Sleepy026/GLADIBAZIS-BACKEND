package com.gladibazis.gladibazisservice.controller;

import com.gladibazis.gladibazisservice.controller.dto.CommentCredentials;
import com.gladibazis.gladibazisservice.controller.dto.GladiCredentials;
import com.gladibazis.gladibazisservice.model.Comment;
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
    public String createNewGladi(@RequestBody GladiCredentials gladiolus){
        return gladiService.registerNewVariety(gladiolus);
    }

    @PostMapping("/get_comments_by_flower")
    public List<Comment> getCommentsByFlower(@RequestBody Gladiolus gladiolus){
        return gladiService.getCommentsByFlower(gladiolus);
    }

    @PostMapping("/new_comment")
    public String addNewComment(@RequestBody Comment comment){
        return gladiService.addNewComment(comment);
    }

    @PostMapping("/remove_comment")
    public String removeComment(@RequestBody Comment comment){
        return gladiService.removeComment(comment);
    }
}
