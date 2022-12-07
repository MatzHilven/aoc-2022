package me.matzhilven.aoc_2022.day_6;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.ArrayDeque;

public class Day6_Part2 {

    public static void main(String[] args) {
        String input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_6.txt").get(0);

        ArrayDeque<String> characters = new ArrayDeque<>();
        int start = 0;

        for (String s : input.split("")) {
            if (characters.stream().distinct().count() != characters.size()) {
                characters.removeFirst();
            }

            if (characters.stream().distinct().count() == 14) break;

            characters.add(s);
            start++;
        }

        System.out.println(start);
    }
}
