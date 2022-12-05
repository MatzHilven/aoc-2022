package me.matzhilven.aoc_2022.day_5;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5_Part1 {

    public static final ArrayList<ArrayDeque<Character>> STACKS = new ArrayList<>();

    public static void main(String[] args) {
        List<String> strings = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_5.txt");

        /*
            Initialize STACK
         */
        for (String line : strings) {

            if (line.contains("1")) break;

            for (int i = 1, stack = 1; i < line.length(); i += 4, stack++) {
                if (line.charAt(i) != ' ') {
                    while (STACKS.size() < stack) STACKS.add(new ArrayDeque<>());

                    STACKS.get(stack - 1).add(line.charAt(i));
                }
            }
        }

        for (String instruction : strings.subList(strings.indexOf("") + 1, strings.size())) {
            instruction = instruction.replaceAll("\\D", " ");
            List<Integer> split = Arrays.stream(instruction.split(" "))
                    .filter(s -> !s.equals("")).map(Integer::parseInt).toList();

            int amount = split.get(0);
            int from = split.get(1) - 1;
            int to = split.get(2) - 1;

            ArrayDeque<Character> fromQueue = STACKS.get(from);
            ArrayDeque<Character> toQueue = STACKS.get(to);

            for (int i = 0; i < amount; i++) {
                toQueue.addFirst(fromQueue.pop());
            }
        }

        STACKS.forEach(stack -> System.out.print(stack.peek()));
    }

}