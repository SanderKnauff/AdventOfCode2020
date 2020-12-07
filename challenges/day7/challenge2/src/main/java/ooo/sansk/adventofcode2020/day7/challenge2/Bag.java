package ooo.sansk.adventofcode2020.day7.challenge2;

import java.util.LinkedList;
import java.util.List;

public class Bag {

    private final String color;
    private final List<LuggageRule> rules = new LinkedList<>();

    public Bag(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public List<LuggageRule> getRules() {
        return rules;
    }

    public void addRule(LuggageRule luggageRule) {
        rules.add(luggageRule);
    }
}
