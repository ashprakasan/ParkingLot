package com.aiswarya.Util;

import com.aiswarya.Exceptions.InvalidComparisonException;
import com.aiswarya.model.Slot;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SlotDistanceTuple implements Comparable{
    Slot slot;
    Double distance;

    public int compareTo(Object o) {
        try {
            SlotDistanceTuple sdt = (SlotDistanceTuple)o;
            return distance.compareTo(sdt.distance);
        } catch (ClassCastException e) {
            // TODO : This should be logged using a logging framework like slf4j.
            // TODO : Exception to be handled in a meaningful way.
            System.out.println("SlotDistanceTuple Comparison Failed");
            e.printStackTrace();
        }
        return 0;
    }
}
