package ooo.sansk.adventofcode2020.day1.challenge1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final int ADDITION_TARGET = 2020;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please provide the path to the input file");
        }
        List<Integer> numbers = readIntegersFromInput(args[0]);

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                int first = numbers.get(i);
                int second = numbers.get(j);
                if(first + second == ADDITION_TARGET) {
                    System.out.println("Found numbers " + first + " and " + second + ". Their product is " + (first * second));
                    return;
                }
            }
        }
    }

    private static List<Integer> readIntegersFromInput(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        } catch (IOException e) {
            return List.of();
        }
    }
}
