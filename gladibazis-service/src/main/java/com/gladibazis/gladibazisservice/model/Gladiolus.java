package com.gladibazis.gladibazisservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@EqualsAndHashCode(exclude = "pictures")
public class Gladiolus {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String color;

    private Integer height;

    private Integer numberOfVotes;

    private Integer totalScore;

    @OneToMany(mappedBy = "gladiolus", cascade = {CascadeType.REMOVE,CascadeType.PERSIST}, orphanRemoval = true)
    @Singular
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private List<Comment> comments = new ArrayList<>();

    @ElementCollection
    @Singular
    private Set<String> pictures = new HashSet<>();



}
