package ua.lviv.iot.lab2.models;

public class PentHouse extends Studio {
    private final Boolean privateRooftop;

    public PentHouse(int apartmentNumber, int area, int floor,
                     int bedrooms, String stateOfApartment, Boolean privateRooftop) {
        super(apartmentNumber, area, floor, bedrooms, stateOfApartment);
        this.privateRooftop = privateRooftop;
    }
}
