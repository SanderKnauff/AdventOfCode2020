package ooo.sansk.adventofcode2020.day4.challenge1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> credentials = readCredentials();
        long count = credentials.stream().filter(Main::isCredentialValid).count();
        System.out.println("Of the " + credentials.size() + " passports, " + count + " were valid");
    }

    public static List<String> readCredentials() throws IOException {
        List<String> credentials = new ArrayList<>();
        StringBuilder currentCredential = new StringBuilder();
        Scanner scanner = new Scanner(Paths.get("input.txt"));
        while (scanner.hasNextLine()) {
            String credential = scanner.nextLine();
            if(credential.isBlank()) {
                credentials.add(currentCredential.toString().trim());
                currentCredential = new StringBuilder();
            } else {
                currentCredential.append(credential).append(" ");
            }
        }
        credentials.add(currentCredential.toString());
        return credentials;
    }

    public static boolean isCredentialValid(String credential) {
        List<String> requiredFields = List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        return requiredFields.stream().allMatch(credential::contains);
    }


}
