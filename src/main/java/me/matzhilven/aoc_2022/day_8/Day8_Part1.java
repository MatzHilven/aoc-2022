package me.matzhilven.aoc_2022.day_8;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.List;

public class Day8_Part1 {

    public static void main(String[] args) {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_8.txt");

        int visible = 0;

        int i = 0;
        for (String row : input) {
            if (i == 0 || i == input.size() - 1) {
                visible += row.length();
                i++;
                continue;
            }

            int j = 0;
            for (String tree : row.split("")) {
                if (j == 0 || j == row.length() - 1) {
                    visible++;
                    j++;
                    continue;
                }
                int height = Integer.parseInt(tree);

                boolean visibleL = true;
                boolean visibleR = true;
                boolean visibleT = true;
                boolean visibleB = true;

                for (int k = 0; k < j; k++) {
                    int lHeight = Integer.parseInt(String.valueOf(row.charAt(k)));

                    if (lHeight >= height) {
                        visibleL = false;
                        break;
                    }
                }

                for (int k = j + 1; k < row.length(); k++) {
                    int rHeight = Integer.parseInt(String.valueOf(row.charAt(k)));

                    if (rHeight >= height) {
                        visibleR = false;
                        break;
                    }
                }

                for (int k = 0; k < i; k++) {
                    int tHeight = Integer.parseInt(String.valueOf(input.get(k).charAt(j)));
                    if (tHeight >= height) {
                        visibleT = false;
                        break;
                    }
                }

                for (int k = input.size() - 1; k > i; k--) {
                    int bHeight = Integer.parseInt(String.valueOf(input.get(k).charAt(j)));

                    if (bHeight >= height) {
                        visibleB = false;
                        break;
                    }
                }

                if (visibleL || visibleR || visibleT || visibleB) visible++;
                j++;
            }
            i++;
        }

        System.out.println(visible);

    }
}
