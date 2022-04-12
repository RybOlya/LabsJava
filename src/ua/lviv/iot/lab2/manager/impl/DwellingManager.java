package ua.lviv.iot.lab2.manager.impl;

import ua.lviv.iot.lab2.manager.IDwellingManager;
import ua.lviv.iot.lab2.models.Dwelling;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class DwellingManager  implements IDwellingManager {
    private Map<String, List<Dwelling>> dwellingsMap = new HashMap<>();
    Collator collator = Collator.getInstance(new Locale("ua", "UA"));
    @Override
    public void addDwelling(List<Dwelling> dwellings) {
        dwellings.forEach(dwelling -> {
            String typeName = dwelling.getName();
            var existingDwellings = dwellingsMap.get(typeName);
            if(existingDwellings == null) {
                existingDwellings = new LinkedList<Dwelling>();
                dwellingsMap.put(typeName, existingDwellings);
            }
            existingDwellings.add(dwelling);
        });
    }

    @Override
    public Dwelling findByName(List<Dwelling> dwellings,String name) {
        for(Dwelling dwelling : dwellings) {
            if(dwelling.getName().equals(name)) {
                return dwelling;
            }
        }
        return null;

    }

    @Override
    public Dwelling findByLocation(List<Dwelling> dwellings, String location) {
        for(Dwelling dwelling : dwellings) {
            if(dwelling.getLocation().equals(location)) {
                return dwelling;
            }
        }
        return null;
    }

    @Override
    public void sortByPrice(List<Dwelling> dwellings, boolean isReversed) {
        if(isReversed)
            dwellings.sort(Collections.reverseOrder(Comparator.comparing(Dwelling::getPricePerSquareMeter)));
        else
            dwellings.sort(Comparator.comparing(Dwelling::getPricePerSquareMeter));
    }

    @Override
    public void sortByLocation(List<Dwelling> dwellings, boolean isReversed) {
        if(isReversed)
            dwellings.sort(Collections.reverseOrder(Comparator.comparing(Dwelling::getLocation)));
        else
            dwellings.sort(Comparator.comparing(Dwelling::getLocation));
    }
}