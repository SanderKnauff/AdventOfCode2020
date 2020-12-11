package ooo.sansk.adventofcode2020.day11.challenge1;

public enum Tile {
    FLOOR('.'),
    EMPTY_SEAT('L'),
    OCCUPIED_SEAT('#');

    private final char representation;

    Tile(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }

    public static Tile getTile(char representation) {
        for (Tile tile : Tile.values()) {
            if (representation == tile.representation) {
                return tile;
            }
        }
        return null;
    }
}
