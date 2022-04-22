package ua.lviv.iot.lab2.models;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Comparator;
@Getter(AccessLevel.NONE)
public enum Streets {
    BANDERY("Bandery"),
    DOROSHENKA("Doroshenka"),
    GLYNYANSKY_TRACT("Glynyansky Trakt"),
    LYSYNETSKA("Lysynetska"),
    STUSA("Stusa"),
    YAROSLAVENKA("Yaroslavenka");
    public final String name;
    private Comparator<Streets> streetsComparator;
    private Streets(String name) {
        this.name = name;
    }
    /*public String getStreetName() {
        return this.name;
    }*/
    public Comparator<Streets> streetsComparator() {
        return this.streetsComparator;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
