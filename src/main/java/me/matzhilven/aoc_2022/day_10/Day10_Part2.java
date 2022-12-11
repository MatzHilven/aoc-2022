package me.matzhilven.aoc_2022.day_10;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.List;

public class Day10_Part2 {

    public static void main(String[] args) {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_10.txt");


        StringBuilder crt = new StringBuilder();
        String[] spritePosition = "###.....................................".split("");

        for (String instruction : input) {
            crt.append(spritePosition[crt.length() % 40]);

            String[] split = instruction.split(" ");

            if (split[0].equals("addx")) {
                crt.append(spritePosition[crt.length() % 40]);

                int value = Integer.parseInt(split[1]);

                if (value >= 0) {
                    for (int i = 0; i < value; i++) {
                        int j;
                        String lastElement = spritePosition[spritePosition.length - 1];
                        for (j = spritePosition.length - 1; j > 0; j--) spritePosition[j] = spritePosition[j - 1];
                        spritePosition[0] = lastElement;
                    }
                } else {
                    for (int i = 0; i < Math.abs(value); i++) {
                        int j;
                        String firstElement = spritePosition[0];
                        for (j = 0; j < spritePosition.length - 1; j++)
                            spritePosition[j] = spritePosition[j + 1];
                        spritePosition[j] = firstElement;
                    }
                }
            }
        }

        for (int i = 0; i < crt.length(); i += 40) {
            System.out.println(crt.substring(i, i + 40));
        }

        // ZUPRFECL
    }
}
