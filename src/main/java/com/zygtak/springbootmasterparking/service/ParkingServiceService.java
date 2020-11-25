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

    @Autowired
    private ParkingLotService parkingLotService;

    public ParkingServiceService(ParkingServiceRepository repository, ParkingLotService parkingLotService) {
        this.repository = repository;
        this.parkingLotService = parkingLotService;
    }

    public ParkingService saveParkingService(ParkingService parkingService) {
        parkingService.setParkingLotName(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getName());
        parkingService.setParkingLotAddress(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getAddress());
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
        existingParkingService.setParkingLotName(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getName());
        existingParkingService.setParkingLotAddress(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getAddress());
        return repository.save(existingParkingService);
    }
}
