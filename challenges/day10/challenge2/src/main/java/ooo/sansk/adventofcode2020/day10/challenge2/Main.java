package ooo.sansk.adventofcode2020.day10.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("input.txt"))) {
            final LinkedList<Integer> collect = lines.map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
            collect.offerFirst(0);
            collect.offerLast(collect.get(collect.size() - 1) + 3);

            Adapter lastAdapter = null;
            final Deque<Adapter> window = new LinkedList<>();
            for (Integer integer : collect) {
                long arrangements = 0L;
                for (Adapter other : window) {
                    if (other.canConnect(integer)) {
                        arrangements += (other.getArrangements());
                    }
                }
                lastAdapter = new Adapter(Math.max(1, arrangements), integer);
                window.addLast(lastAdapter);
                if(window.size() > 3) {
                    window.pop();
                }
            }

            System.out.printf("There are %,d different arrangements possible", lastAdapter.getArrangements());
        }
    }

}
