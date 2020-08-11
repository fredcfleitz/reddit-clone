package com.model;

import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
//import com.model.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;


//import org.springframework.security.core.context.SecurityContextHolder;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@EntityListeners(AuditingEntityListener.class)
public class Post {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
  private Long id;
  @NonNull
  private String title;
  private String content;
  private String subreddit;
  @CreatedBy
  private String user;
  //final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();


}
