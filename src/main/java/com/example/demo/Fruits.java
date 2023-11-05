package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fruits {
  @Id
  public int id;
  public String name;
  public String color;
}
