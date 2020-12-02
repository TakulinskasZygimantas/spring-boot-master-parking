package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.dao.ParkingSpotDAO;
import com.zygtak.springbootmasterparking.dto.ParkingSpotDTO;
import com.zygtak.springbootmasterparking.dto.ParkingSpotsPercentage;
import com.zygtak.springbootmasterparking.entity.ParkingSpot;
import com.zygtak.springbootmasterparking.entity.ServiceResponse;
import com.zygtak.springbootmasterparking.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

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

    public ParkingSpot getParkingSpot(int id) {
        return repository.findById(id).orElse(null);
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

    public ParkingSpotDTO updateParkingSpot(ParkingSpotDAO parkingSpotDAO) {
        ParkingSpot existingParkingSpot = repository.findById(parkingSpotDAO.getId()).orElse(null);
        existingParkingSpot.setStatus(parkingSpotDAO.getStatus());
        repository.save(existingParkingSpot);

        ParkingSpotDTO parkingSpotDTO = new ParkingSpotDTO();

        parkingSpotDTO.setId(parkingSpotDAO.getId());
        parkingSpotDTO.setNumber(existingParkingSpot.getNumber());
        parkingSpotDTO.setStatus(parkingSpotDAO.getStatus());
        parkingSpotDTO.setParkingLotId(existingParkingSpot.getParkingLot().getId());

        return parkingSpotDTO;
    }

    public ServiceResponse<ParkingSpotsPercentage> getParkingSpotsBusynessByParkingLotId(int parkingLotId) {
        String message = "OK";
        boolean success = true;

        ServiceResponse<ParkingSpotsPercentage> serviceResponse = new ServiceResponse<ParkingSpotsPercentage>();

        DecimalFormat df = new DecimalFormat("0.0");

        ParkingSpotsPercentage parkingSpotsPercentage = new ParkingSpotsPercentage();
        List<ParkingSpot> parkingSpots = repository.findAllByParkingLotId(parkingLotId);

        if (parkingSpots.size() > 0) {
            for (int i = 0; i < parkingSpots.size(); i++) {
                switch (parkingSpots.get(i).getStatus()) {
                    case 0:
                        parkingSpotsPercentage.setFreePercentage(
                                parkingSpotsPercentage.getFreePercentage() + 1
                        );
                        break;
                    case 1:
                        parkingSpotsPercentage.setReservedPercentage(
                                parkingSpotsPercentage.getReservedPercentage() + 1
                        );
                        break;
                    case 2:
                        parkingSpotsPercentage.setBusyPercentage(
                                parkingSpotsPercentage.getBusyPercentage() + 1
                        );
                        break;
                    default:
                        message = "Where is no parking spot status: " + parkingSpots.get(i).getStatus();
                        success = false;
                        break;
                }
            }


            parkingSpotsPercentage.setFreePercentage(
                    parseDouble(
                            df.format((parkingSpotsPercentage.getFreePercentage() * 100) / parkingSpots.size())));

            parkingSpotsPercentage.setReservedPercentage(
                    parseDouble(
                            df.format((parkingSpotsPercentage.getReservedPercentage() * 100) / parkingSpots.size())));

            parkingSpotsPercentage.setBusyPercentage(
                    parseDouble(
                            df.format((parkingSpotsPercentage.getBusyPercentage() * 100) / parkingSpots.size())));
        }
        else {
            message = "Where is no parking spots to count";
            success = false;
        }

        serviceResponse.setSuccess(success);
        serviceResponse.setData(parkingSpotsPercentage);
        serviceResponse.setMessage(message);

        return serviceResponse;
    }
}
