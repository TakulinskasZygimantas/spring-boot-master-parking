package com.zygtak.springbootmasterparking.repository;

import com.zygtak.springbootmasterparking.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
}