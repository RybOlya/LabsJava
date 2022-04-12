package ua.lviv.iot.lab2;

import ua.lviv.iot.lab2.manager.impl.*;
import ua.lviv.iot.lab2.models.* ;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Dwelling> availableDwellings = new LinkedList<Dwelling>();
        DwellingManager manager = new DwellingManager();
        Studio studioOnStusa = new Studio(25, 21, 3, 2,
                "зданий в експлуатацію");
        PentHouse pentHouseOnStusa = new PentHouse(4, 32,4,3,
                "зданий в експлуатацію", true);
        TreeSet<Studio> aprtsStusa = new TreeSet<Studio>(Comparator.comparing(Studio::getApartmentNumber));
        aprtsStusa.add(studioOnStusa);
        aprtsStusa.add(pentHouseOnStusa);
        Dwelling highRiseOnStusa = new ApartmentType("ЖБ на Стуса", "вул. Стуса, 39",aprtsStusa,
                30000, 4,31,true, Heating.INDIVIDUAL, true, 800,
                200, 200, 500, 500, 100, true, true);
        Dwelling townhouseProvesin = new CottageTown("Провесінь","вул. Тракт Глинянський, 152",
                31000,2,31,true,Heating.INDIVIDUAL, true,300,
                300, 210, 300, 500, 700, 29);
        Dwelling cottageTimberland = new DetachedHouse("КМ TIMBERLAND", "вул. Лисеницька, 66",
                28000, 3,34, true,Heating.INDIVIDUAL, true,300,
                200, 300, 500, 400, 800, 1.5F);
        availableDwellings.add(highRiseOnStusa);
        availableDwellings.add(townhouseProvesin);
        availableDwellings.add(cottageTimberland);
        manager.addDwelling(availableDwellings);
        System.out.println(availableDwellings);
        System.out.println(" Sort dwellings by price: \n 1 - Low-high\n 2 - High-low\n Your choice(1/2): ");
        Scanner scan = new Scanner(System.in);
        int choicePrice = scan.nextInt();
        switch (choicePrice){
            case 1:
                manager.sortByPrice(availableDwellings,false);
                break;
            case 2:
                manager.sortByPrice(availableDwellings,true);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println(availableDwellings);
        System.out.println(" Sort dwellings by location: \n 1 - Alphabetically\n 2 - Non-alphabetical\n Your choice(1/2): ");
        int choiceLocation = scan.nextInt();
        switch (choiceLocation){
            case 1:
                manager.sortByLocation(availableDwellings,false);
                break;
            case 2:
                manager.sortByLocation(availableDwellings,true);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println(availableDwellings);
        Scanner scanText = new Scanner(System.in);
        System.out.println("Enter name to find by:");
        String name = scanText.nextLine();
        System.out.println(manager.findByName(availableDwellings,name));
        System.out.println("Enter location to find by:");
        String location = scanText.nextLine();
        System.out.println(manager.findByLocation(availableDwellings,location));
    }
}