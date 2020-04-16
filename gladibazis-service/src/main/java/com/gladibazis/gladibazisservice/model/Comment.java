package com.gladibazis.gladibazisservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Transient
    private Long flowerId;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonIgnore
    private LocalDateTime date;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String commentText;

    @ManyToOne
    @JsonIgnore
    private Gladiolus gladiolus;


}
