package ua.lviv.iot.lab2.manager;

import ua.lviv.iot.lab2.models.Dwelling;

import java.util.List;

public interface IDwellingManager {
    void addDwelling(List <Dwelling> dwellings);
    Dwelling findByName(List <Dwelling> dwellings,String name);
    Dwelling findByLocation(List <Dwelling> dwellings,String location);
    void sortByPrice(List <Dwelling> dwellings, boolean isReversed);
    void sortByLocation(List <Dwelling> dwellings, boolean isReversed);
}