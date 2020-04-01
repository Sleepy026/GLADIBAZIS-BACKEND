package com.gladibazis.gladibazisservice.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GladiCredentials {
    private String name;
    private String color;
    private Integer heigth;
    private List<String> pictures;
}
