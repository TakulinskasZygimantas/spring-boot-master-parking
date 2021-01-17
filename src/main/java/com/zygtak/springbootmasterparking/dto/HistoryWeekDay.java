package com.zygtak.springbootmasterparking.dto;

public class HistoryWeekDay {
    private String weekDay;
    private int countService;

    public HistoryWeekDay(String weekDay, int countService) {
        this.weekDay = weekDay;
        this.countService = countService;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public int getCountService() {
        return countService;
    }

    public void setCountService(int countService) {
        this.countService = countService;
    }
}