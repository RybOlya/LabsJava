package ua.lviv.iot.lab7.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class RegExpressionTest {
    RegExpression regex = new RegExpression();

    @BeforeAll
    static void beforeAll() throws IOException {
        String text = "Iyi dost kara gunde belli olur lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit. In sit amet turpis a quam molestie feugiat. Etiam fringilla lectus nibh" +
                ". Vestibulum vehicula finibus augue eget scelerisque.";
        Files.write(Paths.get("src/test/resources/text.txt"), text.getBytes());
    }

    @Test
    void deleteWordWithVowelAndLengthOfNTest() throws Exception {
        regex.deleteWordWithVowelAndLengthOfN();
        String expected = "Iyi dost kara gunde belli lorem ipsum dolor sit, consectetur" +
                " adipiscing elit. In sit turpis a quam molestie feugiat. Etiam fringilla lectus nibh. Vestibulum" +
                " vehicula finibus augue scelerisque.";
        String actual = regex.fileToString("src/test/resources/text.txt");
        Assertions.assertEquals(expected, actual);
    }
}