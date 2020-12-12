package ooo.sansk.adventofcode2020.day12.challenge2;

public enum TurnDirection {

    LEFT('L', -1),
    RIGHT('R', 1);

    private final char abbreviation;
    private final int modifier;

    TurnDirection(char abbreviation, int modifier) {
        this.abbreviation = abbreviation;
        this.modifier = modifier;
    }

    public int getModifier() {
        return modifier;
    }

    public static TurnDirection getByAbbreviation(char abbreviation) {
        for (TurnDirection value : TurnDirection.values()) {
            if (value.abbreviation == abbreviation) {
                return value;
            }
        }
        throw new IllegalArgumentException("Abbreviation must be one of L, R");
    }
}
