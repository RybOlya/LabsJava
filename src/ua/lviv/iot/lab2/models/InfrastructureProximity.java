package ua.lviv.iot.lab2.models;

public class InfrastructureProximity {
    private float school;
    private float kindergarten;
    private float groceries;
    private float pharmacy;
    private float gym;
    private float entertainment;

    public InfrastructureProximity(float school, float kindergarten, float groceries,
                                   float pharmacy, float gym, float entertainment) {
        this.school = school;
        this.kindergarten = kindergarten;
        this.groceries = groceries;
        this.pharmacy = pharmacy;
        this.gym = gym;
        this.entertainment = entertainment;
    }

    @Override
    public String toString() {
        return "InfrastructureProximity: " +
                "school=" + school +
                "m, kindergarten=" + kindergarten +
                "m, groceries=" + groceries +
                "m, pharmacy=" + pharmacy +
                "m, gym=" + gym +
                "m, entertainment=" + entertainment +
                "m, ";
    }

    public float getSchool() {
        return school;
    }

    public void setSchool(float school) {
        this.school = school;
    }

    public float getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(float kindergarten) {
        this.kindergarten = kindergarten;
    }

    public float getGroceries() {
        return groceries;
    }

    public void setGroceries(float groceries) {
        this.groceries = groceries;
    }

    public float getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(float pharmacy) {
        this.pharmacy = pharmacy;
    }
    public float getGym() {
        return gym;
    }
    public void setGym(float gym) {
        this.gym = gym;
    }
    public float getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(float entertainment) {
        this.entertainment = entertainment;
    }
}