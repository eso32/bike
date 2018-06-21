package com.globomatics.bike.controller;

import com.globomatics.bike.domain.Bike;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BikeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Bike> bike(){

        List<Bike> bikeList = new ArrayList<Bike>();

        Bike bikeOne = new Bike("Giant", "Poland", new BigDecimal("1234.8000000000000000000000"), 5, 2016);

        bikeList.add(bikeOne);

        return bikeList;

    }
}
