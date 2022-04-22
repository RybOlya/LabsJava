package ua.lviv.iot.lab2.manager.impl;

import org.junit.jupiter.api.*;
import org.meanbean.test.BeanTester;
import ua.lviv.iot.lab2.models.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DwellingManagerTest {
    private final DwellingManager manager = new DwellingManager();
    List<Dwelling> dwellings = generateListOfDwellings();
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception{
    }
    @BeforeEach
    void setUp() throws Exception {
        manager.addDwelling(dwellings);
    }
    @AfterEach
    void tearDown() throws Exception{
    }
    @Test   public void gettersAndSettersShouldFunctionCorrectly() {     BeanTester tester = new BeanTester();     tester.testBean(Studio.class); tester.testBean(InfrastructureProximity.class);    }
    @Test
    public void testGeneral(){
        manager.sortByPrice(dwellings, Choice.ASCENDING);
        assertNotNull(manager.toString());
        manager.sortByPrice(dwellings, Choice.DESCENDING);
        assertNotNull(manager.toString());
        assertNotNull(manager.findByName(dwellings,"Provesin"));
        assertNotNull(manager.findByLocation(dwellings,"9, Stusa"));
    }

    @Test
    void addDwellingTest() {
        Assertions.assertFalse(manager.getAllDwellings().isEmpty());
        Assertions.assertEquals(3,manager.getAllDwellings().size());
    }

    @Test
    void findByNameTest() {
        assertEquals(" Name='Provesin', location='162, Glynyansky Trakt St."
                ,manager.findByName(dwellings,"Provesin").toString());
    }

    @Test
    void findByLocationTest() {
        assertEquals(" Name='Highrise on Stusa', location='9, Stusa St. elevator=true, concierge=true"
                ,manager.findByLocation(dwellings,"9, Stusa").toString());
    }

    @Test
    void sortByPriceTest() {
        manager.sortByPrice(dwellings, Choice.ASCENDING);
        assertEquals("[ Name='TH TIMBERLAND', location='66, Lysynetska St., "+
                        " Name='Highrise on Stusa', location='9, Stusa St. elevator=true, concierge=true, "+
                        " Name='Provesin', location='162, Glynyansky Trakt St.]",dwellings.toString());
        manager.sortByPrice(dwellings, Choice.DESCENDING);
        assertEquals("[ Name='Provesin', location='162, Glynyansky Trakt St., "+
                        " Name='Highrise on Stusa', location='9, Stusa St. elevator=true, concierge=true, "+
                        " Name='TH TIMBERLAND', location='66, Lysynetska St.]",dwellings.toString());
    }

    @Test
    void sortByLocationTest() {
        manager.sortByLocation(dwellings, Choice.ALPHABETICAL);
        assertEquals("[ Name='Provesin', location='162, Glynyansky Trakt St., "+
                        " Name='TH TIMBERLAND', location='66, Lysynetska St., "+
                        " Name='Highrise on Stusa', location='9, Stusa St. elevator=true, concierge=true]"
                ,dwellings.toString());
        manager.sortByLocation(dwellings, Choice.NON_ALPHABETICAL);
        assertEquals("[ Name='Highrise on Stusa', location='9, Stusa St. elevator=true, concierge=true, "+
                        " Name='TH TIMBERLAND', location='66, Lysynetska St., "+
                        " Name='Provesin', location='162, Glynyansky Trakt St.]",dwellings.toString());
    }

    private List<Dwelling> generateListOfDwellings() {
        List<Dwelling> dwellings = new LinkedList<>();
        Studio studioOnStusa = new Studio(25, 21, 3, 2,
                "put into operation");
        PentHouse pentHouseOnStusa = new PentHouse(4, 32,4,3,
                "put into operation", true);
        TreeSet<Studio> apartmentsStusa = new TreeSet<>(Comparator.comparing(Studio::getApartmentNumber));
        apartmentsStusa.add(studioOnStusa);
        apartmentsStusa.add(pentHouseOnStusa);
        dwellings.add(new ApartmentType("Highrise on Stusa","9",Streets.STUSA,
                30000, apartmentsStusa,4,31,true, Heating.INDIVIDUAL, true, 800,
                200, 200, 500, 500, 100, true, true));
        dwellings.add(new CottageTown("Provesin","162", Streets.GLYNYANSKY_TRACT,
                31000,2,31,true,Heating.INDIVIDUAL, true,300,
                300, 210, 300, 500, 700, 29));
        dwellings.add(new DetachedHouse("TH TIMBERLAND","66", Streets.LYSYNETSKA,
                28000, 3,34, true,Heating.INDIVIDUAL, true,300,
                200, 300, 500, 400, 800, 1.5F));
        return dwellings;
    }
}