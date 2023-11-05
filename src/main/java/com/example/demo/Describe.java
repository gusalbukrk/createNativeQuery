package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Describe {
  // @Id
  // public Integer id;
  @Id
  public String field;
  public String type;
}
