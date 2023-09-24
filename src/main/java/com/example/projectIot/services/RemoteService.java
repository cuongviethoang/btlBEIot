package com.example.projectIot.services;

import com.example.projectIot.model.Remote;

import java.util.List;

public interface RemoteService {

    void createRemote(Remote remote);

    List<Remote> getAllRemotes();
}
