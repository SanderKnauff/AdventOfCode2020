package ooo.sansk.adventofcode2020.day5.challenge1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("input.txt"))) {
            stream.map(BoardingPass::parseBoardingPass)
                .mapToInt(BoardingPass::getId)
                .max()
                .ifPresentOrElse(
                    value -> System.out.println("The highest boarding pass id was " + value),
                    () -> System.out.println("No boarding pass id found")
                );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
