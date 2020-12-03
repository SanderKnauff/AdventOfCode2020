package ooo.sansk.adventofcode2020.day3.challenge2;

public class Map {

    private final Tile[][] tiles;
    private final int width;
    private final int height;

    public Map(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles[0].length;
        this.height = tiles.length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int xCoordinate, int yCoordinate) {
        if(yCoordinate < 0 || yCoordinate >= height || xCoordinate < 0) {
            System.out.println("Asked for null tile at " + xCoordinate + ", " + yCoordinate);
            return null;
        }
        return tiles[yCoordinate][xCoordinate % width];
    }
}
