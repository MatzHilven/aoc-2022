package me.matzhilven.aoc_2022.day_11;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.*;

public class Day11_Part2 {

    public static void main(String[] args) {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_11.txt");

        HashMap<Integer, Monkey> monkeys = new HashMap<>();

        Monkey current = null;

        for (String s : input) {
            if (s.equals("")) {
                monkeys.put(current.getId(), current);
                current = null;
                continue;
            }

            if (s.contains("Starting items:")) {
                List<Long> collect = new ArrayList<>(Arrays.stream(s.replace("Starting items: ", "")
                        .trim().split(",")).map(String::trim).map(Long::parseLong).toList());

                Collections.reverse(collect);
                Stack<Long> stack = new Stack<>();
                collect.forEach(stack::push);
                current.setToInspect(stack);
            } else if (s.contains("Operation:")) {
                current.setOperation(s.replace("Operation: new = old ", "").trim());
            } else if (s.contains("Test:")) {
                current.setDivisibleByTest(Integer.parseInt(s.replace("Test: divisible by ", "").trim()));
            } else if (s.contains("If true:")) {
                current.setTestTrueMonkeyID(Integer.parseInt(s.replace("If true: throw to monkey", "").trim()));
            } else if (s.contains("If false:")) {
                current.setTestFalseMonkeyID(Integer.parseInt(s.replace("If false: throw to monkey", "").trim()));
            } else {
                current = new Monkey(Integer.parseInt(s.replace("Monkey ", "").replace(":", "")));
            }
        }

        monkeys.put(current.getId(), current);

        HashMap<Integer, Long> inspecting = new HashMap<>();
        monkeys.keySet().forEach(integer -> inspecting.put(integer, 0L));

        for (int i = 1; i <= 10000; i++) {
            for (Monkey monkey : monkeys.values()) {
                while (!monkey.getToInspect().isEmpty()) {
                    inspecting.computeIfPresent(monkey.getId(), (integer, integer2) -> integer2 + 1L);
                    long toInspect = monkey.getToInspect().pop();

                    toInspect = update(monkey.getOperation(), toInspect);

                    if (toInspect % monkey.getDivisibleByTest() == 0) {
                        monkeys.get(monkey.getTestTrueMonkeyID()).getToInspect().push(toInspect);
                    } else {
                        monkeys.get(monkey.getTestFalseMonkeyID()).getToInspect().push(toInspect);
                    }
                }
            }
        }

        monkeys.keySet().forEach(integer -> {
            System.out.println("Monkey " + integer + " inspected items " + inspecting.get(integer) + " times.");
        });

        long result = inspecting.values().stream().sorted(Comparator.reverseOrder()).limit(2).reduce(1L, (a, b) -> a * b);

        System.out.println(result);
    }

    private static long update(String operation, long toInspect) {

        long val = operation.split(" ")[1].equals("old") ? toInspect : Integer.parseInt(operation.split(" ")[1]);

        if (operation.charAt(0) == '*') {
            return toInspect * val;
        } else {
            return toInspect + val;
        }
    }

    static class Monkey {
        private final int id;
        private Stack<Long> toInspect;
        private String operation;
        private int divisibleByTest;
        private int testTrueMonkeyID;
        private int testFalseMonkeyID;

        Monkey(int id) {
            this.id = id;

        }

        public int getId() {
            return id;
        }

        public Stack<Long> getToInspect() {
            return toInspect;
        }

        public void setToInspect(Stack<Long> toInspect) {
            this.toInspect = toInspect;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public int getDivisibleByTest() {
            return divisibleByTest;
        }

        public void setDivisibleByTest(int divisibleByTest) {
            this.divisibleByTest = divisibleByTest;
        }

        public int getTestTrueMonkeyID() {
            return testTrueMonkeyID;
        }

        public void setTestTrueMonkeyID(int testTrueMonkeyID) {
            this.testTrueMonkeyID = testTrueMonkeyID;
        }

        public int getTestFalseMonkeyID() {
            return testFalseMonkeyID;
        }

        public void setTestFalseMonkeyID(int testFalseMonkeyID) {
            this.testFalseMonkeyID = testFalseMonkeyID;
        }
    }
}
