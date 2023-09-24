package com.example.projectIot.services.Implement;

import com.example.projectIot.model.Data;
import com.example.projectIot.repository.DataRepo;
import com.example.projectIot.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
