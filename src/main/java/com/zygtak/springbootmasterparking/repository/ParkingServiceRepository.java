package com.zygtak.springbootmasterparking.repository;

import com.zygtak.springbootmasterparking.entity.ParkingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingServiceRepository extends JpaRepository<ParkingService, Integer> {
    List<ParkingService> findAllByUserId(int userId);

    List<ParkingService> findAllByParkingLotId(int parkingLotId);
}
