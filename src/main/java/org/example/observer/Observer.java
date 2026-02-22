package org.example.observer;

import org.example.entities.Lap;

public interface Observer {
    public void update(Lap lap);
}
