package ooo.sansk.adventofcode2020.day7.challenge2;

public class LuggageRule {

    private final Bag bag;
    private final int amount;

    public LuggageRule(Bag bag, int amount) {
        this.bag = bag;
        this.amount = amount;
    }

    public Bag getBag() {
        return bag;
    }

    public int getAmount() {
        return amount;
    }
}
