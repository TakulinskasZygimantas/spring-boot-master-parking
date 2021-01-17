package com.zygtak.springbootmasterparking.controller;

import com.zygtak.springbootmasterparking.dto.HistoryHour;
import com.zygtak.springbootmasterparking.dto.HistoryParkingSpot;
import com.zygtak.springbootmasterparking.dto.HistoryWeek;
import com.zygtak.springbootmasterparking.dto.HistoryWeekDay;
import com.zygtak.springbootmasterparking.entity.ParkingService;
import com.zygtak.springbootmasterparking.entity.ServiceResponse;
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

    @PostMapping("/addParkingServiceNew")
    public ParkingService addParkingServiceNew(@RequestBody ParkingService parkingService) {
        return service.saveParkingServiceNew(parkingService);
    }

    @GetMapping("/parkingServiceById/{id}")
    public ParkingService getParkingServiceById(@PathVariable int id) {
        return service.getParkingServiceById(id);
    }

    @GetMapping("/allParkingServicesByUserId/{userId}")
    public List<ParkingService> getAllParkingServicesByUserId(@PathVariable int userId) {
        return service.getAllParkingServicesByUserId(userId);
    }

    @GetMapping("/getHistoryOfWeekDays")
    public List<HistoryWeekDay> getHistoryOfWeekDays() {
        return service.getHistoryOfWeekDays();
    }

    @GetMapping("/getHistoryOfWeek")
    public HistoryWeek getHistoryOfWeek() {
        return service.getHistoryOfWeek();
    }

    @GetMapping("/getHistoryOfParkingSpots")
    public List<HistoryParkingSpot> getHistoryOfParkingSpots() {
        return service.getHistoryOfParkingSpots();
    }

    @GetMapping("/getBusiestHours/{id}")
    public ServiceResponse<List<HistoryHour>> getBusiestHours(@PathVariable int id) {
        return service.getBusiestHours(id);
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