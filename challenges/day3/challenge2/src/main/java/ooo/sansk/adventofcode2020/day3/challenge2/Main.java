package ooo.sansk.adventofcode2020.day3.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Map map = createMapFromLines(Files.readAllLines(Paths.get("input.txt")));
        long totalCount = walk(map, 0, 0, 1, 1, 0)
            * walk(map, 0, 0, 3, 1, 0)
            * walk(map, 0, 0, 5, 1, 0)
            * walk(map, 0, 0, 7, 1, 0)
            * walk(map, 0, 0, 1, 2, 0);
        System.out.println("The product of the trees found on each slope is " + totalCount);
    }

    public static long walk(Map map, int posX, int posY, int dX, int dY, long treeCount) {
        Tile tile = map.getTile(posX, posY);
        if(tile == null) {
            System.out.println("There were " + treeCount + " trees on the slope " + dX + ", " + dY);
            return treeCount;
        }
        if(Tile.TREE.equals(tile)) {
            treeCount++;
        }
//        printMap(map, posX, posY);
        return walk(map, posX + dX, posY + dY, dX, dY, treeCount);
    }

    private static void printMap(Map map, int posX, int posY) {
        for (int x = 0; x < map.getWidth() ; x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Tile tile = map.getTile(x, y);
                if (x == posX && y == posY) {
                    if (tile.equals(Tile.TREE)) {
                        System.out.print("H");
                    }
                    System.out.print("M");
                } else {
                    System.out.print(tile.getRepresentation());
                }
            }
            System.out.println();
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public static Map createMapFromLines(List<String> lines) {
        Tile[][] tiles = new Tile[lines.size()][];
        for (int row = 0; row < lines.size(); row++) {
            char[] chars = lines.get(row).toCharArray();
            tiles[row] = new Tile[chars.length];
            for (int column = 0; column < chars.length; column++) {
                tiles[row][column] = Tile.getTile(chars[column]);
            }
        }
        return new Map(tiles);
    }

}
