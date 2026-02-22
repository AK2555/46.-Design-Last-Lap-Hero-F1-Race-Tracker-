package org.example.managers;

import org.example.entities.Lap;
import org.example.observer.Observer;

import java.util.*;

public class FastestLapManager implements Observer {
    private PriorityQueue<Lap> topThreeFastestLaps;



    public FastestLapManager(){
        topThreeFastestLaps=new PriorityQueue<>((a,b)->{
            if(a.getTimeTaken()!=b.getTimeTaken()){
                return b.getTimeTaken()-a.getTimeTaken();
            }else if(a.getCarId()!=b.getCarId()){
                return b.getCarId()-a.getCarId();
            }else{
                return b.getLapId()-a.getLapId();
            }
        });
    }
// carId-lapId-timeTaken
    public List<String> getTop3FastestLaps() {
        List<String> res= new ArrayList<>();
        List<Lap> tmp=new ArrayList<>();
        int n=topThreeFastestLaps.size();
        for(int i=0;i<n;i++){
            Lap lap=topThreeFastestLaps.poll();
            tmp.add(lap);
            String str=lap.getCarId()+"-"+lap.getLapId()+"-"+lap.getTimeTaken();
            res.add(str);
        }
        for(int i=0;i<tmp.size();i++){
            topThreeFastestLaps.offer(tmp.get(i));
        }
        Collections.reverse(res);
        return res;
    }

    @Override
    public void update(Lap lap) {
        topThreeFastestLaps.add(lap);
        if(topThreeFastestLaps.size()>3){
            topThreeFastestLaps.poll();
        }
    }
}
