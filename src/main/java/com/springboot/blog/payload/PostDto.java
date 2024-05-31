package com.springboot.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;

    @NotEmpty
    @Size(min = 2, max = 255, message = "Title must be between 3 and 255 characters")
    private String title;

    @NotEmpty
    @Size(min = 10, max = 255, message = "Description must be between 3 and 255 characters")
    private String description;

    @NotEmpty
    @Size(min = 3, message = "Content must be at least 3 characters")
    private String content;


    private Set<CommentDto> comments;
}
