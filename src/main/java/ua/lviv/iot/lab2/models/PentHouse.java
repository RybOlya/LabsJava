package ua.lviv.iot.lab2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PentHouse extends Studio{
    private Boolean privateRooftop;


    public PentHouse(int apartmentNumber, int area, int floor, int bedrooms, String stateOfApartment,
                     Boolean privateRooftop) {
        super(apartmentNumber, area, floor, bedrooms, stateOfApartment);
        this.privateRooftop = privateRooftop;
    }

    @Override
    public String toString() {
        return "PentHouse: "
                + "privateRooftop= " + privateRooftop + " "
                +super.toString();
    }
}
