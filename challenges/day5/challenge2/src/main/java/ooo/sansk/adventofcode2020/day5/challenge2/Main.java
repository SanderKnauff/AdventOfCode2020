package ooo.sansk.adventofcode2020.day5.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("input.txt"))) {
            int[] ids = stream.map(BoardingPass::parseBoardingPass)
                .mapToInt(BoardingPass::getId)
                .sorted()
                .toArray();

            for (int i = ids[0]; i < ids.length - 1; i++) {
                if (ids[i] + ids[i + 1] != ids[i] + ids[i] + 1) {
                    System.out.println("The missing id is " + (ids[i] + 1));
                    return;
                }
            }
            System.out.println("No missing id found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
