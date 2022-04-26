package ua.lviv.iot.lab2.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.NONE)
@Setter(AccessLevel.NONE)
@AllArgsConstructor()
public class InfrastructureProximity {
    private float school;
    private float kindergarten;
    private float groceries;
    private float pharmacy;
    private float gym;
    private float entertainment;

    @Override
    public String toString() {
        return "InfrastructureProximity: "
                + "school=" + school
                + "m, kindergarten=" + kindergarten
                + "m, groceries=" + groceries
                + "m, pharmacy=" + pharmacy
                + "m, gym=" + gym
                + "m, entertainment=" + entertainment
                + "m, ";
    }
}
