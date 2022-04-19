package ua.lviv.iot.lab2.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
public abstract class Dwelling{

    private String name;
    private String buildingNumber;
    public Streets streetName;
    private float pricePerSquareMeter;
    private int numberOfFloors;
    private int airQuality;
    private Boolean parking;
    private Heating heating;
    private Boolean security;
    private InfrastructureProximity inf;
    public Dwelling(String name,  String buildingNumber, Streets streetName, float pricePerSquareMeter, int numberOfFloors,
                    int airQuality, Boolean parking, Heating heating, Boolean security, float school, float kindergarten,
                    float groceries, float pharmacy, float gym, float entertainment) {
        this.name = name;
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.pricePerSquareMeter = pricePerSquareMeter;
        this.numberOfFloors = numberOfFloors;
        this.airQuality = airQuality;
        this.parking = parking;
        this.heating = heating;
        this.security = security;
        this.inf = new InfrastructureProximity(school,kindergarten,groceries,pharmacy,gym,entertainment);
    }



    @Override
    public String toString() {
        return " Name='" + name + '\'' +
                ", location='" + buildingNumber + ", "
                + streetName+" St." + '\'' +
                ", pricePerSquareMeter=" + pricePerSquareMeter +
                ", airQuality=" + airQuality +
                ", parking=" + parking +
                ", heating='" + heating + '\'' +
                ", security=" + security +
                ", " + inf;

    }

}
