package me.matzhilven.aoc_2022.day_8;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.List;
import java.util.Map;

public class Day8_Part2 {

    public static void main(String[] args) {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_8.txt");

        int highestScore = 0;

        int i = 0;
        for (String row : input) {
            if (i == 0 || i == input.size() - 1) {
                i++;
                continue;
            }


            int j = 0;
            for (String tree : row.split("")) {
                if (j == 0 || j == row.length() - 1) {
                    j++;
                    continue;
                }

                int height = Integer.parseInt(tree);

                int visibleL = 0;
                int visibleR = 0;
                int visibleT = 0;
                int visibleB = 0;

                for (int k = j - 1; k >= 0; k--) {
                    int lHeight = Integer.parseInt(String.valueOf(row.charAt(k)));
                    visibleL++;
                    if (lHeight >= height) break;
                }

                for (int k = j + 1; k < row.length(); k++) {
                    int rHeight = Integer.parseInt(String.valueOf(row.charAt(k)));
                    visibleR++;
                    if (rHeight >= height) break;
                }

                for (int k = i - 1; k >= 0; k--) {
                    int tHeight = Integer.parseInt(String.valueOf(input.get(k).charAt(j)));
                    visibleT++;
                    if (tHeight >= height) break;
                }

                for (int k = i + 1; k < input.size(); k++) {
                    int bHeight = Integer.parseInt(String.valueOf(input.get(k).charAt(j)));
                    visibleB++;
                    if (bHeight >= height) break;
                }

                visibleL = Math.max(1, visibleL);
                visibleR = Math.max(1, visibleR);
                visibleT = Math.max(1, visibleT);
                visibleB = Math.max(1, visibleB);

                int scenicScore = visibleL * visibleR * visibleT * visibleB;
                highestScore = Math.max(highestScore, scenicScore);

                j++;
            }
            i++;
        }

        System.out.println(highestScore);

    }
}
