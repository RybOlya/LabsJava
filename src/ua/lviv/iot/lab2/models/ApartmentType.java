package ua.lviv.iot.lab2.models;

import java.util.Comparator;
import java.util.TreeSet;

public class ApartmentType extends Dwelling{
    private boolean elevator;
    private boolean concierge;
    private TreeSet<Studio> aparts = new TreeSet<Studio>(Comparator.comparing(Studio::getApartmentNumber));

    public ApartmentType(String name, String location, TreeSet<Studio> aparts, float pricePerSquareMeter,
                         int numberOfFloors, int airQuality, Boolean parking, Heating heating, Boolean security,
                         float school, float kindergarten, float groceries, float pharmacy, float gym,
                         float entertainment, boolean elevator, boolean concierge) {
        super(name, location, pricePerSquareMeter, numberOfFloors, airQuality, parking, heating, security, school,
                kindergarten, groceries, pharmacy, gym, entertainment);
        this.elevator = elevator;
        this.concierge = concierge;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", elevator=" + elevator +
                ", concierge=" + concierge;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isConcierge() {
        return concierge;
    }

    public void setConcierge(boolean concierge) {
        this.concierge = concierge;
    }

    public TreeSet<Studio> getAparts() {
        return aparts;
    }

    public void setAparts(TreeSet<Studio> aparts) {
        this.aparts = aparts;
    }

}