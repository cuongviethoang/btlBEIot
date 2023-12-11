package com.example.projectIot.controller;

import com.example.projectIot.gateway.MqttGateWay;
import com.example.projectIot.model.Remote;
import com.example.projectIot.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/remote")
public class RemoteController {

    @Autowired
    RemoteService remoteService;

    @Autowired


//    http://localhost:8080/api/remote/show
    @GetMapping("/show")
    public ResponseEntity<?> getAllRemotes() {
        List<Remote> remoteList = remoteService.getAllRemotes();
        return new ResponseEntity<>(remoteList, HttpStatus.OK);
    }

//    http://localhost:8080/api/remote/latest
    @GetMapping("/latest")
    public ResponseEntity<?> getRemotesLatest() {
        List<Remote> remoteList = remoteService.getRemotesLatest();
        return new ResponseEntity<>(remoteList, HttpStatus.OK);
    }

//    http://localhost:8080/api/remote/create
    @PostMapping("/create")
    public ResponseEntity<?> createRemote(@RequestBody Remote remote) {

        remoteService.createRemote(remote);
        remoteService.sendRemoteToMQTT(remote);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    //    http://localhost:8080/api/remote/search
    @PostMapping("/search")
    public ResponseEntity<?> searchTimeRemote(@RequestParam String time) {
        List<Remote> remotes = new ArrayList<>();
        if( time=="") {
            remotes = remoteService.getAllRemotes();
        }
        else {
            remotes = remoteService.getAllRemoteFromTime(time);
        }
        return ResponseEntity.ok(remotes);
    }

    // http://localhost:8080/api/remote/count?device=''&state=''
    @GetMapping("/count")
    public ResponseEntity<?> getAllRemoteByDeviceState(@RequestParam String device, @RequestParam String state) {
        int count = remoteService.getAllRemoteByDeviceState(device, state);
        return ResponseEntity.ok(count);
    }

}
