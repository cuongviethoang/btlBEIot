package com.example.projectIot.services;

import com.example.projectIot.model.Remote;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RemoteService {

    void createRemote(Remote remote);

    void sendRemoteToMQTT(Remote remote);

    List<Remote> getAllRemotes();

    List<Remote> getRemotesLatest();

    List<Remote> getAllRemoteFromTime(String time);

    int getAllRemoteByDeviceState(String device, String state);
}
