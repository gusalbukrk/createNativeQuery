package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomTableController {
  private CustomTableRepository customTableRepository;

  public CustomTableController(CustomTableRepository customTableRepository) {
    this.customTableRepository = customTableRepository;
  }

  @GetMapping("/describe/{table}")
  public List<Describe> index(@PathVariable String table) {
    return customTableRepository.doSomeQuery(table);
  }

  @GetMapping("/view/{table}")
  public <T> List<T> view(@PathVariable String table) {
  // public <T extends Map<String, Object>> List<T> view(@PathVariable String table) {
    List<Describe> d = customTableRepository.doSomeQuery(table);
    System.out.println(d);

    return customTableRepository.view(table);
  }

  @GetMapping("/insert/{table}")
  public int insert(@PathVariable String table) {
    return customTableRepository.create(table);
  }
}
