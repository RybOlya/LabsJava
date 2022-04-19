package ua.lviv.iot.lab2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Studio{
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

    public int getApartmentNumber() {
        return apartmentNumber;
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
