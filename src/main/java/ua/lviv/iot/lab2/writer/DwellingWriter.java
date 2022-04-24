package ua.lviv.iot.lab2.writer;

import ua.lviv.iot.lab2.manager.impl.DwellingManager;
import ua.lviv.iot.lab2.models.Dwelling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DwellingWriter extends DwellingManager {
    public static void writeToFile(List<Dwelling> dwellings) throws IOException {
        //TODO: sort dwellings by class name
        File csvOutputFile = new File("DwellingsWriter.csv");
        try (FileWriter writer = new FileWriter(csvOutputFile)){
        String previousClassName = "";
        for(var dwelling:dwellings) {
            if(!dwelling.getClass().getSimpleName().equals(previousClassName)) {
                writer.write(dwelling.getHeaders());
                writer.write("\r\n");
                previousClassName = dwelling.getClass().getSimpleName();
            }
            writer.write(dwelling.toCSV());
            writer.write("\r\n");
            }
        }
        //assertTrue(csvOutputFile.exists());
    }
}

