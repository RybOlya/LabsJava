package ua.lviv.iot.lab2.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.TreeSet;

@Setter(AccessLevel.NONE)
@Getter(AccessLevel.NONE)
public class ApartmentType extends Dwelling{
    private boolean elevator;
    private boolean concierge;
    private TreeSet<Studio> apartments = new TreeSet<>(Comparator.comparing(Studio::getApartmentNumber));
    public ApartmentType(String name, String buildingNumber, Streets streetName, float pricePerSquareMeter, TreeSet<Studio> apartments,int numberOfFloors, int airQuality, Boolean parking, Heating heating, Boolean security, float school, float kindergarten, float groceries, float pharmacy, float gym, float entertainment, boolean elevator, boolean concierge) {
        super(name, buildingNumber, streetName, pricePerSquareMeter, numberOfFloors, airQuality, parking, heating, security, school, kindergarten, groceries, pharmacy, gym, entertainment);
        this.elevator = elevator;
        this.concierge = concierge;
        this.apartments = apartments;
    }
    /*@Override
    public String getHeaders(){
        return super.getHeaders() + ", elevator, concierge";
    }
    @Override
    public String toCSV(){
        return super.toCSV() + "," + elevator+ "," + concierge;
    }
    @Override*/
    public String toString() {
        return super.toString()+
                " elevator=" + elevator +
                ", concierge=" + concierge;
    }

}
