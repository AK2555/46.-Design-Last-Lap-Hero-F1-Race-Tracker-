package org.example.managers;

import org.example.entities.Lap;
import org.example.observer.Observable;
import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class RecordLapTimeManager implements Observable {

    List<Observer> observers;

    public RecordLapTimeManager(){
        observers=new ArrayList<>();
    }

    public void recordLapTiming(int carId, int lapId, int timeTaken) {
         Lap lap=new Lap(lapId,carId,timeTaken);
          notifyAllObservers(lap);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers(Lap lap) {
         for(Observer observer: observers){
             observer.update(lap);
         }
    }
}
