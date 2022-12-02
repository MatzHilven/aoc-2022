package me.matzhilven.aoc_2022.day_2;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.HashMap;
import java.util.List;

public class Day2_Part2 {

    public static final HashMap<String, Integer> POINTS_MAP = new HashMap<>();
    public static final HashMap<String, String> WIN_MOVES_MAP = new HashMap<>();
    public static final HashMap<String, String> DRAW_MOVES_MAP = new HashMap<>();
    public static final HashMap<String, String> LOSE_MOVES_MAP = new HashMap<>();

    static {
        POINTS_MAP.put("X", 1);
        POINTS_MAP.put("Y", 2);
        POINTS_MAP.put("Z", 3);

        DRAW_MOVES_MAP.put("A", "X");
        DRAW_MOVES_MAP.put("B", "Y");
        DRAW_MOVES_MAP.put("C", "Z");

        WIN_MOVES_MAP.put("A", "Y");
        WIN_MOVES_MAP.put("B", "Z");
        WIN_MOVES_MAP.put("C", "X");

        LOSE_MOVES_MAP.put("A", "Z");
        LOSE_MOVES_MAP.put("B", "X");
        LOSE_MOVES_MAP.put("C", "Y");
    }

    public static void main(String[] args) {
        List<String> strings = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_2.txt");

        int score = 0;

        for (String line : strings) {
            String[] split = line.split(" ");

            String elfInput = split[0];
            String code = split[1];

            String playerInput = code.equals("X") ? LOSE_MOVES_MAP.get(elfInput)
                    : code.equals("Y") ? DRAW_MOVES_MAP.get(elfInput) : WIN_MOVES_MAP.get(elfInput);
            score += POINTS_MAP.get(playerInput);
            score += code.equals("X") ? 0 : code.equals("Y") ? 3 : 6;
        }

        System.out.println(score);
    }

}
