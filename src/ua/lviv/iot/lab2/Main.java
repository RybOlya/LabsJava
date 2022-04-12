package ua.lviv.iot.lab2;

import ua.lviv.iot.lab2.models.* ;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Studio studioOnStusa = new Studio(25, 21, 3, 2,
                "put into operation");
        PentHouse pentHouseOnStusa = new PentHouse(4, 32,4,3,
                "put into operation", true);
        TreeSet<Studio> aprtsStusa = new TreeSet<Studio>(Comparator.comparing(Studio::getApartmentNumber));
        aprtsStusa.add(studioOnStusa);
        aprtsStusa.add(pentHouseOnStusa);
        Dwelling highRiseOnStusa = new ApartmentType("Highrise on Stusa", "39, Stusa St.",aprtsStusa,
                30000, 4,31,true, Heating.INDIVIDUAL, true, 800,
                200, 200, 500, 500, 100, true, true);
        System.out.println(highRiseOnStusa);
        Dwelling townhouseProvesin = new CottageTown("Provesin","152, Glynyansky tract St.",
                31000,2,31,true,Heating.INDIVIDUAL, true,300,
                300, 210, 300, 500, 700, 29);
        System.out.println(townhouseProvesin);
        Dwelling cottageTimberland = new DetachedHouse("КМ TIMBERLAND", "66, Lysenytska St.",
                28000, 3,34, true,Heating.INDIVIDUAL, true,300,
                200, 300, 500, 400, 800, 1.5F);
        System.out.println(cottageTimberland);
    }
}