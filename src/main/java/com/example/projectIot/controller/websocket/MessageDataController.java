package com.example.projectIot.controller.websocket;

import com.example.projectIot.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageDataController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    DataService dataService;

//    @MessageMapping("/receive-message")
//    @SendTo("/message")
//    public void receiveMessage() {
//        dataService.createData();
//    }
}
