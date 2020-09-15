package com.zygtak.springbootmasterparking.repository;

import com.zygtak.springbootmasterparking.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
    List<ParkingSpot> findAllByParkingLotId(int parkingLotId);
}
