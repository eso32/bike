package com.globomatics.bike.domain;

import java.math.BigDecimal;

public class Bike {

    private String name;
    private String country;
    private BigDecimal price;
    private int rating;
    private int year;

    public Bike(String name, String country, BigDecimal price, int rating, int year) {
        this.name = name;
        this.country = country;
        this.price = price;
        this.rating = rating;
        this.year = year;
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
}
