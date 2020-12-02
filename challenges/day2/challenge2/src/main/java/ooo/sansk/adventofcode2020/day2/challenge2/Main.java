package ooo.sansk.adventofcode2020.day2.challenge2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        long validCount = Files.readAllLines(Paths.get("input.txt")).stream()
            .map(PasswordEntry::createEntryFromString)
            .filter(Objects::nonNull)
            .filter(PasswordEntry::isValid)
            .count();
        System.out.println("There were " + validCount + " valid passwords in the database");
    }

}
