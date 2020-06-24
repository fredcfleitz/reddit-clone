package com.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  Collection<Comment> findByParent(String parent);
}
