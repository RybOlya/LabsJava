package ua.lviv.iot.lab2.models;

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

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getStateOfApartment() {
        return stateOfApartment;
    }

    public void setStateOfApartment(String stateOfApartment) {
        this.stateOfApartment = stateOfApartment;
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