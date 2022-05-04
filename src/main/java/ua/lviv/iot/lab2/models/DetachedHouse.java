package ua.lviv.iot.lab2.models;

public class DetachedHouse extends Dwelling {
    private final float privatePlotAreaInAcres;

    public DetachedHouse(String name, String buildingNumber, Streets streetName,
                         float pricePerSquareMeter, int numberOfFloors, int airQuality,
                         Boolean parking, Heating heating, Boolean security, float school,
                         float kindergarten, float groceries, float pharmacy, float gym,
                         float entertainment, float privatePlotAreaInAcres) {
        super(name, buildingNumber, streetName, pricePerSquareMeter, numberOfFloors,
                airQuality, parking, heating, security, school, kindergarten, groceries,
                pharmacy, gym, entertainment);
        this.privatePlotAreaInAcres = privatePlotAreaInAcres;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", privatePlotAreaInAcres";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + privatePlotAreaInAcres;
    }
}
