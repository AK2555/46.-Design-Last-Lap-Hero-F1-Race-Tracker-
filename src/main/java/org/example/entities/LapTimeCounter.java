package org.example.entities;

public class LapTimeCounter {
    private int totalLap;
    private int totalTime;
    private int carId;
    public LapTimeCounter(int carId){
        this.totalLap=0;
        this.totalTime=0;
        this.carId=carId;
    }

    public int getTotalLap() {
        return totalLap;
    }

    public void setTotalLap(int totalLap) {
        this.totalLap = totalLap;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void addLap(int totalTime){
        this.totalTime+=totalTime;
        totalLap++;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
