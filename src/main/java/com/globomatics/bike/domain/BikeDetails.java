package com.globomatics.bike.domain;

import javax.persistence.*;

@Entity
public class BikeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String opinion;

    public BikeDetails() {
    }

    public BikeDetails(String description, String opinion) {
        this.description = description;
        this.opinion = opinion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
