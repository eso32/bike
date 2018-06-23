package com.globomatics.bike.controller;

import com.globomatics.bike.domain.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import com.globomatics.bike.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BikeController {

    @Autowired
    BikeRepository bikeRepository;

    @Autowired
    NameService nameService;

    Bike bikeOne = new Bike("Ketler", "Germany", new BigDecimal("13222.1321323123213123213"), 12, 2017);


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Bike> bike(){

        return bikeRepository.findAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bike oneBike(@PathVariable("id") Long id){
        return bikeRepository.getOne(id);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Bike bike){

        bikeRepository.save(bike);

    };

    @RequestMapping(value = "/names", method = RequestMethod.GET)
    public List<String> namesOnly(){
        return nameService.getNamesOnly();
    }
}
