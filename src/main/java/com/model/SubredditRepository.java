package com.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
  Post findByTitle(String title);
}
