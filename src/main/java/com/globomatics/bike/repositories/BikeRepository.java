package com.globomatics.bike.repositories;

import com.globomatics.bike.domain.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
