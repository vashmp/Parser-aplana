package main.java;

import java.io.*;
import java.util.*;

/**
 * Parsing text file. Get statistics by words, get sorted
 * Print statistics and max repeated value
 * @author Nikita Blokhin
 */
public class Parser {
    public static void main (String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //BufferedReader br = new BufferedReader(
        //        new InputStreamReader(
        //                new FileInputStream("./src/main/resources/example.txt"), "UTF-8"));
        //FileInputStream dis = new FileInputStream("./src/main/resources/example.txt", "UTF-8");

        Scanner scanner = new Scanner(new File("./src/main/resources/example.txt"));
        Map<String, Integer> statistics = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
                    Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
        }
        //sorting HashMap by transform it to Treemap
        Map<String, Integer> statistic = new TreeMap<>(statistics);
        System.out.println("Sorted statistics: ");
        System.out.println(statistic);
        int maxValue = Collections.max(statistics.values());
        System.out.println("Max amount of duplicate value: " + maxValue);
        System.out.println("Word(s) that duplicated the most: ");
        //find keys that has max value
        for (Map.Entry<String, Integer> entry : statistics.entrySet()){
            if (maxValue == entry.getValue()){
                System.out.println(entry.getKey() + ":" + entry.getValue());

            }

        }
        scanner.close();
    }

}
