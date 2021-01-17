package com.zygtak.springbootmasterparking.controller;

import com.zygtak.springbootmasterparking.dto.ParkingLotDTO;
import com.zygtak.springbootmasterparking.entity.ParkingLot;
import com.zygtak.springbootmasterparking.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingLotController {

    @Autowired
    private ParkingLotService service;

    @PostMapping("/addParkingLot")
    public ParkingLotDTO addParkingLot(@RequestBody ParkingLot parkingLot) {
        return service.saveParkingLot(parkingLot);
    }

    @GetMapping("/parkingLots")
    public List<ParkingLotDTO> getAllParkingLots() {
        return service.getParkingLots();
    }

    @GetMapping("/getParkingLotById/{id}")
    public ParkingLotDTO getParkingLotById(@PathVariable int id) {
        return service.getParkingLotById(id);
    }
}