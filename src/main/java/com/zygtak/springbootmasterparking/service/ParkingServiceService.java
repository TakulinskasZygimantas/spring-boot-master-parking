package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.dto.*;
import com.zygtak.springbootmasterparking.entity.ParkingService;
import com.zygtak.springbootmasterparking.entity.ServiceResponse;
import com.zygtak.springbootmasterparking.repository.ParkingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

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
        parkingService.setParkingLotId(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getId());
        parkingService.setParkingLotName(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getName());
        parkingService.setParkingLotAddress(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getAddress());
        parkingService.setParkingSpotNumber(parkingSpotService.getParkingSpot(parkingService.getParkingSpotId()).getNumber());

        parkingService.setUserId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getUserId());
        parkingService.setDeviceId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getId());
        parkingService.setDeviceName(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getName());

        return repository.save(parkingService);
    }

    public ParkingService saveParkingServiceNew(ParkingService parkingService) {

        ParkingService existingParkingService = getParkingServiceByDeviceMac(parkingService.getDeviceMac(), null);
        if (existingParkingService == null) {
            parkingService.setParkingLotId(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getId());
            parkingService.setParkingLotName(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getName());
            parkingService.setParkingLotAddress(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getAddress());
            parkingService.setParkingSpotNumber(parkingSpotService.getParkingSpot(parkingService.getParkingSpotId()).getNumber());
            parkingService.setParkingLotTariff(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getTariffDay());

            parkingService.setParkingStart(Calendar.getInstance().getTime());

            parkingService.setUserId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getUserId());
            parkingService.setDeviceId(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getId());
            parkingService.setDeviceName(deviceService.getDeviceByMac(parkingService.getDeviceMac()).getName());

            return repository.save(parkingService);
        }
        else {
            existingParkingService.setParkingEnd(Calendar.getInstance().getTime());
            return repository.save(existingParkingService);
        }
    }

    public ParkingService getParkingServiceById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<ParkingService> getAllParkingServicesByUserId(int userId) {
        List<ParkingService> parkingServices = repository.findAllByUserId(userId);
        Collections.reverse(parkingServices);
        return parkingServices;
    }

    public ParkingService getParkingServiceByDeviceMac(String deviceMac, Date parkingEnd) {
        return repository.findByDeviceMacAndParkingEnd(deviceMac, parkingEnd);
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
        existingParkingService.setParkingLotId(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getId());
        existingParkingService.setParkingLotName(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getName());
        existingParkingService.setParkingLotTariff(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getTariffDay());
        existingParkingService.setParkingLotAddress(parkingLotService.getParkingLotByParkingSpotId(parkingService.getParkingSpotId()).getAddress());
        existingParkingService.setParkingSpotNumber(parkingSpotService.getParkingSpot(parkingService.getParkingSpotId()).getNumber());

        return repository.save(existingParkingService);
    }

    public List<HistoryWeekDay> getHistoryOfWeekDays() {
        DateFormat format = new SimpleDateFormat("EEEE");

        List<ParkingService> parkingServices = repository.findAll();

        List<String> listOfWords = new ArrayList<String>();
        List<HistoryWeekDay> historyWeekDays = new ArrayList<>();

        if (parkingServices != null) {
            for (int i = 0; i < parkingServices.size(); i++) {
                try {
                    listOfWords.add(format.format(parkingServices.get(i).getParkingStart()));
                }
                catch (Exception e) {
                    listOfWords.add(e.toString());
                }
            }
            Set<String> unique = new HashSet<>(listOfWords);
            for (String key : unique) {
                historyWeekDays.add(new HistoryWeekDay(key, Collections.frequency(
                        listOfWords,
                        key
                )));
            }
        }

        return historyWeekDays;
    }

    public HistoryWeek getHistoryOfWeek() {
        DateFormat format = new SimpleDateFormat("EEEE");

        List<ParkingService> parkingServices = repository.findAll();

        HistoryWeek historyWeek = new HistoryWeek();


        if (parkingServices != null) {
            for (int i = 0; i < parkingServices.size(); i++) {

                switch(format.format(parkingServices.get(i).getParkingStart())) {
                    case "Monday":
                        historyWeek.setMonday(historyWeek.getMonday() + 1);
                        break;
                    case "Tuesday":
                        historyWeek.setTuesday(historyWeek.getTuesday() + 1);
                        break;
                    case "Wednesday":
                        historyWeek.setWednesday(historyWeek.getWednesday() + 1);
                        break;
                    case "Thursday":
                        historyWeek.setThursday(historyWeek.getThursday() + 1);
                        break;
                    case "Friday":
                        historyWeek.setFriday(historyWeek.getFriday() + 1);
                        break;
                    case "Saturday":
                        historyWeek.setSaturday(historyWeek.getSaturday() + 1);
                        break;
                    case "Sunday":
                        historyWeek.setSunday(historyWeek.getSunday() + 1);
                        break;
                }
            }
        }
        return historyWeek;
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

    public ServiceResponse<List<HistoryHour>> getBusiestHours(int parkingLotId) {
        String message = "OK";
        boolean success = true;

        ServiceResponse<List<HistoryHour>> serviceResponse = new ServiceResponse<List<HistoryHour>>();

        DateFormat format = new SimpleDateFormat("HH");

        List<Integer> listOfHours = new ArrayList<Integer>();
        List<HistoryHour> historyHours = new ArrayList<>();
        List<ParkingService> parkingServices = repository.findAllByParkingLotId(parkingLotId);

        if (parkingServices.size() > 0) {
            for (int i = 0; i < parkingServices.size(); i++) {
                // gets range of hours
                IntStream.rangeClosed(
                        Integer.parseInt(
                                format.format(parkingServices.get(i).getParkingStart()) // converts DateTime to hours
                        ),
                        Integer.parseInt(
                                format.format(parkingServices.get(i).getParkingEnd())
                        ))
                        .forEach(no -> {
                            listOfHours.add(no);
                        });
            }

            // finds unique hours and counts it
            Set<Integer> uniqueStart = new HashSet<>(listOfHours);
            for (Integer key : uniqueStart) {
                if (historyHours.size() < 5) {
                    historyHours.add(
                            new HistoryHour(key, Collections.frequency(
                                    listOfHours,
                                    key
                            )));
                }
            }
            if (historyHours.size() < 15) {
                message = historyHours.size() + " is not enough data for research";
            }
        }
        else {
            message = "Where is no services in this parking lot";
            success = false;
        }

        serviceResponse.setSuccess(success);
        serviceResponse.setData(historyHours);
        serviceResponse.setMessage(message);

        return serviceResponse;
    }
}