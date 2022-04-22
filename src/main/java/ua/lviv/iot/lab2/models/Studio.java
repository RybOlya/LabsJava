package ua.lviv.iot.lab2.models;

import lombok.*;

import java.io.Serializable;

@Getter(AccessLevel.NONE)
@Setter(AccessLevel.NONE)
@AllArgsConstructor()
public class Studio {
    private int apartmentNumber;
    private int area;
    private int floor;
    private int bedrooms;
    private String stateOfApartment;

    @Override
    public String toString() {
        return "Studio: " +
                "apartmentNumber=" + apartmentNumber +
                ", area=" + area +
                ", floor=" + floor +
                ", bedrooms=" + bedrooms +
                ", stateOfApartment='" + stateOfApartment + '\'' +
                ' ';
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
