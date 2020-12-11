package ooo.sansk.adventofcode2020.day11.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Tile[][] currentSeatingMap = createSeatingMapFromInput(Files.readAllLines(Paths.get("input.txt")));
        int changes;
        do {
            RoundResults roundResults = doRound(currentSeatingMap);
            currentSeatingMap = roundResults.result;
            changes = roundResults.changes;
//            System.out.println(changes);
        } while (changes != 0);

        int occupiedSeats = 0;
        for (Tile[] tiles : currentSeatingMap) {
            for (Tile tile : tiles) {
                if(Tile.OCCUPIED_SEAT.equals(tile)) {
                    occupiedSeats++;
                }
            }
        }

        printMap(currentSeatingMap);
        System.out.println("After everyone has settled down, there were " + occupiedSeats + " seats occupied");
    }

    public static RoundResults doRound(Tile[][] tileMap) {
        int changes = 0;
        Tile[][] newTileMap = new Tile[tileMap.length][tileMap[0].length];
        for (int row = 0; row < tileMap.length; row++) {
            for (int column = 0; column < tileMap[row].length; column++) {
                Tile tile = tileMap[row][column];
                int visibleOccupiedSeats = getVisibleOccupiedSeats(tileMap, row, column);
                if (Tile.EMPTY_SEAT.equals(tile) && visibleOccupiedSeats == 0) {
                    newTileMap[row][column] = Tile.OCCUPIED_SEAT;
                    changes++;
                } else if (Tile.OCCUPIED_SEAT.equals(tile) && visibleOccupiedSeats >= 5) {
                    newTileMap[row][column] = Tile.EMPTY_SEAT;
                    changes++;
                } else {
                    newTileMap[row][column] = tile;
                }
            }
        }
        return new RoundResults(changes, newTileMap);
    }

    public static int getVisibleOccupiedSeats(Tile[][] tileMap, int row, int column) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dy == 0 && dx == 0) {
                    continue;
                }
                int range = 1;
                while (true) {
                    int targetRow = (dx * range) + row;
                    int targetColumn = (dy * range) + column;
                    if(targetColumn < 0 || targetRow < 0 || targetRow >= tileMap.length || targetColumn >= tileMap[0].length) {
                        break;
                    }
                    Tile tile = tileMap[targetRow][targetColumn];
                    if(Tile.OCCUPIED_SEAT.equals(tile)) {
                        count++;
                        break;
                    } else if (Tile.EMPTY_SEAT.equals(tile)) {
                        break;
                    }
                    range++;
                }
            }
        }
        return count;
    }

    public static Tile[][] createSeatingMapFromInput(List<String> lines) {
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

    public static void printMap(Tile[][] tilemap) {
        for (int x = 0; x < tilemap.length ; x++) {
            for (int y = 0; y < tilemap[0].length; y++) {
                Tile tile = tilemap[x][y];
                System.out.print(tile.getRepresentation());
            }
            System.out.println();
        }
    }
}
