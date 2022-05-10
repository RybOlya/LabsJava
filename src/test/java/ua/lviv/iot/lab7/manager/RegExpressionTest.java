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
        String text = "Iyi dost kara gunde belli olur lorem ipsum dolor sit amet consectetur adipiscing elit " +
                "in sit amet turpis a quam molestie feugiat etiam fringilla lectus nibh " +
                "vestibulum vehicula finibus augue eget scelerisque";
        Files.write(Paths.get("src/test/resources/text.txt"), text.getBytes());
    }

    @Test
    void deleteWordWithConsonantAndLengthOfNTest() throws Exception {
        regex.deleteWordWithConsonantAndLengthOfN();
        String expected = "Iyi gunde belli olur lorem ipsum dolor sit amet consectetur adipiscing elit in sit amet " +
                "turpis a molestie feugiat etiam fringilla lectus vestibulum vehicula finibus augue eget scelerisque";
        String actual = regex.fileToString("src/test/resources/text.txt");
        Assertions.assertEquals(expected, actual);
    }
}