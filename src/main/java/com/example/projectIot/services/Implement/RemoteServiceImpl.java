package com.example.projectIot.services.Implement;

import com.example.projectIot.gateway.MqttGateWay;
import com.example.projectIot.model.Remote;
import com.example.projectIot.repository.RemoteRepo;
import com.example.projectIot.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RemoteServiceImpl implements RemoteService {

    @Autowired
    RemoteRepo remoteRepo;

    @Autowired
    MqttGateWay mqttGateWay;
    @Override
    public void createRemote(Remote remote) {
        Remote remote1 = new Remote();
        remote1.setDevice(remote.getDevice());
        remote1.setState(remote.getState());
        LocalDateTime now = LocalDateTime.now();

        // Định dạng theo mẫu mong muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Sử dụng định dạng để chuyển LocalDateTime thành chuỗi
        String formattedDateTime = now.format(formatter);
        remote1.setTime(formattedDateTime);
        remoteRepo.save(remote1);
    }

    @Override
    public void sendRemoteToMQTT(Remote remote) {
        String topic = "remote";
        try {
            mqttGateWay.sendToMqtt(remote.getDevice().toString() +  " " +  remote.getState().toString(), topic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Remote> getAllRemotes() {
        List<Remote> remoteList = remoteRepo.getAllRemotes();
        Collections.reverse(remoteList);
        return remoteList;
    }

    @Override
    public List<Remote> getRemotesLatest() {
        List<Remote> remoteList = new ArrayList<>();
        Remote remote1 = remoteRepo.findLatestLed().get(0);
        Remote remote2 = remoteRepo.findLatestFan().get(0);
        remoteList.add(remote1);
        remoteList.add(remote2);
        return remoteList;
    }

    @Override
    public List<Remote> getAllRemoteFromTime(String time) {
        List<Remote> remoteList = new ArrayList<>();
//        List<Remote> remotes = remoteRepo.getAllRemotes();
//        for(Remote remote: remotes) {
//            String[] timeArray = remote.getTime().split(" ");
//            String[] timeLine = timeArray[1].split(":");
//            int timeNum = Integer.parseInt(timeLine[0])*60 + Integer.parseInt(timeLine[1]);
//            String[] timeLine1 = time.split(":");
//            int timeNum1 = Integer.parseInt(timeLine1[0])*60 + Integer.parseInt(timeLine1[1]);
//            System.out.println(timeNum + " " + timeNum1);
//            if(timeNum1==timeNum) {
//                remoteList.add(remote);
//            }
//        }
        remoteList = remoteRepo.getAllRemotebyTime(time);
        Collections.reverse(remoteList);
        return remoteList;
    }

    @Override
    public int getAllRemoteByDeviceState(String device, String state) {
        List<Remote> remotes = remoteRepo.getAllRemoteByDeviceState(device, state);
        int count = remotes.size();
        return count;    }


}
