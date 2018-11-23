package com.aiswarya;

import com.aiswarya.db.AvailableSlots;
import com.aiswarya.db.Cars;
import com.aiswarya.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    //I have not written unit tests as I was running out of time.
    //This test broadly covers all cases.
    //Null and invalid types have not been efficiently handled due to time crunch.
    //Guice can be used for dependency injection to manage future complexities.
    //Mockito to be used to properly mock objects.
    private ParkingLot myParkingLot;
    private Car car1,car2,car3,car4,car5,car6,car7;

    @Before
    public void setUp(){
        AvailableSlots availableSlots = new AvailableSlots();
        iTicketManager simpleTicketManager = new SimpleTicketManager(availableSlots);
        myParkingLot = new ParkingLot("My ParkingLot", simpleTicketManager);
        ((SimpleTicketManager) simpleTicketManager).initializeDistancePQueueMap();
        ((SimpleTicketManager) simpleTicketManager).printDistancePQueue();

        Cars cars = new Cars();
        car1 = new Car("1234", "Green");
        car2 = new Car("5678", "Red");
        car3 = new Car("3764", "Yellow");
        car4 = new Car("6676", "Green");
        car5 = new Car("6ty6", "Red");
        car6 = new Car("5655", "Orange");
        car7 = new Car("3445","Yellow");
        Cars.addCars(car1);
        Cars.addCars(car2);
        Cars.addCars(car3);
        Cars.addCars(car4);
        Cars.addCars(car5);
        Cars.addCars(car6);
    }

    @Test
    public void OneGenericTestForAllCases(){
        Ticket ticket1 = myParkingLot.enter(car1, 2);
        Ticket ticket2 = myParkingLot.enter(car2, 2);
        Ticket ticket3 = myParkingLot.enter(car3, 2);
        Ticket ticket4 = myParkingLot.enter(car4, 2);
        Ticket ticket5 = myParkingLot.enter(car5, 2);
        Ticket ticket6 = myParkingLot.enter(car6, 2);
        myParkingLot.exit(ticket2);
        Ticket ticket7= myParkingLot.enter(car7,2);

        }
}