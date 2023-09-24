package com.example.projectIot.repository;

import com.example.projectIot.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepo extends JpaRepository<Data, Integer> {

    @Query("select d from Data d")
    List<Data> getAllData();
}
