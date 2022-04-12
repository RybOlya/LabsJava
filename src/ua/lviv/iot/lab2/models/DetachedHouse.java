package ua.lviv.iot.lab2.models;

public class DetachedHouse extends Dwelling{

    private float privatePlotAreaInAcres;

    public DetachedHouse(String name, String location, float pricePerSquareMeter, int numberOfFloors,
                         int airQuality, Boolean parking, Heating heating, Boolean security, float school,
                         float kindergarten, float groceries, float pharmacy, float gym, float entertainment,
                         float privatePlotAreaInAcres) {
        super(name, location, pricePerSquareMeter, numberOfFloors, airQuality, parking, heating, security, school,
                kindergarten, groceries, pharmacy, gym, entertainment);
        this.privatePlotAreaInAcres = privatePlotAreaInAcres;
    }
    public float getPrivatePlotAreaInAcres() {
        return privatePlotAreaInAcres;
    }

    public void setPrivatePlotAreaInAcres(float privatePlotAreaInAcres) {
        this.privatePlotAreaInAcres = privatePlotAreaInAcres;
    }

}