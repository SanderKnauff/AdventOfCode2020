package ooo.sansk.adventofcode2020.day7.challenge1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String TARGET = "shiny gold";

    public static void main(String[] args) throws IOException {
        Map<String, Set<String>> bagParents = readLuggageRulesFromInput();

        Set<String> parents = findAllParents(bagParents, TARGET, new HashSet<>());

        System.out.println("There are " + parents.size() + " bags that could contain a " + TARGET + " bag.");
        System.out.println("Bags:");
        parents.stream()
            .map(s -> "\t" + s)
            .forEach(System.out::println);
    }

    private static Set<String> findAllParents(Map<String, Set<String>> bagParents, String root, Set<String> visitedNodes) {
        visitedNodes.add(root);
        Set<String> parents = new HashSet<>() {{addAll(bagParents.getOrDefault(root, Collections.emptySet()));}};
        for (String parent : Set.copyOf(parents)) {
            if(visitedNodes.contains(parent)) {
                System.out.println("Parent " + parent + " already in tree, skipping");
                continue;
            }
            parents.addAll(findAllParents(bagParents, parent, visitedNodes));
        }
        return parents;
    }

    public static Map<String, Set<String>> readLuggageRulesFromInput() throws IOException{
        Map<String, Set<String>> bagParents = new HashMap<>();
        List<String> ruleList = Files.readAllLines(Paths.get("input.txt"));
        for (String bagRule : ruleList) {
            Matcher bagMatcher = Pattern.compile("(?<amount>\\d+\\s)?(?<color>\\w+\\s\\w+)\\sbag").matcher(bagRule);
            String parent = null;
            while (bagMatcher.find()) {
                String color = bagMatcher.group("color");
                if (parent == null) {
                    parent = color;
                } else {
                    bagParents.computeIfAbsent(color, v -> new HashSet<>()).add(parent);
                }
            }
        }
        return bagParents;
    }
}
