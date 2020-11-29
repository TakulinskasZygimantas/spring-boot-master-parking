package com.zygtak.springbootmasterparking.controller;

import com.zygtak.springbootmasterparking.entity.ParkingService;
import com.zygtak.springbootmasterparking.service.ParkingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingServiceController {

    @Autowired
    private ParkingServiceService service;

    @PostMapping("/addParkingService")
    public ParkingService addParkingService(@RequestBody ParkingService parkingService) {
        return service.saveParkingService(parkingService);
    }

    @GetMapping("/parkingServiceById/{id}")
    public ParkingService getParkingServiceById(@PathVariable int id) {
        return service.getParkingServiceById(id);
    }

    @GetMapping("/allParkingServicesByUserId/{userId}")
    public List<ParkingService> getAllParkingServicesByUserId(@PathVariable int userId) {
        return service.getAllParkingServicesByUserId(userId);
    }

    @PutMapping("/updateParkingService")
    public ParkingService updateParkingService(@RequestBody ParkingService parkingService) {
        return service.updateParkingService(parkingService);
    }

    @DeleteMapping("/deleteParkingService/{id}")
    public String deleteParkingService(@PathVariable int id) {
        return service.deleteParkingService(id);
    }
}
