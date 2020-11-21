package com.zygtak.springbootmasterparking.dao;

public class ParkingSpotDAO {
    private int id;
    private int status;

    public ParkingSpotDAO(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
