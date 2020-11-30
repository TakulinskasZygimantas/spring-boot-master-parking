package com.zygtak.springbootmasterparking.dto;

public class HistoryParkingSpot {
    private int parkingSpot;
    private int countService;

    public HistoryParkingSpot(int parkingSpot, int countService) {
        this.parkingSpot = parkingSpot;
        this.countService = countService;
    }

    public int getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(int parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public int getCountService() {
        return countService;
    }

    public void setCountService(int countService) {
        this.countService = countService;
    }
}
