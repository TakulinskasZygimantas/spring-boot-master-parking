package com.zygtak.springbootmasterparking.dto;

public class HistoryHour {
    private int hour;
    private int countService;

    public HistoryHour(int hour, int countService) {
        this.hour = hour;
        this.countService = countService;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getCountService() {
        return countService;
    }

    public void setCountService(int countService) {
        this.countService = countService;
    }
}
