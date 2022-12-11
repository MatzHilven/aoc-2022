package me.matzhilven.aoc_2022.day_10;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.List;

public class Day10_Part1 {

    public static void main(String[] args) {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_10.txt");

        int x = 1;
        int cycles = 0;
        int signalStrength = 0;

        for (String instruction : input) {
            cycles++;

            if (cycles % 40 == 20) signalStrength += x * cycles;

            String[] split = instruction.split(" ");

            if (split[0].equals("addx")) {
                cycles++;
                if (cycles % 40 == 20) signalStrength += x * cycles;
                x += Integer.parseInt(split[1]);
            }

        }

        System.out.println(signalStrength);
    }
}
