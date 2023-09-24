package com.example.projectIot.controller;

import com.example.projectIot.model.Remote;
import com.example.projectIot.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/remote")
public class RemoteController {

    @Autowired
    RemoteService remoteService;


//    http://localhost:8080/api/remote/show
    @GetMapping("/show")
    public ResponseEntity<?> getAllRemotes() {
        List<Remote> remoteList = remoteService.getAllRemotes();
        return new ResponseEntity<>(remoteList, HttpStatus.OK);
    }

//    http://localhost:8080/api/remote/create
    @PostMapping("/create")
    public ResponseEntity<?> createRemote(@RequestBody Remote remote) {
        remoteService.createRemote(remote);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
