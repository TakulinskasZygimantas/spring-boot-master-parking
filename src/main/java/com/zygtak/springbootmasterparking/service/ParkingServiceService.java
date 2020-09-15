package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.entity.ParkingService;
import com.zygtak.springbootmasterparking.repository.ParkingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingServiceService {

    @Autowired
    private ParkingServiceRepository repository;

    public ParkingService saveParkingService(ParkingService parkingService) {
        return repository.save(parkingService);
    }

    public List<ParkingService> getAllParkingServicesByUserId(int userId) {
        return repository.findAllByUserId(userId);
    }

    public String deleteParkingService(int id) {
        repository.deleteById(id);
        return "Parking Service " + id + " removed";
    }

    public ParkingService updateParkingService(ParkingService parkingService) {
        ParkingService existingParkingService = repository.findById(parkingService.getId()).orElse(null);
        existingParkingService.setUserId(parkingService.getUserId());
        existingParkingService.setParkingSpotId(parkingService.getParkingSpotId());
        existingParkingService.setMac(parkingService.getMac());
        existingParkingService.setParkingStart(parkingService.getParkingStart());
        existingParkingService.setParkingEnd(parkingService.getParkingEnd());
        return repository.save(existingParkingService);
    }
}
