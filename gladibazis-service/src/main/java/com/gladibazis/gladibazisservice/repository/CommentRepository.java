package com.gladibazis.gladibazisservice.repository;

import com.gladibazis.gladibazisservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByGladiolusId(Long gladiolus_id);
}
