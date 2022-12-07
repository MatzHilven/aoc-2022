package me.matzhilven.aoc_2022.day_7;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Day7_Part1 {
    private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void main(String[] args) {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_7.txt");

        HashMap<String, Integer> contents = new HashMap<>();
        String currentDirectory = "";

        for (String line : input) {
            if (line.contains("$ cd")) {
                String dir = line.substring(5);
                if ("..".equals(dir)) {
                    currentDirectory = currentDirectory.substring(0, currentDirectory.lastIndexOf("/"));
                } else {
                    currentDirectory = currentDirectory + "/" + dir;
                }
            } else if (PATTERN.matcher(line.substring(0, 1)).matches()) {
                int filesize = Integer.parseInt(line.split(" ")[0]);
                String path = currentDirectory;
                while (path.length() > 0) {
                    contents.merge(path, filesize, Integer::sum);
                    path = path.substring(0, path.lastIndexOf("/"));
                }
            }
        }
        System.out.println(contents.values().stream().mapToInt(Integer::intValue).filter(size -> size < 100000).sum());
    }
}
