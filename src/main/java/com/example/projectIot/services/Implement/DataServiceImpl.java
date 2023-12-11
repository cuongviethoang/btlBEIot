package com.example.projectIot.services.Implement;

import com.example.projectIot.model.Data;
import com.example.projectIot.model.Remote;
import com.example.projectIot.repository.DataRepo;
import com.example.projectIot.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataRepo dataRepo;

    @Override
    public List<Data> getAllDatas() {
        List<Data> dataList = dataRepo.getAllData();
        return dataList;
    }

    @Override
    public List<Data> getAllDataFromTime(String time) {
        List<Data> dataList = new ArrayList<>();
//        List<Data> datas = dataRepo.getAllData();
//        for(Data data: datas) {
//            String[] timeArray = data.getTime().split(" ");
//            String[] timeLine = timeArray[1].split(":");
//
//            int timeNum = Integer.parseInt(timeLine[0])*60 + Integer.parseInt(timeLine[1]);
//            String[] timeLine1 = time.split(":");
//            int timeNum1 = Integer.parseInt(timeLine1[0])*60 + Integer.parseInt(timeLine1[1]);
//            if(timeNum1==timeNum) {
//                dataList.add(data);
//            }
//        }
        dataList = dataRepo.getAllDatabyTime(time);
        Collections.reverse(dataList);
        return dataList;
    }
}
