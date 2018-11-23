package com.aiswarya.model;

import com.aiswarya.Util.SlotDistanceTuple;
import com.aiswarya.db.AvailableSlots;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.aiswarya.Util.Constants.M;
import static com.aiswarya.Util.Constants.N;

public class SimpleTicketManager implements iTicketManager {
    //Priority for each Slot for all entrypoints can be pre-calculated and stored in the db.
    //In this implementation, I have used an in-memory priority queue(sorted arraylist) to demonstrate this.

    @Getter
    Map<Integer, ArrayList<SlotDistanceTuple>> distancePQueueMap;
    private AvailableSlots availableSlots;

    public SimpleTicketManager(AvailableSlots availableSlots) {
        this.availableSlots = availableSlots;
    }


    public void initializeDistancePQueueMap() {
        distancePQueueMap = new HashMap<Integer, ArrayList<SlotDistanceTuple>>();
        for (int e = 1; e <= M; e++) {
            distancePQueueMap.put(e, new ArrayList<SlotDistanceTuple>());
        }
        for (int i = 1; i <= N; i++) {
            Slot slot = new Slot(i);
            this.availableSlots.addAsVacant(slot);
            for (int e = 1; e <= M; e++) {
                Double distanceForThisEntry = slot.getDistances().get(e);
                distancePQueueMap.get(e).add(new SlotDistanceTuple(slot, distanceForThisEntry));
            }
        }
        for (int e = 1; e <= M; e++) {
            Collections.sort(distancePQueueMap.get(e));
        }
    }

    public void printDistancePQueue() {
        for (Integer e : distancePQueueMap.keySet()) {
            System.out.println("**************************************************");
            System.out.println(e);
            for (SlotDistanceTuple sdt : distancePQueueMap.get(e)) {
                System.out.print(sdt.getSlot() + "****" + sdt.getDistance());
                System.out.println("");
            }
        }
    }

    public Ticket issueTicket(Car car, int entryPoint) {

        Slot slot = null;
        Ticket ticket = null;
        boolean ticketGenerated = false;
        ArrayList<SlotDistanceTuple> pQueue = distancePQueueMap.get(entryPoint);
        for (SlotDistanceTuple sdt : pQueue) {
            slot = sdt.getSlot();
            if (availableSlots.isAvailable(slot)) {
                if (availableSlots.useSlot(slot)) {
                    ticket = new Ticket(car.getRegistrationNumber(), slot.getSlotNumber());
                    ticketGenerated = true;
                    System.out.println("Ticket created " + ticket);
                    System.out.println("Slot allotted is " + slot.getSlotNumber());
                } else {
                    System.out.println("ERROR! Spot could not be allotted.");
                }
                break;
            }
        }
        if (!ticketGenerated)
            System.out.println("We are currently full. No slots are available.");
        return ticket;
    }

    public void reclaimTicket(Ticket ticket) {
        if (availableSlots.addAsVacant(ticket.getSlotNumber())) {
            System.out.println("Spot " + ticket.getSlotNumber() + " is reclaimed and made available.");
        } else {
            System.out.println("ERROR! Spot could not be reclaimed.");
        }
    }
}
