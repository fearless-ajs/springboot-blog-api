package com.springboot.blog.payload;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String name;
    private String email;
    private String body;
}
