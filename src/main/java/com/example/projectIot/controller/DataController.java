package com.example.projectIot.controller;

import com.example.projectIot.model.Data;
import com.example.projectIot.model.Remote;
import com.example.projectIot.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    DataService dataService;

    // http://localhost:8080/api/data/show
    @GetMapping("/show")
    public ResponseEntity<?> getAllData() {
        List<Data> dataList = dataService.getAllDatas();
        return new ResponseEntity<>(dataList, HttpStatus.ACCEPTED);
    }

    // http://localhost:8080/api/data/search
    @PostMapping("/search")
    public ResponseEntity<?> searchTimeRemote(@RequestParam String time) {
        List<Data> dataList = new ArrayList<>();
        if(time == "") {
            dataList = dataService.getAllDatas();
        } else{
            dataList = dataService.getAllDataFromTime(time);
        }
        return ResponseEntity.ok(dataList);
    }
}
