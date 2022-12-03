package me.matzhilven.aoc_2022.day_3;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.List;

public class Day3_Part2 {


    public static void main(String[] args) {
        List<String> strings = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_3.txt");

        int prioritySum = 0;

        for (int i = 0; i < strings.size(); i += 3) {
            String firstRucksack = strings.get(i);
            String secondRucksack = strings.get(i + 1);
            String thirdRucksack = strings.get(i + 2);

            for (String s : firstRucksack.split("")) {
                if (secondRucksack.contains(s) && thirdRucksack.contains(s)) {
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
