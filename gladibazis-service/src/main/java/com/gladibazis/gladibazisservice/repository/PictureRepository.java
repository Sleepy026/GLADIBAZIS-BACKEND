package com.gladibazis.gladibazisservice.repository;

import com.gladibazis.gladibazisservice.model.Gladiolus;
import com.gladibazis.gladibazisservice.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
