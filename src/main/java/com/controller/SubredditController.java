package com.controller;

import com.model.Subreddit;
import com.model.SubredditRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class SubredditController {

  private SubredditRepository subredditRepository;

  public SubredditController(SubredditRepository subredditRepository) {
    this.subredditRepository = subredditRepository;
  }

  @GetMapping("/subreddits")
  Collection<Subreddit> subreddits() {
    return subredditRepository.findAll();
  }

  @PostMapping("/subreddits")
  ResponseEntity<Subreddit> createSubreddit(@RequestBody Subreddit subreddit) throws URISyntaxException {
        Subreddit result = subredditRepository.save(subreddit);
        return ResponseEntity.created(new URI("/api/subreddits/" + result.getId()))
                .body(result);
    }

}
