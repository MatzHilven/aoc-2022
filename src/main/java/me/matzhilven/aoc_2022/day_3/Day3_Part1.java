package me.matzhilven.aoc_2022.day_3;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.Arrays;
import java.util.List;

public class Day3_Part1 {


    public static void main(String[] args) {
        List<String> strings = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_3.txt");

        int prioritySum = 0;

        for (String line : strings) {
            String[] firstCompartment = line.substring(0, line.length() / 2).split("");
            List<String> secondCompartment = Arrays.asList(line.substring(line.length() / 2).split(""));

            for (String s : firstCompartment) {
                if (secondCompartment.contains(s)) {
                    prioritySum += mapPriority(s);
                    break;
                }
            }
        }

        System.out.println(prioritySum);
    }

    public static int mapPriority(String s) {
        char c = s.charAt(0);
        return Character.isUpperCase(c) ? c - 38 : c - 96;
    }
}
