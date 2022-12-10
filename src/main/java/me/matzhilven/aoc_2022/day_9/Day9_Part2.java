package me.matzhilven.aoc_2022.day_9;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9_Part2 {

    private static void moveKnot(int[][] rope, int knot) {
        if (Math.abs(rope[knot - 1][0] - rope[knot][0]) > 1) {
            if (rope[knot - 1][0] > rope[knot][0]) {
                rope[knot][0]++;
            } else {
                rope[knot][0]--;
            }
            if (rope[knot - 1][1] != rope[knot][1]) {
                if (rope[knot - 1][1] > rope[knot][1]) {
                    rope[knot][1]++;
                } else {
                    rope[knot][1]--;
                }
            }
        } else if (Math.abs(rope[knot - 1][1] - rope[knot][1]) > 1) {
            if (rope[knot - 1][1] > rope[knot][1]) {
                rope[knot][1]++;
            } else {
                rope[knot][1]--;
            }
            if (rope[knot - 1][0] != rope[knot][0]) {
                if (rope[knot - 1][0] > rope[knot][0]) {
                    rope[knot][0]++;
                } else {
                    rope[knot][0]--;
                }
            }
        }
    }

    public static int tailVisited(List<String> input, int knots) {
        Set<String> visited = new HashSet<>();
        visited.add("0.0");

        int[][] rope = new int[knots][2];
        for (String line : input) {
            String[] l = line.split(" ");
            String dir = l[0];
            int len = Integer.parseInt(l[1]);

            for (int i = 0; i < len; i++) {
                switch (dir) {
                    case "R" -> rope[0][0]++;
                    case "L" -> rope[0][0]--;
                    case "U" -> rope[0][1]++;
                    case "D" -> rope[0][1]--;
                }
                for (int k = 1; k < rope.length; k++) {
                    moveKnot(rope, k);
                }
                visited.add(rope[rope.length - 1][0] + "." + rope[rope.length - 1][1]);
            }
        }
        return visited.size();
    }

    public static void main(String[] args) throws Exception {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_9.txt");
        System.out.println(tailVisited(input, 10));
    }
}
