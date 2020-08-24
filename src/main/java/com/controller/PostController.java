package com.controller;

import com.model.Post;
import com.model.PostRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import java.io.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
class PostController{

  private PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping("/posts")
  Collection<Post> posts() {
    return postRepository.findAll();
  }

  @GetMapping("/posts/{id}")
  ResponseEntity<?> getPost(@PathVariable Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/r/{subreddit}/posts")
  Collection<Post> getSubredditPosts(@PathVariable String subreddit) {
    return postRepository.findBySubreddit(subreddit);
  }

  @PostMapping("/posts")
  ResponseEntity<Post> createPost(@RequestBody Post post) throws URISyntaxException {
        Post result = postRepository.save(post);
        return ResponseEntity.created(new URI("/api/posts/" + result.getId()))
                .body(result);
    }

  @PostMapping(path = "/postz", consumes = { "multipart/form-data" })
  ResponseEntity<Post> createDataPost(@ModelAttribute("data") MultipartFile data,
  @ModelAttribute("title") String title, @ModelAttribute("user") String user) throws URISyntaxException, IOException {
        Post post = new Post();
        post.setData(data.getBytes());
        post.setTitle(title);
        post.setUser(user);
        Post result = postRepository.save(post);
        return ResponseEntity.created(new URI("/api/posts/" + result.getId()))
                .body(result);
    }

  @PutMapping("/posts/{id}/upvote")
  String upvotePost(@PathVariable Long id) {
        Post post = postRepository.getOne(id);
        post.setScore(post.getScore() + 1);
        postRepository.save(post);
        return "";
      }

  @PutMapping("/posts/{id}/downvote")
  String downvotePost(@PathVariable Long id) {
        Post post = postRepository.getOne(id);
        post.setScore(post.getScore() - 1);
        postRepository.save(post);
        return "";
      }

}
