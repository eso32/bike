package com.globomatics.bike.services;

import com.globomatics.bike.domain.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NameService {

    @Autowired
    BikeRepository bikeRepository;


    public List<String> getNamesOnly(){
        List<Bike> bikeList = bikeRepository.findAll();
        List names = new ArrayList<String>();

        for (Bike bike: bikeList){
            names.add(bike.getName());
        }

        return names;

    }

}
