package ooo.sansk.adventofcode2020.day12.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Ship ship = new Ship(0, 0);
        Waypoint waypoint = new Waypoint( 10, 1);

        try (Stream<String> stream = Files.lines(Paths.get("input.txt"))) {
            stream.forEach(s -> {
                char key = s.charAt(0);
                int value = Integer.parseInt(s.substring(1));

                switch (key) {
                    case 'N':
                    case 'E':
                    case 'S':
                    case 'W':
                        waypoint.move(CardinalDirection.getByAbbreviation(key), value);
                        break;
                    case 'L':
                    case 'R':
                        waypoint.rotate(TurnDirection.getByAbbreviation(key), value);
                        break;
                    case 'F':
                        ship.moveToWaypoint(waypoint, value);
                        break;
                    default:
                        break;
                }
                System.out.printf("Ship position: (%d, %d), Waypoint position: (%d, %d)%n", ship.getPosX(), ship.getPosY(), waypoint.getPosX(), waypoint.getPosY());
            });
        }

        System.out.println("Sailed from (0, 0) to (" + ship.getPosX() + ", " + ship.getPosY() + "). The Manhattan distance between these two points is: " + (Math.abs(ship.getPosX()) + Math.abs(ship.getPosY())));
    }
}
