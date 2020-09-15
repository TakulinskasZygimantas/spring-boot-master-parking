package com.zygtak.springbootmasterparking.repository;

import com.zygtak.springbootmasterparking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByUserId(int userId);
}
