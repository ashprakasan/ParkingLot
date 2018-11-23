package com.aiswarya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

//For the sake of simplicity, nothing apart from what is asked in the question has been added here.
@Data
@AllArgsConstructor
public class Car {
    @Getter
    private String registrationNumber; // TODO : Setter should have sanity checks to ensure it is a real registration number.
    private String color; // TODO : make color an enum
}
