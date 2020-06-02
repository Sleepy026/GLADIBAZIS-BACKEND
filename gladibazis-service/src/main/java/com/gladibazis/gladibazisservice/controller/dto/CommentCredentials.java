package com.gladibazis.gladibazisservice.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentCredentials {

    public Long flowerId;
    public String userName;
    public String comment;
}
