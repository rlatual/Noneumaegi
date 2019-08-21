package com.nonu.noneumaegi.VO;

public class Tradetime {
    boolean isWeek;
    String startTime;
    String endTime;

    public boolean isWeek() {
        return isWeek;
    }

    public void setWeek(boolean week) {
        isWeek = week;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
