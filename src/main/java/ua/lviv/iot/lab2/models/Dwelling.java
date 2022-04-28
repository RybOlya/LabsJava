package ua.lviv.iot.lab2.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Dwelling {
    private String name;
    private String buildingNumber;
    private Streets streetName;
    private float pricePerSquareMeter;
    private int numberOfFloors;
    private int airQuality;
    private Boolean parking;
    private Heating heating;
    private Boolean security;
    private InfrastructureProximity inf;

    public Dwelling(String name, String buildingNumber, Streets streetName,
                    float pricePerSquareMeter, int numberOfFloors, int airQuality,
                    Boolean parking, Heating heating, Boolean security, float school,
                    float kindergarten, float groceries, float pharmacy,
                    float gym, float entertainment) {
        this.name = name;
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.pricePerSquareMeter = pricePerSquareMeter;
        this.numberOfFloors = numberOfFloors;
        this.airQuality = airQuality;
        this.parking = parking;
        this.heating = heating;
        this.security = security;
        this.inf = new InfrastructureProximity(school, kindergarten,
                groceries, pharmacy, gym, entertainment);
    }

    public String getHeaders() {
        return "name, buildingNumber, streetName";
    }

    public String toCSV() {
        return name + "," + buildingNumber + "," + streetName;
    }

    @Override
    public String toString() {
        return " Name='" + name
                + ", location='" + buildingNumber
                + ", " + streetName + " St.";
    }
}
