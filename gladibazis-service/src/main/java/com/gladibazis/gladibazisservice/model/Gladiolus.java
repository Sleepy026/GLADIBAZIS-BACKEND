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
@EqualsAndHashCode(exclude = "pictures")
public class Gladiolus {

    @Id
    @GeneratedValue
    @Column(name = "gladiolus_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Integer height;

    @ElementCollection
    @Singular
    private List<String> comments = new ArrayList<>();

    @ElementCollection
    @Singular
    private Set<String> pictures = new HashSet<>();

}
