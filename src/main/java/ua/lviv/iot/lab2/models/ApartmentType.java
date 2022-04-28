package ua.lviv.iot.lab2.models;

import java.util.TreeSet;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.NONE)
@Getter(AccessLevel.NONE)
public class ApartmentType extends Dwelling {
    private boolean elevator;
    private boolean concierge;
    private TreeSet<Studio> apartments;

    public ApartmentType(String name, String buildingNumber, Streets streetName,
                         float pricePerSquareMeter, TreeSet<Studio> apartments,
                         int numberOfFloors, int airQuality, Boolean parking,
                         Heating heating, Boolean security, float school,
                         float kindergarten, float groceries, float pharmacy,
                         float gym, float entertainment, boolean elevator, boolean concierge) {
        super(name, buildingNumber, streetName, pricePerSquareMeter, numberOfFloors,
                airQuality, parking, heating, security, school, kindergarten,
                groceries, pharmacy, gym, entertainment);
        this.elevator = elevator;
        this.concierge = concierge;
        this.apartments = apartments;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", apartmentsAvailable";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + apartments.size();
    }

    @Override
    public String toString() {
        return super.toString()
                + " elevator=" + elevator
                + ", concierge=" + concierge;
    }
}
