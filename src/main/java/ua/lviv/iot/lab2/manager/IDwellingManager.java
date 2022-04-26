package ua.lviv.iot.lab2.manager;

import java.util.List;
import ua.lviv.iot.lab2.models.Choice;
import ua.lviv.iot.lab2.models.Dwelling;

public interface IDwellingManager {
    void addDwelling(List<Dwelling> dwellings);

    Dwelling findByName(List<Dwelling> dwellings, String name);

    Dwelling findByLocation(List<Dwelling> dwellings, String location);

    void sortByPrice(List<Dwelling> dwellings, Choice order);

    void sortByLocation(List<Dwelling> dwellings, Choice order);
}
