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
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
  private Long id;
  @NonNull
  @Column(unique = true)
  private String username;
  @NonNull
  private String password;


}
