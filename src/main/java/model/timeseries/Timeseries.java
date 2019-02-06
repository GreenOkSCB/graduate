package model.timeseries;

import model.timepoint.TimePoint;

import java.util.ArrayList;

public class Timeseries {
    private String activeName;
    private ArrayList<TimePoint> timePoints;
    private int tradingDays = 0;


    public Timeseries(ArrayList<TimePoint> timePoints, String activeName) {
        this.timePoints = timePoints;
        this.activeName = activeName;
    }


    public ArrayList<TimePoint> getTimePoints() {
        return timePoints;
    }

    public void setTimePoints(ArrayList<TimePoint> timePoints) {
        this.timePoints = timePoints;
    }

}
