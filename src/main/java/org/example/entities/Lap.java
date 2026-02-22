package org.example.entities;

public class Lap {
    private int lapId;
    private int carId;
    private int timeTaken;


    public Lap(int lapId, int carId, int timeTaken) {
        this.lapId = lapId;
        this.carId = carId;
        this.timeTaken = timeTaken;
    }

    public int getLapId() {
        return lapId;
    }

    public void setLapId(int lapId) {
        this.lapId = lapId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
}
