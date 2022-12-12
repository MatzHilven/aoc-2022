package me.matzhilven.aoc_2022.day_12;

import me.matzhilven.aoc_2022.utils.FileUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Day12_Part2 {

    static List<Point> moves = List.of(new Point(1, 0), new Point(-1, 0), new Point(0, 1), new Point(0, -1));

    public static void main(String[] args) {
        List<String> input = FileUtils.readLines("C:\\Users\\hilve\\Documents\\Coding\\Java\\aoc-2022\\src\\main\\resources\\input_12.txt");
        HashMap<Point, Byte> grid = readMap(input);

        Point start = grid.keySet().stream().filter(k -> grid.get(k) == 'S').findFirst().get();
        Point end = grid.keySet().stream().filter(k -> grid.get(k) == 'E').findFirst().get();
        grid.put(start, (byte) 'a');
        grid.put(end, (byte) 'z');

        System.out.println(shortestPath(grid, end, dh -> dh >= -1, p -> grid.get(p) == 'a'));

    }

    static int shortestPath(Map<Point, Byte> map, Point start, Function<Byte, Boolean> canMove, Function<Point, Boolean> target) {
        HashMap<Point, Integer> visited = new HashMap<>();
        LinkedList<Visit> toVisit = new LinkedList<>();
        toVisit.add(new Visit(start, 0));
        while (!toVisit.isEmpty()) {
            Visit visit = toVisit.removeFirst();
            if (!visited.containsKey(visit.point) || visited.get(visit.point) > visit.distance) {
                visited.put(visit.point, visit.distance);
                moves.stream().map(visit::move)
                        .filter(n -> map.containsKey(n.point))
                        .filter(n -> canMove.apply((byte) (map.get(n.point) - map.get(visit.point))))
                        .forEach(toVisit::add);
            }
        }

        return visited.keySet().stream()
                .filter(target::apply)
                .map(visited::get)
                .sorted().findFirst().orElse(-1);
    }

    static HashMap<Point, Byte> readMap(List<String> lines) {
        HashMap<Point, Byte> map = new HashMap<>();
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                map.put(new Point(x, y), (byte) lines.get(y).charAt(x));
            }
        }
        return map;
    }

    record Visit(Point point, int distance) {
        Visit move(Point v) {
            return new Visit(new Point(point.x + v.x, point.y + v.y), distance + 1);
        }
    }

    record Point(int x, int y) {
    }
}