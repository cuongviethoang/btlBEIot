package com.example.projectIot.services.Implement;

import com.example.projectIot.model.Remote;
import com.example.projectIot.repository.RemoteRepo;
import com.example.projectIot.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RemoteServiceImpl implements RemoteService {

    @Autowired
    RemoteRepo remoteRepo;
    @Override
    public void createRemote(Remote remote) {
        Remote remote1 = new Remote();
        remote1.setBulb(remote.getBulb());
        remote1.setFan(remote.getFan());

        LocalDateTime now = LocalDateTime.now();

        // Định dạng theo mẫu mong muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Sử dụng định dạng để chuyển LocalDateTime thành chuỗi
        String formattedDateTime = now.format(formatter);
        remote1.setTime(formattedDateTime);
        remoteRepo.save(remote1);
    }

    @Override
    public List<Remote> getAllRemotes() {
        List<Remote> remoteList = remoteRepo.getAllRemotes();
        Collections.reverse(remoteList);
        return remoteList;
    }
}
