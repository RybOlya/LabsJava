package ua.lviv.iot.lab2.writer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.lab2.manager.impl.DwellingManagerTest;
import ua.lviv.iot.lab2.models.DetachedHouse;
import ua.lviv.iot.lab2.models.Dwelling;
import ua.lviv.iot.lab2.models.Heating;
import ua.lviv.iot.lab2.models.Streets;
import ua.lviv.iot.lab2.writer.DwellingWriter;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DwellingWriterTest extends DwellingManagerTest {
    List<Dwelling> dwellings = generateListOfDwellings();
    File csvOutputFile = new File("src/test/resources/DwellingsWriter.csv");

    @Test
    void writingEmptyListToFileTest() throws IOException {
        List<Dwelling> dwellings = new LinkedList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    DwellingWriter.writeToFile(dwellings);
                });
        assertFalse(csvOutputFile.exists());
    }

    @Test
    void writingOneElementToFileTest() throws IOException {
        List<Dwelling> dwelling = new LinkedList<>();
        dwelling.add(new DetachedHouse("TH TIMBERLAND", "66", Streets.LYSYNETSKA,
                28000, 3, 34, true, Heating.INDIVIDUAL, true, 300,
                200, 300, 500, 400, 800, 1.5F));
        int count = 0;
        try (FileWriter writer = new FileWriter(csvOutputFile);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(csvOutputFile));) {
            DwellingWriter.writeToFile(dwelling);
            while(bufferedReader.readLine()!=null){
                count++;
            }
        }
        assertEquals(2,count);
    }

    @Test
    void writingToFileTest() throws IOException {
        Assertions.assertFalse(dwellings.isEmpty());
        try (FileWriter writer = new FileWriter(csvOutputFile)) {

            DwellingWriter.writeToFile(dwellings);
        }
        assertTrue(csvOutputFile.exists());
    }
}
