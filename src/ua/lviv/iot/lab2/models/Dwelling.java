package ua.lviv.iot.lab2.models;

public abstract class Dwelling{

    private String name;
    private String location;
    private float pricePerSquareMeter;
    private int numberOfFloors;
    private int airQuality;
    private Boolean parking;
    private Heating heating;
    private Boolean security;
    private InfrastructureProximity inf;
    public Dwelling(String name, String location, float pricePerSquareMeter, int numberOfFloors, int airQuality,
                    Boolean parking, Heating heating, Boolean security, float school, float kindergarten,
                    float groceries, float pharmacy, float gym, float entertainment) {
        this.name = name;
        this.location = location;
        this.pricePerSquareMeter = pricePerSquareMeter;
        this.numberOfFloors = numberOfFloors;
        this.airQuality = airQuality;
        this.parking = parking;
        this.heating = heating;
        this.security = security;
        this.inf = new InfrastructureProximity(school,kindergarten,groceries,pharmacy,gym,entertainment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public void setPricePerSquareMeter(float pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(int airQuality) {
        this.airQuality = airQuality;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Heating getHeating() {
        return heating;
    }

    public void setHeating(Heating heating) {
        this.heating = heating;
    }

    public Boolean getSecurity() {
        return security;
    }

    public void setSecurity(Boolean security) {
        this.security = security;
    }

    public InfrastructureProximity getInf() {
        return inf;
    }

    public void setInf(InfrastructureProximity inf) {
        this.inf = inf;
    }


    @Override
    public String toString() {
        return " Name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", pricePerSquareMeter=" + pricePerSquareMeter +
                ", airQuality=" + airQuality +
                ", parking=" + parking +
                ", heating='" + heating + '\'' +
                ", security=" + security +
                ", " + inf;

    }

}