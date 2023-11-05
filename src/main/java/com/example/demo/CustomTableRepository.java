package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transaction;

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

    public <T> List<T> view(String table) {
    // public <T extends Map<String, Object>> List<T> view(String table) {
        Query query = entityManager.createNativeQuery("SELECT * FROM db." + table);
        List<T> l = query.getResultList();
        System.out.println(l);
        return l;
    }

    @Transactional
    public int create(String table) {
        // Query query = entityManager.createNativeQuery("INSERT INTO db.fruits VALUES (20, 'apple', 'red')");
        Query query = entityManager.createNativeQuery("INSERT INTO db.colors (name, hex, grade) VALUES ('red', 'ff0000', 8)");
        return query.executeUpdate();
    }
}
