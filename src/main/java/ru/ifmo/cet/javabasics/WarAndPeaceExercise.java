package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {

        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        String txt = readAllLines(tome12Path, Charset.forName("windows-1251")).stream().collect(Collectors.joining(" "));
        txt += readAllLines(tome34Path, Charset.forName("windows-1251")).stream().collect(Collectors.joining(" "));
        txt = txt.replaceAll("[^a-zA-Zа-яА-Я]", " ").toLowerCase();

        Map<String, Integer> dict = new HashMap<>();
        Stream<String> textStr = Stream.of(txt.split(" "));
        textStr.forEach((String key) -> dict.put(key, dict.containsKey(key) ? dict.get(key) + 1 : 1));

        List<Map.Entry<String, Integer>> sortedDictionary = new ArrayList<>(dict.entrySet());
        Collections.sort(sortedDictionary, (o1, o2) -> (o1.getValue().equals(o2.getValue())) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
        return sortedDictionary.stream().filter(m -> (m.getKey().length() >= 4) && (m.getValue() >= 10))
                .map(m -> m.getKey() + " - " + m.getValue()).collect(Collectors.joining("\n"));
    }
}