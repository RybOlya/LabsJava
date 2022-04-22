package ua.lviv.iot.lab2.models;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;

import java.io.Serializable;

@Getter
@Setter
public class Studio implements Serializable {
    private int apartmentNumber;
    private int area;
    private int floor;
    private int bedrooms;
    private String stateOfApartment;


    public Studio(int apartmentNumber, int area, int floor, int bedrooms, String stateOfApartment) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.bedrooms = bedrooms;
        this.stateOfApartment = stateOfApartment;
    }

    public Studio() {
    }


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
}
