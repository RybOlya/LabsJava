package ua.lviv.iot.lab2;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import ua.lviv.iot.lab2.manager.impl.DwellingManager;
import ua.lviv.iot.lab2.models.*;

public class Main {
    public static void main(String[] args) {
        List<Dwelling> availableDwellings = new LinkedList<>();
        final DwellingManager manager = new DwellingManager();
        Studio studioOnStusa = new Studio(25, 21, 3, 2,
                "put into operation");
        PentHouse pentHouseOnStusa = new PentHouse(4, 32, 4, 3,
                "put into operation", true);
        TreeSet<Studio> aprtmentsStusa =
                new TreeSet<>(Comparator.comparing(Studio::getApartmentNumber));
        aprtmentsStusa.add(studioOnStusa);
        aprtmentsStusa.add(pentHouseOnStusa);
        Dwelling highRiseOnStusa = new ApartmentType("Highrise on Stusa", "9", Streets.STUSA,
                30000, aprtmentsStusa, 4, 31, true, Heating.INDIVIDUAL, true,
                800, 200, 200, 500, 500, 100, true, true);
        Dwelling townhouseProvesin = new CottageTown("Provesin", "162", Streets.GLYNYANSKY_TRACT,
                31000, 2, 31, true, Heating.INDIVIDUAL, true, 300,
                300, 210, 300, 500, 700, 29);
        Dwelling cottageTimberland = new DetachedHouse("TH TIMBERLAND", "66", Streets.LYSYNETSKA,
                28000, 3, 34, true, Heating.INDIVIDUAL, true, 300,
                200, 300, 500, 400, 800, 1.5F);
        availableDwellings.add(highRiseOnStusa);
        availableDwellings.add(townhouseProvesin);
        availableDwellings.add(cottageTimberland);
        manager.addDwelling(availableDwellings);
        availableDwellings.forEach(System.out::println);
        System.out.println("Sort dwellings by price:\n "
                + "1 - Low-high\n 2 - High-low\nYour choice(1/2):");
        Scanner scan = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        int choicePrice = scan.nextInt();
        switch (choicePrice) {
            case 1:
                manager.sortByPrice(availableDwellings, Choice.ASCENDING);
                break;
            case 2:
                manager.sortByPrice(availableDwellings, Choice.DESCENDING);
                break;
            default:
                System.out.println("Invalid choice");
        }
        availableDwellings.forEach(System.out::println);
        System.out.println(" Sort dwellings by location:\n "
                + "1 - Alphabetically\n 2 - Non-alphabetical\n Your choice(1/2): ");
        int choiceLocation = scan.nextInt();
        switch (choiceLocation) {
            case 1:
                manager.sortByLocation(availableDwellings, Choice.ALPHABETICAL);
                break;
            case 2:
                manager.sortByLocation(availableDwellings, Choice.NON_ALPHABETICAL);
                break;
            default:
                System.out.println("Invalid choice");
        }
        availableDwellings.forEach(System.out::println);
        availableDwellings.forEach(System.out::println);
        //Scanner scanText = new Scanner(System.in);
        System.out.println("Enter name to find by:");
        String name = scan.nextLine();
        System.out.println(manager.findByName(availableDwellings, name));
        System.out.println("Enter location to find by:");
        String location = scan.nextLine();
        System.out.println(manager.findByLocation(availableDwellings, location));
    }
}
