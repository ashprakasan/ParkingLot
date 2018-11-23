package com.aiswarya.db;

import com.aiswarya.Util.SlotDistanceTuple;
import com.aiswarya.model.Slot;
import lombok.Getter;

import java.util.*;

import static com.aiswarya.Util.Constants.M;
import static com.aiswarya.Util.Constants.N;

@Getter
public class AvailableSlots {
    @Getter
    static Set<Slot> vacantSpots = new HashSet<Slot>();

    public boolean addAsVacant(Slot slot){
        return vacantSpots.add(slot);
    }

    public boolean useSlot(Slot slot){
        return vacantSpots.remove(slot);
    }
    public boolean isAvailable(Slot slot){
        return vacantSpots.contains(slot);
    }
    public boolean addAsVacant(Integer slotNumber){
        Slot slot = new Slot(slotNumber);
        return addAsVacant(slot);
    }
}

