package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.entity.Reservation;
import com.zygtak.springbootmasterparking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }

    public List<Reservation> getAllReservationsByUserId(int userId) {
        return repository.findAllByUserId(userId);
    }

    public Reservation updateReservation(Reservation reservation) {
        Reservation existingReservation = repository.findById(reservation.getId()).orElse(null);
        existingReservation.setParkingSpotId(reservation.getParkingSpotId());
        existingReservation.setUserId(reservation.getUserId());
        existingReservation.setReservationStart(reservation.getReservationStart());
        existingReservation.setReservationEnd(reservation.getReservationEnd());
        return repository.save(existingReservation);
    }

    public String deleteReservation(int id) {
        repository.deleteById(id);
        return "Reservation " + id + " removed";
    }
}