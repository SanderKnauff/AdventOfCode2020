package ooo.sansk.adventofcode2020.day11.challenge2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void shouldDetectOne() {
        String map = """
            .......
            .......
            .......
            ......#
            .......
            .......
            .......
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(1, Main.getVisibleOccupiedSeats(testMap, 3, 3));
    }

    @Test
    public void emptySeatCanObscureVision() {
        String map = """
            .......
            .......
            .......
            ....L.#
            .......
            .......
            .......
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(0, Main.getVisibleOccupiedSeats(testMap, 3, 3));
    }

    @Test
    public void shouldDetectAtEdges() {
        String map = """
            #..#..#
            .......
            .......
            #.....#
            .......
            .......
            #..#..#
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(8, Main.getVisibleOccupiedSeats(testMap, 3, 3));
    }

    @Test
    public void shouldNotDetectAtEdgesWhenBlocked() {
        String map = """
            #..#..#
            .L.L.L.
            .......
            #L...L#
            .......
            .L.L.L.
            #..#..#
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(0, Main.getVisibleOccupiedSeats(testMap, 3, 3));
    }

    @Test
    public void shouldNotLookThroughDetected() {
        String map = """
            #..#..#
            .......
            ..###..
            #.#.#.#
            ..###..
            .......
            #..#..#
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(8, Main.getVisibleOccupiedSeats(testMap, 3, 3));
    }

    @Test
    public void withAfullSquare_shouldOnlySeeAroundMiddle() {
        String map = """
            #######
            #######
            #######
            #######
            #######
            #######
            #######
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(8, Main.getVisibleOccupiedSeats(testMap, 3, 3));
    }


    @Test
    public void worksOnEdge_hehe_Cases() {
        String map = """
            .#.....
            ##.....
            .......
            .......
            .......
            .......
            .......
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(3, Main.getVisibleOccupiedSeats(testMap, 0, 0));
    }

    @Test
    public void goesBeyondThreeSeats() {
        String map = """
            #...#...#
            .........
            .........
            .........
            #.......#
            .........
            .........
            .........
            #...#...#
            """;
        Tile[][] testMap = Main.createSeatingMapFromInput(Arrays.asList(map.split("\\r?\\n")));
        assertEquals(8, Main.getVisibleOccupiedSeats(testMap, 4, 4));
    }

}