package ua.lviv.iot.lab2.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.TreeSet;
@Getter
@Setter

public class ApartmentType extends Dwelling{
    private boolean elevator;
    private boolean concierge;
    private TreeSet<Studio> aparts = new TreeSet<Studio>(Comparator.comparing(Studio::getApartmentNumber));

    public ApartmentType(String name, String buildingNumber, Streets streetName, float pricePerSquareMeter, int numberOfFloors, int airQuality, Boolean parking, Heating heating, Boolean security, float school, float kindergarten, float groceries, float pharmacy, float gym, float entertainment, boolean elevator, boolean concierge) {
        super(name, buildingNumber, streetName, pricePerSquareMeter, numberOfFloors, airQuality, parking, heating, security, school, kindergarten, groceries, pharmacy, gym, entertainment);
        this.elevator = elevator;
        this.concierge = concierge;
        this.aparts = aparts;
    }


    @Override
    public String toString() {
        return super.toString()+
                ", elevator=" + elevator +
                ", concierge=" + concierge;
    }

}
