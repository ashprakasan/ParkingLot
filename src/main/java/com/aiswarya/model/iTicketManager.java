package com.aiswarya.model;

//We can have different implementations of iTicketManager to have different ticket managing strategies.
public interface iTicketManager {
    public Ticket issueTicket(Car car, int entryPoint);
    public void reclaimTicket(Ticket ticket);
}
