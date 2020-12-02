package com.zygtak.springbootmasterparking.dto;

public class ParkingSpotsPercentage {

    private double freePercentage;
    private double busyPercentage;
    private double reservedPercentage;

    public double getFreePercentage() {
        return freePercentage;
    }

    public void setFreePercentage(double freePercentage) {
        this.freePercentage = freePercentage;
    }

    public double getBusyPercentage() {
        return busyPercentage;
    }

    public void setBusyPercentage(double busyPercentage) {
        this.busyPercentage = busyPercentage;
    }

    public double getReservedPercentage() {
        return reservedPercentage;
    }

    public void setReservedPercentage(double reservedPercentage) {
        this.reservedPercentage = reservedPercentage;
    }
}
