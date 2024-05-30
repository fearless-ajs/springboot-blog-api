package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Add a method to create a comment
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable(name = "postId") long postId,
            @RequestBody CommentDto commentDto
    ) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }
    // Add a method to get all comments
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getAllComments(
            @PathVariable(name = "postId") long postId
    ) {
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }
    // Add a method to get a comment by id
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(name = "postId") long postId,
            @PathVariable(name = "id") long id
    ) {
        return new ResponseEntity<>(commentService.getCommentById(postId, id), HttpStatus.OK);
    }

    // Add a method to update a comment by id
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable(name = "postId") long postId,
            @PathVariable(name = "id") long id,
            @RequestBody CommentDto commentDto
    ) {
        return new ResponseEntity<>(commentService.updateComment(postId, id, commentDto), HttpStatus.OK);
    }
    // Add a method to delete a comment by id
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(name = "postId") long postId,
            @PathVariable(name = "id") long id
    ) {
        commentService.deleteComment(postId, id);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }


}
