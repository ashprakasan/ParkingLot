package com.aiswarya.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.aiswarya.Util.Constants.M;
import static com.aiswarya.Util.Constants.N;

@Data
public class Slot {
    private int slotNumber;
    private Map<Integer,Double> distances; //Could have used an array.But keeping track of zero index would be a pain.

    public Slot(int slotNumber){
        this.slotNumber = slotNumber;
        distances = new HashMap<Integer, Double>();
        for(int i=1;i<=M;i++){
            distances.put(i,getDistanceFromEntry(i));
        }
    }

    private double getDistanceFromEntry(int entryPoint){
        if((N/M)*entryPoint>=slotNumber){
            return (((N/M) * entryPoint) - slotNumber);
        }
        return slotNumber - ((N/M) * entryPoint);
    }
}
