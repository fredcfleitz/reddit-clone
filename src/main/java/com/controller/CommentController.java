package com.controller;

import com.model.Comment;
import com.model.CommentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class CommentController {

  private CommentRepository commentRepository;

  public CommentController(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @GetMapping("/comments")
  Collection<Comment> comments() {
    return commentRepository.findAll();
  }

  @GetMapping("/comments/{parent}")
  Collection<Comment> comments(@PathVariable String parent) {
    return commentRepository.findByParent(parent);
  }

  @PostMapping("/comments")
  ResponseEntity<Comment> createComment(@RequestBody Comment comment) throws URISyntaxException {
        Comment result = commentRepository.save(comment);
        return ResponseEntity.created(new URI("/api/comments/" + result.getId()))
                .body(result);
    }



}
