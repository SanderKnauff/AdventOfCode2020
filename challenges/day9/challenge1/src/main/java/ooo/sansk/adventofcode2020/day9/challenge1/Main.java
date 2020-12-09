package ooo.sansk.adventofcode2020.day9.challenge1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final long firstInvalidNumber = streamNumbers();
        System.out.println("The first number with no sum is " + firstInvalidNumber);
    }

    private static long streamNumbers() {
        LinkedList<Long> buffer = new LinkedList<>();

        String currentLine;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("input.txt"))) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                final long currentNumber = Long.parseLong(currentLine);
                if(buffer.size() < 25) {
                    buffer.add(currentNumber);
                } else {
                    if (!isValidSum(buffer, currentNumber)) {
                        return currentNumber;
                    } else {
                        buffer.removeLast();
                        buffer.push(currentNumber);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
