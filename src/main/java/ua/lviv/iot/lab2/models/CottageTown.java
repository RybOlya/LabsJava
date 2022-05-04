package ua.lviv.iot.lab2.models;

public class CottageTown extends Dwelling {
    private final int numberOfHouses;

    public CottageTown(String name, String buildingNumber, Streets streetName,
                       float pricePerSquareMeter, int numberOfFloors, int airQuality,
                       Boolean parking, Heating heating, Boolean security, float school,
                       float kindergarten, float groceries, float pharmacy, float gym,
                       float entertainment, int numberOfHouses) {
        super(name, buildingNumber, streetName, pricePerSquareMeter, numberOfFloors,
                airQuality, parking, heating, security, school, kindergarten, groceries,
                pharmacy, gym, entertainment);
        this.numberOfHouses = numberOfHouses;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", numberOfHouses";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + numberOfHouses;
    }

}
