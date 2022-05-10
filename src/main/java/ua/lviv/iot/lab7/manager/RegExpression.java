package ua.lviv.iot.lab7.manager;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpression {
    public String fileToString(String filePath) throws Exception {
        String input;
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                input = sc.nextLine();
                sb.append(input);
            }

            if (sb.toString().equals("")) {
                throw new Exception("Empty file!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();
    }

    public void deleteWordWithConsonantAndLengthOfN() throws Exception {
        String filePath = "src/test/resources/text.txt";
        File file = new File(filePath);
        Scanner input = new Scanner(file);
        String regex1 = "\\b[^AEIOUYaeiouy]";
        String regex2 = "^[a-zA-Z]{4}$";
        String result = fileToString(filePath);
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        List<Pattern> patterns = new ArrayList<Pattern>();
        patterns.add(pattern1);
        patterns.add(pattern2);
        System.out.println("Words to delete are: ");
        while (input.hasNext()) {
            int count = 0;
            String word = input.next();
            for (Pattern pattern : patterns) {
                Matcher m = pattern.matcher(word);
                while (m.find()) {
                    count = count + 1;
                }
            }
            if (count < 2) {
                continue;
            }
            result = result.replaceAll(" " + word, "");
            System.out.println(word);
        }
        PrintWriter writer = new PrintWriter(filePath);
        writer.append(result);
        writer.flush();
        System.out.println(fileToString(filePath));
        input.close();
    }
}