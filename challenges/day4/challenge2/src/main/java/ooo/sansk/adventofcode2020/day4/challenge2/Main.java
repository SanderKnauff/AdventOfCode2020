package ooo.sansk.adventofcode2020.day4.challenge2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        List<TravelCredential> credentials = parseCredentials();
        long count = credentials.stream().filter(TravelCredential::isValid).count();
        System.out.println("Of the " + credentials.size() + " passports, " + count + " were valid");
    }

    public static List<TravelCredential> parseCredentials() throws IOException {
        List<TravelCredential> credentials = new LinkedList<>();
        Scanner scanner = new Scanner(Paths.get("input.txt")).useDelimiter("\\r\\n\\r\\n");
        while (scanner.hasNext()) {
            Matcher keyValueMatcher = Pattern.compile("(?<key>\\w+):(?<value>[#\\w]+)").matcher(scanner.next());
            TravelCredentialBuilder travelCredentialBuilder = new TravelCredentialBuilder();
            while (keyValueMatcher.find()) {
                String key = keyValueMatcher.group("key");
                String value = keyValueMatcher.group("value");
                switch (key) {
                    case "byr":
                        travelCredentialBuilder.setBirthYear(Integer.valueOf(value));
                        break;
                    case "iyr":
                        travelCredentialBuilder.setIssueYear(Integer.valueOf(value));
                        break;
                    case "eyr":
                        travelCredentialBuilder.setExpirationYear(Integer.valueOf(value));
                        break;
                    case "hgt":
                        travelCredentialBuilder.setHeight(value);
                        break;
                    case "hcl":
                        travelCredentialBuilder.setHairColor(value);
                        break;
                    case "ecl":
                        travelCredentialBuilder.setEyeColor(value);
                        break;
                    case "pid":
                        travelCredentialBuilder.setPassportId(value);
                        break;
                }
            }
            credentials.add(travelCredentialBuilder.createTravelCredential());
        }
        return credentials;
    }
}
