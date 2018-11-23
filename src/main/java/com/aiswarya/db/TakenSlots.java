package com.aiswarya.db;

import com.aiswarya.model.Slot;
import com.aiswarya.model.Ticket;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

// In the actual system this should be a db table.
@Data
public class TakenSlots {
    @Getter
    static Map<Slot,Ticket> takenSlots;
}
