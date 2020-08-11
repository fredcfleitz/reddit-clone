package com.model;

import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@EntityListeners(AuditingEntityListener.class)
public class Subreddit {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
  private Long id;
  @NonNull
  private String title;
  @CreatedBy
  private String user;
  //final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();


}
