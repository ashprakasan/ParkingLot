package com.aiswarya.api;

import com.aiswarya.db.Cars;
import com.aiswarya.db.ParkedCars;
import com.aiswarya.db.TakenSlots;
import com.aiswarya.model.Car;
import com.aiswarya.model.Slot;
import com.aiswarya.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client implements iClient {
    public List<String> getRegNumForColor(String color) {
        //DB query equivalent to this will be "Select * from Cars where Cars.color=color
        List<String> result = new ArrayList<String>();
        for(Car car: Cars.getAllCars().values()){
            if(car.getColor().equals(color)){
                result.add(car.getRegistrationNumber());
            }
        }
        return result;
    }
    public int getSlotNum(String regNum) {
        //DB query -> join between availableSlots table and Ticket table on ticket_id.
        for(Map.Entry<Slot,Ticket> entry:TakenSlots.getTakenSlots().entrySet()){
            if(entry.getValue().getRegNum().equals(regNum)){
                return entry.getKey().getSlotNumber();
            }
        }
        return -1;
    }
    public List<Integer> getSlotNumForColor(String color) {
        //DB query -> indexedCars is the table of parkedCars that has slot number.
        // Select slot number from indexedCars where color = color
        List<Integer> result = new ArrayList<Integer>();
        Map<String,Integer> parkedCars = ParkedCars.getParkedCars();
        Map<String,Car> cars = Cars.getAllCars();
        for(Map.Entry<String,Integer> entry:parkedCars.entrySet()){
            String regNum = entry.getKey();
            if(color.equals(cars.get(regNum).getColor())){
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
