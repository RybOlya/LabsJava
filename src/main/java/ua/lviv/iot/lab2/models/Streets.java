package ua.lviv.iot.lab2.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Streets {
    BANDERY("Bandery"),
    DOROSHENKA("Doroshenka"),
    GLYNYANSKY_TRACT("Glynyansky Trakt"),
    LYPYNSKY("Lypynsky"),
    LYSYNETSKA("Lysynetska"),
    STUSA("Stusa"),
    YAROSLAVENKA("Yaroslavenka");
    public final String name;

    @Override
    public String toString() {
        return this.name;
    }
}
