package com.gladibazis.gladibazisservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String commentText;

    @ManyToOne
    private Gladiolus gladiolus;


}
