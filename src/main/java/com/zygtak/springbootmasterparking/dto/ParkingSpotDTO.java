package com.zygtak.springbootmasterparking.dto;


public class ParkingSpotDTO {
    private int id;
    private int number;
    private int status;
    private int parkingLotId;

    public ParkingSpotDTO(int id, int number, int status, int parkingLotId) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.parkingLotId = parkingLotId;
    }

    public ParkingSpotDTO() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
