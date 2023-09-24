package com.example.projectIot.repository;

import com.example.projectIot.model.Remote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteRepo extends JpaRepository<Remote, Integer> {

    @Query("select r from Remote r")
    List<Remote> getAllRemotes();

}
