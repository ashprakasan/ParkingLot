package com.aiswarya.db;

import com.aiswarya.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cars {
    @Getter
    static Map<String,Car> allCars = new HashMap<String, Car>();

    public static void addCars(Car car){
        allCars.put(car.getRegistrationNumber(),car);
    }
}
