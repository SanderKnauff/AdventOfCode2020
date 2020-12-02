package ooo.sansk.adventofcode2020.day2.challenge1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordEntry {

    public final int minOccurences;
    public final int maxOccurences;
    public final char character;
    public final String actualPassword;

    public PasswordEntry(int minOccurences, int maxOccurences, char character, String actualPassword) {
        this.minOccurences = minOccurences;
        this.maxOccurences = maxOccurences;
        this.character = character;
        this.actualPassword = actualPassword;
    }

    public boolean isValid() {
        Matcher matcher = Pattern.compile(character + "").matcher(actualPassword);
        int count = 0;
        while(matcher.find()) {
            count++;
        }
        return count >= minOccurences && count <= maxOccurences;
    }

    public static PasswordEntry createEntryFromString(String serializedEntry) {
        Matcher matcher = Pattern.compile("(?<min>\\d+)-(?<max>\\d+)\s(?<character>\\w):\\s(?<actualPassword>\\w+)").matcher(serializedEntry);
        if (matcher.find()) {
            return new PasswordEntry(
                Integer.parseInt(matcher.group("min")),
                Integer.parseInt(matcher.group("max")),
                matcher.group("character").charAt(0),
                matcher.group("actualPassword")
            );
        }
        System.err.println("'" + serializedEntry + "' did not contain a valid password entry");
        return null;
    }
}
