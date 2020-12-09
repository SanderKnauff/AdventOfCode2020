package ooo.sansk.adventofcode2020.day9.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Long> numbers = Files.lines(Paths.get("input.txt"))
            .map(Long::parseLong)
            .collect(Collectors.toList());
        final long sum = streamNumbers(numbers);
        System.out.println("The sum is " + sum);
    }

    private static long streamNumbers(List<Long> numbers) {
        LinkedList<Long> buffer = new LinkedList<>();

        for (Long number : numbers) {
            if(buffer.size() < 25) {
                buffer.add(number);
            } else {
                if (!isValidSum(buffer, number)) {
                    System.out.println(number + ": " + buffer);
                    return findContiguousSum(numbers, number);
                } else {
                    buffer.removeLast();
                    buffer.push(number);
                }
            }
        }
        return -1;
    }

    private static long findContiguousSum(List<Long> buffer, long currentNumber) {
        for (int i = 0; i < buffer.size(); i++) {
            long sum = buffer.get(i);
            System.out.println(sum);
            for (int j = i+1; j < buffer.size(); j++) {
                sum += buffer.get(j);
                System.out.println(sum);
                if(sum == currentNumber) {
                    System.out.println("i: " + i + ", j: " + j);
                    long lowest = Long.MAX_VALUE;
                    long highest = 0;
                    for (int k = i; k <= j; k++) {
                        lowest = Math.min(lowest, buffer.get(k));
                        highest = Math.max(highest, buffer.get(k));
                    }
                    System.out.println("lowest: " + lowest + ", highest: " + highest);
                    return lowest + highest;
                } else if (sum > currentNumber) {
                    System.out.println("Breaking:");
                    System.out.println(sum + " is higher than");
                    System.out.println(currentNumber);
                    break;
                }
            }
            System.out.println("--------------");
        }
        return -1;
    }

    private static boolean isValidSum(List<Long> buffer, long currentNumber) {
        for (int i = 0; i < buffer.size(); i++) {
            for (int j = i + 1; j < buffer.size(); j++) {
                if(buffer.get(i) + buffer.get(j) == currentNumber) {
                    return true;
                }
            }
        }
        return false;
    }
}
