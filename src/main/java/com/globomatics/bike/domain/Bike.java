package com.globomatics.bike.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bike {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String country;
    private BigDecimal price;
    private int rating;
    private int year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="detail_id")
    private BikeDetails bikeDetails;

    public Bike() {
    }

    public Bike(String name, String country, BigDecimal price, int rating, int year, BikeDetails bikeDetails) {
        this.name = name;
        this.country = country;
        this.price = price;
        this.rating = rating;
        this.year = year;
        this.bikeDetails = bikeDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BikeDetails getBikeDetails() {
        return bikeDetails;
    }

    public void setBikeDetails(BikeDetails bikeDetails) {
        this.bikeDetails = bikeDetails;
    }
}
