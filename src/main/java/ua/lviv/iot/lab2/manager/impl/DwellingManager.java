package ua.lviv.iot.lab2.manager.impl;

import ua.lviv.iot.lab2.manager.IDwellingManager;
import ua.lviv.iot.lab2.models.Choice;
import ua.lviv.iot.lab2.models.Dwelling;
import ua.lviv.iot.lab2.models.Streets;

import java.util.*;

public class DwellingManager  implements IDwellingManager {
    private final Map<String, Dwelling> dwellingsMap = new HashMap<>();
    @Override
    public void addDwelling(List<Dwelling> dwellings) {
        for(Dwelling dwelling : dwellings){
            if(dwellingsMap.containsKey(generateKey(dwelling)))
               throw new RuntimeException("Dwelling Already Exists");
            dwellingsMap.put(generateKey(dwelling),dwelling);
        }
    }
    private String generateKey(Dwelling dwelling){
        return String.format("%s-%s", dwelling.getName(), dwelling.getStreetName());
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
        String[] address = location.split("\\s*,\\s*");
        for(Dwelling dwelling : dwellings) {
            if(dwelling.getBuildingNumber().equals(address[0])&&dwelling.getStreetName().toString().equals(address[1])) {
                return dwelling;
            }
        }
        return null;
    }

    @Override
    public void sortByPrice(List<Dwelling> dwellings, Choice order) {
        if(order == Choice.DESCENDING)
            dwellings.sort(Collections.reverseOrder(Comparator.comparing(Dwelling::getPricePerSquareMeter)));
        else
            dwellings.sort(Comparator.comparing(Dwelling::getPricePerSquareMeter));
    }

    @Override
    public void sortByLocation(List<Dwelling> dwellings, Choice order) {
        if(order == Choice.ALPHABETICAL){
            List<Streets> desiredStreetsOrder= new ArrayList<>(Arrays.asList(Streets.values()));
            Comparator<Streets> streetsOrder = Comparator.comparingInt(desiredStreetsOrder::indexOf);
            dwellings.sort(Comparator.comparing(Dwelling::getStreetName, streetsOrder));
        }
        else {
            List<Streets> desiredStreetsOrder= new ArrayList<>(Arrays.asList(Streets.values()));
            Collections.reverse(desiredStreetsOrder);
            Comparator<Streets> streetsOrder = Comparator.comparingInt(desiredStreetsOrder::indexOf);
            dwellings.sort(Comparator.comparing(Dwelling::getStreetName, streetsOrder));
        }
    }
    public Collection<Dwelling> getAllDwellings(){
        return dwellingsMap.values();
    }
    @Override
    public String toString() {
        return "Map"+dwellingsMap;
    }
}
