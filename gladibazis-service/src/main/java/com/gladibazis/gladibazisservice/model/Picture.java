package com.gladibazis.gladibazisservice.model;

import com.gladibazis.gladibazisservice.service.GladiService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Picture {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gladi_id", nullable = false)
    private Gladiolus gladi;

    private String url;
}
