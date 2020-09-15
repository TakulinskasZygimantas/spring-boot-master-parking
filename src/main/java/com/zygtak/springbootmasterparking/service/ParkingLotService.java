package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.dto.ParkingLotDTO;
import com.zygtak.springbootmasterparking.entity.ParkingLot;
import com.zygtak.springbootmasterparking.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository repository;

    public List<ParkingLotDTO> getParkingLots() {

        List<ParkingLot> parkingLots = repository.findAll();

        List<ParkingLotDTO> parkingLotDTOS = new ArrayList<>();

        if (parkingLots != null) {
            for (int i = 0; i < parkingLots.size(); i++) {

                ParkingLotDTO parkingLotDTO = new ParkingLotDTO();

                parkingLotDTO.setId(parkingLots.get(i).getId());
                parkingLotDTO.setName(parkingLots.get(i).getName());
                parkingLotDTO.setAddress(parkingLots.get(i).getAddress());
                parkingLotDTO.setCoordinates(parkingLots.get(i).getCoordinates());
                parkingLotDTO.setTariffDay(parkingLots.get(i).getTariffDay());
                parkingLotDTO.setTariffNight(parkingLots.get(i).getTariffNight());
                parkingLotDTO.setBeginningOfTheWork(parkingLots.get(i).getBeginningOfTheWork());
                parkingLotDTO.setEndOfTheWork(parkingLots.get(i).getEndOfTheWork());
                parkingLotDTO.setFreeTime(parkingLots.get(i).getFreeTime());
                parkingLotDTO.setParkingSpotsCount(parkingLots.get(i).getParkingSpots() != null ? parkingLots.get(i).getParkingSpots().size() : 0);

                parkingLotDTOS.add(parkingLotDTO);
            }
        }
        return parkingLotDTOS;
    }

    public ParkingLotDTO saveParkingLot(ParkingLot parkingLot) {

        ParkingLot pLot = repository.save(parkingLot);

        ParkingLotDTO parkingLotDTO = new ParkingLotDTO();

        parkingLotDTO.setId(pLot.getId());
        parkingLotDTO.setName(pLot.getName());
        parkingLotDTO.setAddress(pLot.getAddress());
        parkingLotDTO.setCoordinates(pLot.getCoordinates());
        parkingLotDTO.setTariffDay(pLot.getTariffDay());
        parkingLotDTO.setTariffNight(pLot.getTariffNight());
        parkingLotDTO.setBeginningOfTheWork(pLot.getBeginningOfTheWork());
        parkingLotDTO.setEndOfTheWork(pLot.getEndOfTheWork());
        parkingLotDTO.setFreeTime(pLot.getFreeTime());
        parkingLotDTO.setParkingSpotsCount(pLot.getParkingSpots() != null ? pLot.getParkingSpots().size() : 0);

        return parkingLotDTO;
    }

    public ParkingLotDTO getParkingLotById(int id) {

        ParkingLot pLot = repository.findById(id).orElse(null);

        ParkingLotDTO parkingLotDTO = new ParkingLotDTO();

        parkingLotDTO.setId(pLot.getId());
        parkingLotDTO.setName(pLot.getName());
        parkingLotDTO.setAddress(pLot.getAddress());
        parkingLotDTO.setCoordinates(pLot.getCoordinates());
        parkingLotDTO.setTariffDay(pLot.getTariffDay());
        parkingLotDTO.setTariffNight(pLot.getTariffNight());
        parkingLotDTO.setBeginningOfTheWork(pLot.getBeginningOfTheWork());
        parkingLotDTO.setEndOfTheWork(pLot.getEndOfTheWork());
        parkingLotDTO.setFreeTime(pLot.getFreeTime());
        parkingLotDTO.setParkingSpotsCount(pLot.getParkingSpots() != null ? pLot.getParkingSpots().size() : 0);

        return parkingLotDTO;
    }
}
