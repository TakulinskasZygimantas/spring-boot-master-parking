package com.zygtak.springbootmasterparking.controller;

import com.zygtak.springbootmasterparking.dto.ParkingSpotDTO;
import com.zygtak.springbootmasterparking.entity.ParkingSpot;
import com.zygtak.springbootmasterparking.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService service;

    @PostMapping("/addParkingSpot")
    public ParkingSpotDTO addParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        return service.saveParkingSpot(parkingSpot);
    }

    @GetMapping("/allParkingSpotsByParkingLotId/{parkingLotId}")
    public List<ParkingSpotDTO> getAllParkingSpotsByParkingLotId(@PathVariable int parkingLotId) {
        return service.getAllParkingSpotsByParkingLotId(parkingLotId);
    }

    @PutMapping("/updateParkingSpot")
    public ParkingSpotDTO updateParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        return service.updateParkingSpot(parkingSpot);
    }
}

