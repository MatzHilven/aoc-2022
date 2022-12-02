package me.matzhilven.aoc_2022.day_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1_Part2 {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_1.txt");
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Integer> all = new ArrayList<>();
        int current = 0;

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                all.add(current);
                current = 0;
                continue;
            }

            current += Integer.parseInt(line);
        }

        fileReader.close();

        all.sort(Comparator.reverseOrder());

        System.out.println("Max Calories 1: " + all.get(0));
        System.out.println("Max Calories 2: " + all.get(1));
        System.out.println("Max Calories 3: " + all.get(2));
        System.out.println("Total: " + all.subList(0,3).stream().mapToInt(Integer::intValue).sum());
    }

}