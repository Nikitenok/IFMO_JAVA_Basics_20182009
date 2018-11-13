package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        Map<String, Integer> words = new HashMap<>();
        String s = "";

        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        for (String line : readAllLines(tome12Path, Charset.forName("windows-1251"))) {
            line = line.replaceAll("[^а-яА-Яa-zA-Z]", " ");
            for (String word : line.split(" ")) {
                if (word.length() >= 4) {
                    word = word.toLowerCase();
                    if ((words.containsKey(word))) {
                        words.put(word, words.get(word) + 1);
                    } else {
                        words.put(word, 1);
                    }
                }
            }
        }

        for (String line : readAllLines(tome34Path, Charset.forName("windows-1251"))) {
            line = line.replaceAll("[^а-яА-Яa-zA-Z]", " ");
            for (String word : line.split(" ")) {
                if (word.length() >= 4) {
                    word = word.toLowerCase();
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    } else {
                        words.put(word, 1);
                    }
                }
            }
        }

        List<Map.Entry<String,Integer>> sort = new ArrayList<>(words.entrySet());

        Collections.sort(sort, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue()))
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for(Map.Entry entry: sort){
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (value >= 10) {
                s += key + " - " + value + "\n";
            }
        }

        return s.trim();
    }
}