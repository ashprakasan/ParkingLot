package com.aiswarya.model;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class Ticket {
    String regNum;
    Integer slotNumber;
    Date entryTime;
    Date exitTime;
    Double amount;

    public Ticket(String regNum, Integer slotNumber){
        this.regNum = regNum;
        this.slotNumber = slotNumber;
    }

    //FUTURE EXTENSION
    // Amount calculation logic can be here based on car type, slot type, entry and exit times.
}
