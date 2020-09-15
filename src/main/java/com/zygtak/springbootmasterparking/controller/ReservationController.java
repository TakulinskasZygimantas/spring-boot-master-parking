package com.zygtak.springbootmasterparking.controller;

import com.zygtak.springbootmasterparking.entity.Reservation;
import com.zygtak.springbootmasterparking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return service.saveReservation(reservation);
    }

    @GetMapping("/allReservationsByUserId/{userId}")
    public List<Reservation> getAllReservationByParkingLotId(@PathVariable int userId) {
        return service.getAllReservationsByUserId(userId);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return service.updateReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable int id) {
        return service.deleteReservation(id);
    }
}
