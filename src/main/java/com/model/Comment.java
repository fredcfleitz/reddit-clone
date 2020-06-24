package com.model;

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
public class Comment {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
  private Long id;
  @NonNull
  private String parent;
  private String content;
  private String user;


}
