package ua.lviv.iot.lab2.manager.impl;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.junit.jupiter.api.*;
import ua.lviv.iot.lab2.models.*;

import static org.junit.jupiter.api.Assertions.*;

public class DwellingManagerTest {
    DwellingManager manager;
    List<Dwelling> dwellings;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {

    }

    @BeforeEach
    void setUp() throws Exception {
        manager = new DwellingManager();
        dwellings = generateListOfDwellings();
        manager.addDwelling(dwellings);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    public void testGeneral() {
        manager.sortByPrice(dwellings, Choice.ASCENDING);
        assertNotNull(manager.toString());
        manager.sortByPrice(dwellings, Choice.DESCENDING);
        assertNotNull(manager.toString());
        assertNull(manager.findByName(dwellings, "NotInList"));
        assertNotNull(manager.findByLocation(dwellings, "9, Stusa"));
    }

    @Test
    void addDwellingTest() {
        Assertions.assertFalse(manager.getDwellingsMap().isEmpty());
        Assertions.assertEquals(4, manager.getDwellingsMap().size());
    }

    @Test
    void findByNameTest() {
        String expectedDwellingName = "Provesin";
        String actualDwellingName = manager.findByName(dwellings, "Provesin").getName();
        assertEquals(expectedDwellingName, actualDwellingName);
    }

    @Test
    void findByLocationTest() {
        String expectedDwellingName = "Highrise on Stusa";
        String actualDwellingName = manager.findByLocation(dwellings, "9, Stusa").getName();
        assertEquals(expectedDwellingName, actualDwellingName);
    }

    @Test
    void sortByPriceTest() {
        float[] expectedAscPrices = {28000, 30000, 31000, 46000};
        manager.sortByPrice(dwellings, Choice.ASCENDING);
        IntStream.range(0, 4).forEachOrdered(n -> {
            assertEquals(expectedAscPrices[n], dwellings.get(n).getPricePerSquareMeter());
        });
        float[] expectedDescPrices = {46000, 31000, 30000, 28000};
        manager.sortByPrice(dwellings, Choice.DESCENDING);
        IntStream.range(0, 4).forEachOrdered(n -> {
            assertEquals(expectedDescPrices[n], dwellings.get(n).getPricePerSquareMeter());
        });
    }

    @Test
    void sortByLocationTest() {
        manager.sortByLocation(dwellings, Choice.ALPHABETICAL);
        Streets[] expectedAlphabLocations = {Streets.GLYNYANSKY_TRACT, Streets.LYPYNSKY, Streets.LYSYNETSKA, Streets.STUSA};
        IntStream.range(0, 4).forEachOrdered(n -> {
            assertEquals(expectedAlphabLocations[n], dwellings.get(n).getStreetName());
        });
        manager.sortByLocation(dwellings, Choice.NON_ALPHABETICAL);
        Streets[] expecteNonAlphabLocations = {Streets.STUSA, Streets.LYSYNETSKA, Streets.LYPYNSKY, Streets.GLYNYANSKY_TRACT};
        IntStream.range(0, 4).forEachOrdered(n -> {
            assertEquals(expecteNonAlphabLocations[n], dwellings.get(n).getStreetName());
        });
    }

    public List<Dwelling> generateListOfDwellings() {
        List<Dwelling> dwellings = new LinkedList<>();
        Studio studioOnStusa = new Studio(25, 21, 3, 2,
                "put into operation");
        PentHouse pentHouseOnStusa = new PentHouse(4, 32, 4, 3,
                "put into operation", true);
        TreeSet<Studio> apartmentsStusa = new TreeSet<>(Comparator.comparing(Studio::getApartmentNumber));
        apartmentsStusa.add(studioOnStusa);
        apartmentsStusa.add(pentHouseOnStusa);
        dwellings.add(new CottageTown("LYPYNSKY 34", "34", Streets.LYPYNSKY,
                46000, 2, 32, true, Heating.INDIVIDUAL, true, 100,
                200, 210, 310, 400, 300, 4));
        dwellings.add(new ApartmentType("Highrise on Stusa", "9", Streets.STUSA,
                30000, apartmentsStusa, 4, 31, true, Heating.INDIVIDUAL, true,
                800, 200, 200, 500, 500, 100, true, true));
        dwellings.add(new CottageTown("Provesin", "162", Streets.GLYNYANSKY_TRACT,
                31000, 2, 31, true, Heating.INDIVIDUAL, true, 300,
                300, 210, 300, 500, 700, 29));
        dwellings.add(new DetachedHouse("TH TIMBERLAND", "66", Streets.LYSYNETSKA,
                28000, 3, 34, true, Heating.INDIVIDUAL, true, 300,
                200, 300, 500, 400, 800, 1.5F));
        return dwellings;
    }
}