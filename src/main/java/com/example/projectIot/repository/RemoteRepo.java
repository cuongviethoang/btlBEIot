package com.example.projectIot.repository;

import com.example.projectIot.model.Remote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteRepo extends JpaRepository<Remote, Integer> {

    @Query("select r from Remote r")
    List<Remote> getAllRemotes();

    // Lấy ra danh sách led từ mới nhất đến cũ nhất
    @Query("SELECT r FROM Remote r WHERE r.device = 'Led' ORDER BY r.time DESC")
    List<Remote> findLatestLed();

    // Lấy ra danh sách fan từ mới nhất đến cũ nhất
    @Query("SELECT r FROM Remote r WHERE r.device = 'Fan' ORDER BY r.time DESC")
    List<Remote> findLatestFan();
    @Query("select r from Remote r where r.time like %:time% ")
    List<Remote> getAllRemotebyTime(@Param("time") String time);

    @Query("select r from Remote r where r.device = ?1 and r.state = ?2")
    List<Remote> getAllRemoteByDeviceState(String device, String state);

}
