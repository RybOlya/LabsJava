package ua.lviv.iot.lab2.writer;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.lab2.manager.impl.DwellingManager;
import ua.lviv.iot.lab2.models.Dwelling;

public class DwellingWriter extends DwellingManager {
    public static void writeToFile(List<Dwelling> dwellings) throws IOException {
        File csvOutputFile = new File("src/main/resources/DwellingsWriter.csv");
        Charset charSet = StandardCharsets.UTF_8;
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(
                csvOutputFile.toPath(), charSet)) {
            String previousClassName = "";
            dwellings.sort(Comparator.comparing(dwelling -> dwelling.getClass().getName()));
            for (var dwelling : dwellings) {
                if (!dwelling.getClass().getSimpleName().equals(previousClassName)) {
                    bufferedWriter.write(dwelling.getHeaders());
                    bufferedWriter.write("\r\n");
                    previousClassName = dwelling.getClass().getSimpleName();
                }
                bufferedWriter.write(dwelling.toCSV());
                bufferedWriter.write("\r\n");
            }
        }
    }
}

