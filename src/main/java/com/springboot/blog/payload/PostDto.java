package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Schema(
        name = "PostDto",
        description = "This is the data transfer object for the Post entity"
)
public class PostDto {
    private long id;

    @Schema(description = "Title of the post", example = "Spring Boot Rest API")
    @NotEmpty
    @Size(min = 2, max = 255, message = "Title must be between 3 and 255 characters")
    private String title;

    @Schema(description = "Description of the post", example = "This is a tutorial on how to create a Rest API with Spring Boot")
    @NotEmpty
    @Size(min = 10, max = 255, message = "Description must be between 3 and 255 characters")
    private String description;

    @Schema(description = "Content of the post", example = "This is a tutorial on how to create a Rest API with Spring Boot")
    @NotEmpty
    @Size(min = 3, message = "Content must be at least 3 characters")
    private String content;

    private Set<CommentDto> comments;

    @Schema(description = "Category ID of the post", example = "1")
    private Long categoryId;
}
