package me.matzhilven.aoc_2022.day_4;

import me.matzhilven.aoc_2022.utils.FileUtils;
import me.matzhilven.aoc_2022.utils.Range;

import java.util.List;

public class Day4_Part1 {

    public static void main(String[] args) {
        List<String> strings = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_4.txt");

        int reAssignments = 0;

        for (String line : strings) {
            String[] sections = line.split(",");

            int firstSectionMin = Integer.parseInt(sections[0].split("-")[0]);
            int firstSectionMax = Integer.parseInt(sections[0].split("-")[1]);
            int secondSectionMin = Integer.parseInt(sections[1].split("-")[0]);
            int secondSectionMax = Integer.parseInt(sections[1].split("-")[1]);

            Range<Integer> firstRange = Range.between(firstSectionMin, firstSectionMax);
            Range<Integer> secondRange = Range.between(secondSectionMin, secondSectionMax);

            if (firstRange.containsRange(secondRange) || secondRange.containsRange(firstRange)) reAssignments++;
        }

        System.out.println(reAssignments);
    }

}
