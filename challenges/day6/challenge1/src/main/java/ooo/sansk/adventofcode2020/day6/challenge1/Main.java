package ooo.sansk.adventofcode2020.day6.challenge1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        int totalAnswerCount = readInput().stream()
            .mapToInt(Set::size)
            .sum();
        System.out.println("Total amount of positive answers: " + totalAnswerCount);

    }

    private static List<Set<Character>> readInput() throws IOException {
        List<Set<Character>> answers = new ArrayList<>();

        Scanner input = new Scanner(Paths.get("input.txt")).useDelimiter("\\r?\\n\\r?\\n");
        while(input.hasNext()) {
            Set<Character> positiveAnswers = new HashSet<>();
            Matcher group = Pattern.compile("\\w").matcher(input.next());
            while (group.find()) {
                positiveAnswers.add(group.group().charAt(0));
            }
            answers.add(positiveAnswers);
        }
        return answers;
    }
}
