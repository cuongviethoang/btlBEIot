package com.example.projectIot.services.Implement;

import com.example.projectIot.model.Data;
import com.example.projectIot.repository.DataRepo;
import com.example.projectIot.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;



    @Autowired
    DataRepo dataRepo;

    private final Random random = new Random();

    @Override
    @Scheduled(fixedRate = 180000)
    public void createData() {
        Data data = new Data();

        float temp = getRandomFloat(20.0f, 30.0f); // Độ C, ví dụ từ 20.0 đến 30.0
        float humidity = getRandomFloat(40.0f, 60.0f); // %, ví dụ từ 40.0 đến 60.0
        float light = getRandomFloat(500.0f, 1500.0f); // Lux, ví dụ từ 500.0 đến 1500.0
        data.setTemp(temp);
        data.setHumidity(humidity);
        data.setLight(light);

        LocalDateTime now = LocalDateTime.now();
        // Định dạng theo mẫu mong muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Sử dụng định dạng để chuyển LocalDateTime thành chuỗi
        String formattedDateTime = now.format(formatter);
        data.setTime(formattedDateTime);

        simpMessagingTemplate.convertAndSend("/message", data);

        dataRepo.save(data);
    }

    @Override
    public List<Data> getAllDatas() {
        List<Data> dataList = dataRepo.getAllData();
        return dataList;
    }

    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }
}
