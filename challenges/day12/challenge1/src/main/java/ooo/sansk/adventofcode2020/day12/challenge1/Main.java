package ooo.sansk.adventofcode2020.day12.challenge1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Ship ship = new Ship(CardinalDirection.EAST, 0, 0);

        try (Stream<String> stream = Files.lines(Paths.get("input.txt"))) {
            stream.forEach(s -> {
                char key = s.charAt(0);
                int value = Integer.parseInt(s.substring(1));

                switch (key) {
                    case 'N':
                    case 'E':
                    case 'S':
                    case 'W':
                        ship.move(CardinalDirection.getByAbbreviation(key), value);
                        break;
                    case 'L':
                    case 'R':
                        ship.turn(TurnDirection.getByAbbreviation(key), value);
                        break;
                    case 'F':
                        ship.moveForward(value);
                        break;
                    default:
                        break;
                }
            });
        }

        System.out.println("Sailed from (0, 0) to (" + ship.getPosX() + ", " + ship.getPosY() + "). The Manhattan distance between these two points is: " + (Math.abs(ship.getPosX()) + Math.abs(ship.getPosY())));
    }
}
