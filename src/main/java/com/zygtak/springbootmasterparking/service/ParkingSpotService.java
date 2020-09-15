package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.dto.ParkingSpotDTO;
import com.zygtak.springbootmasterparking.entity.ParkingSpot;
import com.zygtak.springbootmasterparking.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository repository;

    public ParkingSpotDTO saveParkingSpot(ParkingSpot parkingSpot) {
        repository.save(parkingSpot);

        ParkingSpotDTO parkingSpotDTO = new ParkingSpotDTO();

        parkingSpotDTO.setId(parkingSpot.getId());
        parkingSpotDTO.setNumber(parkingSpot.getNumber());
        parkingSpotDTO.setStatus(parkingSpot.getStatus());
        parkingSpotDTO.setParkingLotId(parkingSpot.getParkingLot().getId());

        return parkingSpotDTO;
    }

    public List<ParkingSpotDTO> getAllParkingSpotsByParkingLotId(int parkingLotId) {

        List<ParkingSpot> parkingSpots = repository.findAllByParkingLotId(parkingLotId);

        List<ParkingSpotDTO> parkingSpotDTOS = new ArrayList<>();

        for (int i = 0; i < parkingSpots.size(); i++) {

            ParkingSpotDTO parkingSpotDTO = new ParkingSpotDTO();

            parkingSpotDTO.setId(parkingSpots.get(i).getId());
            parkingSpotDTO.setNumber(parkingSpots.get(i).getNumber());
            parkingSpotDTO.setStatus(parkingSpots.get(i).getStatus());
            parkingSpotDTO.setParkingLotId(parkingSpots.get(i).getParkingLot().getId());

            parkingSpotDTOS.add(parkingSpotDTO);
        }

        return parkingSpotDTOS;
    }

    public ParkingSpotDTO updateParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpot existingParkingSpot = repository.findById(parkingSpot.getId()).orElse(null);
        existingParkingSpot.setNumber(parkingSpot.getNumber());
        existingParkingSpot.setStatus(parkingSpot.getStatus());
        existingParkingSpot.setParkingLot(parkingSpot.getParkingLot());
        repository.save(existingParkingSpot);

        ParkingSpotDTO parkingSpotDTO = new ParkingSpotDTO();

        parkingSpotDTO.setId(parkingSpot.getId());
        parkingSpotDTO.setNumber(parkingSpot.getNumber());
        parkingSpotDTO.setStatus(parkingSpot.getStatus());
        parkingSpotDTO.setParkingLotId(parkingSpot.getParkingLot().getId());

        return parkingSpotDTO;
    }
}
