package org.example;

import org.example.managers.FastestLapManager;
import org.example.managers.RecordLapTimeManager;
import org.example.managers.TopDriversManager;

import java.util.ArrayList;
import java.util.List;

public class LastLapHero {

    RecordLapTimeManager recordLapTimeManager;
    FastestLapManager fastestLapManager;
    TopDriversManager topDriversManager;


    public LastLapHero(int carsCount, int lapsCount) {
        recordLapTimeManager=new RecordLapTimeManager();
        fastestLapManager=new FastestLapManager();
        topDriversManager=new TopDriversManager();
        recordLapTimeManager.addObserver(fastestLapManager);
        recordLapTimeManager.addObserver(topDriversManager);
    }

    public void recordLapTiming(int carId, int lapId, int timeTaken) {
        recordLapTimeManager.recordLapTiming(carId,lapId,timeTaken);
    }

    public List<String> getTop3FastestLaps() {
        return fastestLapManager.getTop3FastestLaps();
    }

    public List<Integer> getTop3Drivers() {
        return topDriversManager.getTop3Drivers();
    }
}