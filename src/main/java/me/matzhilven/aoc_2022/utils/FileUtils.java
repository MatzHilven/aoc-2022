package me.matzhilven.aoc_2022.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileUtils {

    public static List<String> readLines(String path) {
        File inputFile = new File(path);
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            return bufferedReader.lines().toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
