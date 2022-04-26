package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.lab2.manager.impl.DwellingManagerTest;
import ua.lviv.iot.lab2.models.Dwelling;
import ua.lviv.iot.lab2.writer.DwellingWriter;

public class DwellingWriterTest extends DwellingManagerTest {
    List<Dwelling> dwellings = generateListOfDwellings();

    @Test
    void writingToFileTest() throws IOException {

        File csvOutputFile = new File("src/main/resources/DwellingsWriter.csv");
        try (FileWriter writer = new FileWriter(csvOutputFile)) {
            Assertions.assertFalse(dwellings.isEmpty());
            DwellingWriter.writeToFile(dwellings);
        }
        assertTrue(csvOutputFile.exists());
    }
}
