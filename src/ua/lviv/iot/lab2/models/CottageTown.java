package ua.lviv.iot.lab2.models;

public class CottageTown extends Dwelling{
    private int numberOfHouses;

    public CottageTown(String name, String location, float pricePerSquareMeter, int numberOfFloors, int airQuality,
                       Boolean parking, Heating heating, Boolean security, float school, float kindergarten,
                       float groceries, float pharmacy, float gym, float entertainment, int numberOfHouses) {
        super(name, location, pricePerSquareMeter, numberOfFloors, airQuality, parking, heating, security, school,
                kindergarten, groceries, pharmacy, gym, entertainment);
        this.numberOfHouses = numberOfHouses;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }
}