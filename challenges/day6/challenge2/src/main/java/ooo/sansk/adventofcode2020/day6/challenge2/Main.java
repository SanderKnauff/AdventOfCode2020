package ooo.sansk.adventofcode2020.day6.challenge2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        int totalAnswerCount = readInput().stream()
            .mapToInt(Set::size)
            .sum();
        System.out.println("Total amount of positive answers: " + totalAnswerCount);

    }

    private static List<Set<Character>> readInput() throws IOException {
        List<Set<Character>> answers = new ArrayList<>();

        Scanner groupAnswers = new Scanner(Paths.get("input.txt")).useDelimiter("\\r?\\n\\r?\\n");
        while(groupAnswers.hasNext()) {
            Set<Character> positiveAnswers = null;
            Scanner group = new Scanner(groupAnswers.next()).useDelimiter("\\r?\\n");
            while (group.hasNext()) {
                if(positiveAnswers == null) {
                    positiveAnswers = stringToCharSet(group.next());
                } else {
                    positiveAnswers.retainAll(stringToCharSet(group.next()));
                }
            }
            answers.add(positiveAnswers);
        }
        return answers;
    }

    public static Set<Character> stringToCharSet(String string) {
        Set<Character> ret = new HashSet<>();
        for (char c : string.toCharArray()) {
            ret.add(c);
        }
        return ret;
    }
}
