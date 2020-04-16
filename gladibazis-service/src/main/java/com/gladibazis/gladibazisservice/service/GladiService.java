package com.gladibazis.gladibazisservice.service;

import com.gladibazis.gladibazisservice.controller.dto.CommentCredentials;
import com.gladibazis.gladibazisservice.controller.dto.GladiCredentials;
import com.gladibazis.gladibazisservice.model.Comment;
import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.repository.CommentRepository;
import com.gladibazis.gladibazisservice.repository.GladiolusRepository;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GladiService {

    @Autowired
    private GladiolusRepository gladiolusRepository;

    @Autowired
    private CommentRepository commentRepository;

    public String registerNewVariety(GladiCredentials gladiCredentials){
        try {
            gladiolusRepository.save(
                    Gladiolus.builder()
                            .color(gladiCredentials.getColor())
                            .name(gladiCredentials.getName())
                            .authorId(gladiCredentials.getAuthorId())
                            .height(gladiCredentials.getHeight())
                            .pictures(gladiCredentials.getPictures())
                            .totalScore(0)
                            .numberOfVotes(0)
                            .build()
            );
        } catch (Exception e){
            return "This variety already exist.";
        };
        return "The flower has successfuly created.";
    }

    public String addNewComment(Comment comment){
        try {
            Gladiolus gladi = gladiolusRepository.findById(comment.getFlowerId()).orElseThrow();
            comment.setGladiolus(gladi);
            comment.setDate(LocalDateTime.now());
            commentRepository.save(comment);

        } catch (Exception e){
            return "Something went wrong";
        }
        return "New comment added.";
    }

    public String removeComment(Long id) {
        try{
            commentRepository.deleteById(id);
        } catch (Exception e){
            return "Failed";
        }
        return "Success";
    }

    public List<Comment> getCommentsByFlower(Long id) {
        try {
            return commentRepository.findAllByGladiolusId(id);
        }catch (Exception e){
           return new ArrayList<>();
        }
    }
}
