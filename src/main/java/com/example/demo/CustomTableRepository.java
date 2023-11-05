package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

// import java.util.Map;

// import org.springframework.data.repository.CrudRepository;

// public interface CustomTableRepository extends CrudRepository<Map<String, Object>, Long> {
  
// }

@Repository
public class CustomTableRepository {

    EntityManager entityManager;

    public CustomTableRepository(EntityManager entityManager) {
      this.entityManager = entityManager;
    }

    public List<Describe> doSomeQuery(String table){
        Query query = entityManager.createNativeQuery("DESCRIBE db." + table, Describe.class);
        List<Describe> l = query.getResultList();
        System.out.println(l);
        return l;
    }

    public List<Fruits> view(String table) {
        Query query = entityManager.createNativeQuery("SELECT * FROM db." + table);
        List<Fruits> l = query.getResultList();
        System.out.println(l);
        return l;
    }
}
