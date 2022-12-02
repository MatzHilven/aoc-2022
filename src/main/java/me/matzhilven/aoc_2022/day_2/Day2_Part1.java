package me.matzhilven.aoc_2022.day_2;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.HashMap;
import java.util.List;

public class Day2_Part1 {

    public static final HashMap<String, Integer> POINTS_MAP = new HashMap<>();

    static {
        POINTS_MAP.put("X", 1);
        POINTS_MAP.put("Y", 2);
        POINTS_MAP.put("Z", 3);
    }

    public static void main(String[] args) {
        List<String> strings = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_2.txt");

        int score = 0;

        for (String line : strings) {
            String[] split = line.split(" ");

            score += POINTS_MAP.get(split[1]);
            score += getGamePoints(split[0], split[1]);
        }

        System.out.println(score);
    }

    private static int getGamePoints(String play1, String play2) {
        if ((play1.equals("A") && play2.equals("X")) || (play1.equals("B") && play2.equals("Y"))
                || (play1.equals("C") && play2.equals("Z"))) {
            return 3;
        } else if ((play1.equals("A") && play2.equals("Z")) || (play1.equals("B") && play2.equals("X"))
                || (play1.equals("C") && play2.equals("Y"))) {
            return 0;
        }
        return 6;
    }

}
