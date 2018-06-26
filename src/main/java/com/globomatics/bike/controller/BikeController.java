package com.globomatics.bike.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.globomatics.bike.domain.Bike;
import com.globomatics.bike.domain.BikeDetails;
import com.globomatics.bike.exceptions.BikeErrorResponse;
import com.globomatics.bike.exceptions.BikeNotFoundException;
import com.globomatics.bike.repositories.BikeRepository;
import com.globomatics.bike.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    BikeDetails bikeDetails = new BikeDetails("Jakis tam opis", "Opinia1: Ten rower wymiata!");

    Bike bikeOne = new Bike("Ketler", "Germany", new BigDecimal("13222.1321323123213123213"), 12, 2017, bikeDetails);


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Bike> bike() {
        bikeRepository.save(bikeOne);
        return bikeRepository.findAll();

    }

    @RequestMapping(value = "/bike/{id}", method = RequestMethod.GET)
    public Bike oneBike(@PathVariable("id") Long id) {

        if ((id >= bikeRepository.findAll().size()) || (id < 0)) {
            throw new BikeNotFoundException("Bike with id " + id + " can't be found");
        } else if (!(id instanceof Long)) {
            throw new BikeNotFoundException("Id must be an integer");
        }

        return bikeRepository.getOne(id);
    }

    @ExceptionHandler
    public ResponseEntity<BikeErrorResponse> handleException(BikeNotFoundException exception) {

        BikeErrorResponse err = new BikeErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exception.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Bike bike) {

        bikeRepository.save(bike);

    }

    @RequestMapping(value = "/names", method = RequestMethod.GET)
    public List<String> namesOnly() {
        return nameService.getNamesOnly();
    }
}
