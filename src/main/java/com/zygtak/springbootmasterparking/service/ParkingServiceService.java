package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.dto.HistoryParkingSpot;
import com.zygtak.springbootmasterparking.dto.HistoryWeekDay;
import com.zygtak.springbootmasterparking.entity.ParkingService;
import com.zygtak.springbootmasterparking.repository.ParkingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ParkingServiceService {

    @Autowired
    private ParkingServiceRepository repository;

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private DeviceService deviceService;

    public ParkingServiceService(
            ParkingServiceRepository repository,
            ParkingLotService parkingLotService,
            ParkingSpotService parkingSpotService,
            DeviceService deviceService
    ) {
        this.repository = repository;
        this.parkingLotService = parkingLotService;
        this.parkingSpotService = parkingSpotService;
        this.deviceService = deviceService;
    }

    public ParkingService saveParkingService(ParkingService parkingService) {
        parkingService.setParkingLotName(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getName());
        parkingService.setParkingLotAddress(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getAddress());
        parkingService.setParkingSpotNumber(parkingSpotService.getParkingSpot(parkingService.getParkingSpotId()).getNumber());

        parkingService.setUserId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getUserId());
        parkingService.setDeviceId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getId());
        parkingService.setDeviceName(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getName());

        return repository.save(parkingService);
    }

    public ParkingService getParkingServiceById(int id) {
        return repository.findById(id).orElse(null);
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

        existingParkingService.setDeviceMac(parkingService.getDeviceMac());
        existingParkingService.setUserId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getUserId());
        existingParkingService.setDeviceId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getId());
        existingParkingService.setDeviceName(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getName());

        existingParkingService.setParkingSpotId(parkingService.getParkingSpotId());
        existingParkingService.setParkingStart(parkingService.getParkingStart());
        existingParkingService.setParkingEnd(parkingService.getParkingEnd());
        existingParkingService.setParkingLotName(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getName());
        existingParkingService.setParkingLotAddress(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getAddress());
        existingParkingService.setParkingSpotNumber(parkingSpotService.getParkingSpot(parkingService.getParkingSpotId()).getNumber());

        return repository.save(existingParkingService);
    }

    public List<HistoryWeekDay> getHistoryOfWeekDays() {
        DateFormat format = new SimpleDateFormat("EEEE");

        List<String> listOfWords = new ArrayList<String>();
        List<HistoryWeekDay> historyWeekDays = new ArrayList<>();
        List<ParkingService> parkingServices = repository.findAll();

        for (int i = 0; i < parkingServices.size(); i++) {
            listOfWords.add(format.format(parkingServices.get(i).getParkingStart()));
        }

        Set<String> unique = new HashSet<>(listOfWords);
        for (String key : unique) {
            historyWeekDays.add(new HistoryWeekDay(key, Collections.frequency(
                    listOfWords,
                    key
            )));
        }

        return historyWeekDays;
    }

    public List<HistoryParkingSpot> getHistoryOfParkingSpots() {

        boolean notExist = false;
        List<HistoryParkingSpot> historyParkingSpots = new ArrayList<>();
        List<ParkingService> parkingServices = repository.findAll();

        for (int i = 0; i < parkingServices.size() ; i++) {
            if (historyParkingSpots.size() > 0) {
                for (int j = 0; j < historyParkingSpots.size(); j++) {

                    if (historyParkingSpots.get(j).getParkingSpot() == parkingServices.get(i).getParkingSpotNumber()) {
                        historyParkingSpots.get(j).setCountService(historyParkingSpots.get(j).getCountService() + 1);
                        notExist = true;
                        break;
                    }
                }
                if (!notExist) {
                    historyParkingSpots.add(new HistoryParkingSpot(parkingServices.get(i).getParkingSpotNumber(), 1));
                    notExist = false;
                }
            }
            else {
                historyParkingSpots.add(new HistoryParkingSpot(parkingServices.get(i).getParkingSpotNumber(), 1));
            }
        }
        return historyParkingSpots;
    }
}
