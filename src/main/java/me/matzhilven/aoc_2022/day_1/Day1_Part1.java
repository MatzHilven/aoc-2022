package me.matzhilven.aoc_2022.day_1;

import java.io.*;

public class Day1_Part1 {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_1.txt");
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int max = 0;
        int current = 0;

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                max = Math.max(max, current);
                current = 0;
                continue;
            }

            current += Integer.parseInt(line);
        }

        fileReader.close();

        System.out.println("Max Calories: " + max);
    }

}