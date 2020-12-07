package ooo.sansk.adventofcode2020.day7.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String TARGET = "shiny gold";

    public static void main(String[] args) throws IOException {
        Map<String, Bag> bagParents = readLuggageRulesFromInput();

        long bagTotal = calculateBagTotal(bagParents.get(TARGET)) - 1;

        System.out.println("To comply to the aviation regulations, you need a total of " + bagTotal + " bags inside your " + TARGET + " bag");
    }

    private static long calculateBagTotal(Bag parent) {
        long total = 1;
        for (LuggageRule rule : parent.getRules()) {
            total += rule.getAmount() * calculateBagTotal(rule.getBag());
        }
        return total;
    }

    public static Map<String, Bag> readLuggageRulesFromInput() throws IOException {
        Map<String, Bag> bags = new HashMap<>();
        List<String> ruleList = Files.readAllLines(Paths.get("input.txt"));
        for (String bagRule : ruleList) {
            Matcher bagMatcher = Pattern.compile("(?<amount>\\d+)?\\s?(?<color>\\w+\\s\\w+)\\sbag").matcher(bagRule);
            Bag parent = null;
            while (bagMatcher.find()) {
                String color = bagMatcher.group("color");
                if (parent == null) {
                    parent = bags.computeIfAbsent(color, key -> new Bag(color));
                } else {
                    if (color.equals("no other")) {
                        continue;
                    }
                    String amount = bagMatcher.group("amount");
                    try {
                        parent.addRule(new LuggageRule(bags.computeIfAbsent(color, key -> new Bag(color)), Integer.parseInt(amount)));
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException while trying to parse '" + amount + "' with the color '" + color + "' in String: '" + bagRule + "'");
                    }
                }
            }
        }
        return bags;
    }
}
