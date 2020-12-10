package ooo.sansk.adventofcode2020.day10.challenge1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("input.txt"))) {
            final LinkedList<Adapter> collect = lines.map(Integer::parseInt)
                .sorted()
                .map(Adapter::new)
                .collect(Collectors.toCollection(LinkedList::new));
            collect.offerFirst(new Adapter(0));
            collect.offerLast(new Adapter(collect.get(collect.size() - 1).getRatedJoltage() + 3));

            int[] diffs = new int[] {0, 0, 0};
            Adapter previous = null;
            for (Adapter adapter : collect) {
                System.out.println(adapter);
                if(previous != null) {
                    diffs[adapter.calculateJoltageDifference(previous) - 1]++;
                }
                previous = adapter;
            }
            System.out.println("There were " + diffs[0] + " 1 jolt jumps and " + diffs[2] + " 3 jolt jumps. Multiplied they become " + (diffs[0] * diffs[2]));
        }
    }

}
