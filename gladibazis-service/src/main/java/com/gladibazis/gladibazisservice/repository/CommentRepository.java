package com.gladibazis.gladibazisservice.repository;

import com.gladibazis.gladibazisservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
