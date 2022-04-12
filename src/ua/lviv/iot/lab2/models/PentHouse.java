package ua.lviv.iot.lab2.models;

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

    public Boolean getPrivateRooftop() {
        return privateRooftop;
    }

    public void setPrivateRooftop(Boolean privateRooftop) {
        this.privateRooftop = privateRooftop;
    }
}