package ooo.sansk.adventofcode2020.day11.challenge1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Tile[][] currentSeatingMap = createSeatingMapFromInput();
        int changes;
        do {
            RoundResults roundResults = doRound(currentSeatingMap);
            currentSeatingMap = roundResults.result;
            changes = roundResults.changes;
        } while (changes != 0);

        int occupiedSeats = 0;
        for (Tile[] tiles : currentSeatingMap) {
            for (Tile tile : tiles) {
                if(Tile.OCCUPIED_SEAT.equals(tile)) {
                    occupiedSeats++;
                }
                System.out.print(tile.getRepresentation());
            }
            System.out.println();
        }

        System.out.println("After everyone has settled down, there were " + occupiedSeats + " seats occupied");
    }

    public static RoundResults doRound(Tile[][] tileMap) {
        int changes = 0;
        Tile newTileMap[][] = new Tile[tileMap.length][tileMap[0].length];
        for (int row = 0; row < tileMap.length; row++) {
            for (int column = 0; column < tileMap[row].length; column++) {
                Tile tile = tileMap[row][column];
                int neighbours = getNeighbourCount(tileMap, row, column);
                if (Tile.EMPTY_SEAT.equals(tile) && neighbours == 0) {
                    newTileMap[row][column] = Tile.OCCUPIED_SEAT;
                    changes++;
                } else if (Tile.OCCUPIED_SEAT.equals(tile) && neighbours >= 4) {
                    newTileMap[row][column] = Tile.EMPTY_SEAT;
                    changes++;
                } else {
                    newTileMap[row][column] = tile;
                }
            }
        }
        return new RoundResults(changes, newTileMap);
    }

    private static int getNeighbourCount(Tile[][] tileMap, int row, int column) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if(j < 0 || i < 0 || i >= tileMap.length || j >= tileMap[0].length || (row == i && column == j)) {
                    continue;
                }
                if (Tile.OCCUPIED_SEAT.equals(tileMap[i][j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Tile[][] createSeatingMapFromInput() throws IOException {
        final List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        Tile[][] tiles = new Tile[lines.size()][];
        for (int row = 0; row < lines.size(); row++) {
            char[] chars = lines.get(row).toCharArray();
            tiles[row] = new Tile[chars.length];
            for (int column = 0; column < chars.length; column++) {
                tiles[row][column] = Tile.getTile(chars[column]);
            }
        }
        return tiles;
    }

    private static class RoundResults {
        public final int changes;
        public final Tile[][] result;

        public RoundResults(int changes, Tile[][] result) {
            this.changes = changes;
            this.result = result;
        }

    }
}
