package com.gladibazis.gladibazisservice.controller;

import com.gladibazis.gladibazisservice.controller.dto.CommentCredentials;
import com.gladibazis.gladibazisservice.controller.dto.GladiCredentials;
import com.gladibazis.gladibazisservice.model.Comment;
import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import com.gladibazis.gladibazisservice.service.GladiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/gladiolus")
public class RouteController {

    @Autowired
    private GladiolusRepository gladiolusRepository;

    @Autowired
    private GladiService gladiService;

    @GetMapping("/all")
    public List<Gladiolus> getAllGladiolus(){
        return gladiolusRepository.findAll();
    }

    @PostMapping("/add")
    public String createNewGladi(@RequestBody GladiCredentials gladiolus){
        return gladiService.registerNewVariety(gladiolus);
    }

    @GetMapping("/comments")
    public List<Comment> getCommentsByFlower(@RequestParam Long id){
        return gladiService.getCommentsByFlower(id);

    }

    @PostMapping("/comment/add")
    public String addNewComment(@RequestBody CommentCredentials comment){
        return gladiService.addNewComment(comment);
    }

    @DeleteMapping("/comment/{id}")
    public String removeComment(@PathVariable(name = "id") Long id){
        return gladiService.removeComment(id);
    }
}
