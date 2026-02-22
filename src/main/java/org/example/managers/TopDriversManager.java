package org.example.managers;

import org.example.entities.Lap;
import org.example.entities.LapTimeCounter;
import org.example.observer.Observer;

import java.util.*;

public class TopDriversManager implements Observer {
    private Map<Integer, LapTimeCounter> carLapMap;
    private TreeSet<LapTimeCounter> ts;

    public TopDriversManager(){
        this.carLapMap=new HashMap<>();
        this.ts=new TreeSet<>((a,b)->{
            double avgA= roundOff((a.getTotalTime()*1.0)/a.getTotalLap());
            double avgB= roundOff((b.getTotalTime()*1.0)/b.getTotalLap());
            if(avgA!=avgB){
                return Double.compare(avgA,avgB);
            }else{
                return a.getCarId()-b.getCarId();
            }
        });
    }

    public List<Integer> getTop3Drivers() {
        List<Integer> res= new ArrayList<>();
        List<LapTimeCounter> tmp=new ArrayList<>();
        int n=ts.size();
        for(int i=0;i<Math.min(3,n);i++){
            LapTimeCounter lap=ts.pollFirst();
            tmp.add(lap);
            res.add(lap.getCarId());
        }
        for(int i=0;i<tmp.size();i++){
            ts.add(tmp.get(i));
        }
        return res;
    }

    private double roundOff(double val){
        val= Math.round(val*100.0)/100.0;
        return val;
    }

    @Override
    public void update(Lap lap) {
        if(!carLapMap.containsKey(lap.getCarId())){
            carLapMap.put(lap.getCarId(),new LapTimeCounter(lap.getCarId()));
        }else{
            ts.remove(carLapMap.get(lap.getCarId()));
        }

        carLapMap.get(lap.getCarId()).addLap(lap.getTimeTaken());
        ts.add(carLapMap.get(lap.getCarId()));
    }
}
