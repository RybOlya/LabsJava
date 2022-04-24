package writer;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.lab2.manager.impl.DwellingManagerTest;
import ua.lviv.iot.lab2.models.*;
import ua.lviv.iot.lab2.writer.DwellingWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DwellingWriterTest extends DwellingManagerTest {
    //DwellingWriter dwellingWriter = new DwellingWriter();
    List<Dwelling> dwellings = generateListOfDwellings();
    /*//TODO: sort dwellings by class name
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
    assertTrue(csvOutputFile.exists());
}*/
    @Test
    void writingAFileTest() throws IOException {

        File csvOutputFile = new File("DwellingsWriter.csv");
        /*        Dwelling cottageNext = new DetachedHouse("TH NEXT","26", Streets.LYSYNETSKA,
                28000, 3,34, true, Heating.INDIVIDUAL, true,300,
                200, 300, 500, 400, 800, 1.5F);
        Dwelling cottageBack = new DetachedHouse("TH BACK","26", Streets.LYSYNETSKA,
                28000, 3,34, true, Heating.INDIVIDUAL, true,300,
                200, 300, 500, 400, 800, 1.5F);
        Dwelling townhouseProudHills = new CottageTown("ProudHills","162", Streets.GLYNYANSKY_TRACT,
                31000,2,31,true,Heating.INDIVIDUAL, true,300,
                300, 210, 300, 500, 700, 29);

        dwellings.add(cottageNext);
        dwellings.add(cottageBack);
        dwellings.add(townhouseProudHills);

         */
        try (FileWriter writer = new FileWriter(csvOutputFile)) {
            //dwellingWriter.setCsvWriter(csvWriter);
            DwellingWriter.writeToFile(dwellings);
            //DwellingWriter.writeToFile(dwellings);
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
        }
        assertTrue(csvOutputFile.exists());
    }
}
