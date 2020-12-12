package ooo.sansk.adventofcode2020.day12.challenge2;

public enum CardinalDirection {

    NORTH('N', 0, 0, 1),
    EAST('E', 90, 1, 0),
    SOUTH('S', 180, 0, -1),
    WEST('W', 270, -1, 0);

    private final char abbreviation;
    private final int degrees;
    private final int xModifier;
    private final int yModifier;

    CardinalDirection(char abbreviation, int degrees, int xModifier, int yModifier) {
        this.abbreviation = abbreviation;
        this.degrees = degrees;
        this.xModifier = xModifier;
        this.yModifier = yModifier;
    }

    public int getDegrees() {
        return degrees;
    }

    public int getXModifier() {
        return xModifier;
    }

    public int getYModifier() {
        return yModifier;
    }

    public static CardinalDirection getByAbbreviation(char abbreviation) {
        for (CardinalDirection value : CardinalDirection.values()) {
            if (value.abbreviation == abbreviation) {
                return value;
            }
        }
        throw new IllegalArgumentException("Abbreviation must be one of N, E, S, W");
    }

    public static CardinalDirection getByFacing(int degrees) {
        for (CardinalDirection value : CardinalDirection.values()) {
            if (value.degrees == Math.abs((degrees + 360) % 360)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Degrees " + degrees + " is invalid. Must be a multiple of 90");
    }

    @Override
    public String toString() {
        return "CardinalDirection{" +
            "abbreviation=" + abbreviation +
            ", degrees=" + degrees +
            ", xModifier=" + xModifier +
            ", yModifier=" + yModifier +
            '}';
    }
}
