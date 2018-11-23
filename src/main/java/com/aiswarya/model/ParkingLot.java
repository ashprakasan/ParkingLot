package com.aiswarya.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLot {
    String name;
    //can potentially change the ticket management strategy by implementing new sub-types of ticket manager
    iTicketManager simpleTicketManager;

    public Ticket enter(Car car, int entryPoint){
        return simpleTicketManager.issueTicket(car,entryPoint);
    }

    public void exit(Ticket ticket){
        simpleTicketManager.reclaimTicket(ticket);
    }

}
