package com.aiswarya.api;

import java.util.ArrayList;
import java.util.List;

public interface iClient {
    List<String> getRegNumForColor(String color);
    int getSlotNum(String regNum);
    List<Integer> getSlotNumForColor(String color);
}
