package com.zygtak.springbootmasterparking.dto;

import java.sql.Time;

public class ParkingLotDTO {

    private int id;
    private String name;
    private String address;
    private String coordinates;
    private double tariffDay;
    private double tariffNight;
    private Time beginningOfTheWork;
    private Time endOfTheWork;
    private int freeTime;
    private int parkingSpotsCount;
    private int freeParkingSpotsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public double getTariffDay() {
        return tariffDay;
    }

    public void setTariffDay(double tariffDay) {
        this.tariffDay = tariffDay;
    }

    public double getTariffNight() {
        return tariffNight;
    }

    public void setTariffNight(double tariffNight) {
        this.tariffNight = tariffNight;
    }

    public Time getBeginningOfTheWork() {
        return beginningOfTheWork;
    }

    public void setBeginningOfTheWork(Time beginningOfTheWork) {
        this.beginningOfTheWork = beginningOfTheWork;
    }

    public Time getEndOfTheWork() {
        return endOfTheWork;
    }

    public void setEndOfTheWork(Time endOfTheWork) {
        this.endOfTheWork = endOfTheWork;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public int getParkingSpotsCount() {
        return parkingSpotsCount;
    }

    public void setParkingSpotsCount(int parkingSpotsCount) {
        this.parkingSpotsCount = parkingSpotsCount;
    }

    public int getFreeParkingSpotsCount() {
        return freeParkingSpotsCount;
    }

    public void setFreeParkingSpotsCount(int freeParkingSpotsCount) {
        this.freeParkingSpotsCount = freeParkingSpotsCount;
    }
}
