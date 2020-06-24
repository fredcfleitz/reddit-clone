package com.model;
import 'bootstrap/dist/css/bootstrap.min.css';

import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Post {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
  private Long id;
  @NonNull
  private String title;
  private String content;
  private String subreddit;
  private String user;


}
