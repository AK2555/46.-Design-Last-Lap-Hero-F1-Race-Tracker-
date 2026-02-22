package org.example.observer;

import org.example.entities.Lap;

public interface Observable {
     void addObserver(Observer observer);
     void notifyAllObservers(Lap lap);
}
