package ooo.sansk.adventofcode2020.day2.challenge2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordEntry {

    public final int firstPossiblePosition;
    public final int secondPossiblePosition;
    public final char character;
    public final String actualPassword;

    public PasswordEntry(int firstPossiblePosition, int secondPossiblePosition, char character, String actualPassword) {
        this.firstPossiblePosition = firstPossiblePosition;
        this.secondPossiblePosition = secondPossiblePosition;
        this.character = character;
        this.actualPassword = actualPassword;
    }

    public boolean isValid() {
        boolean firstMatches = firstPossiblePosition <= actualPassword.length() && actualPassword.charAt(firstPossiblePosition - 1) == character;
        boolean secondMatches = secondPossiblePosition <= actualPassword.length() && actualPassword.charAt(secondPossiblePosition - 1) == character;
        return firstMatches ^ secondMatches;
    }

    public static PasswordEntry createEntryFromString(String serializedEntry) {
        Matcher matcher = Pattern.compile("(?<firstPossiblePosition>\\d+)-(?<secondPossiblePosition>\\d+)\s(?<character>\\w):\\s(?<actualPassword>\\w+)").matcher(serializedEntry);
        if (matcher.find()) {
            return new PasswordEntry(
                Integer.parseInt(matcher.group("firstPossiblePosition")),
                Integer.parseInt(matcher.group("secondPossiblePosition")),
                matcher.group("character").charAt(0),
                matcher.group("actualPassword")
            );
        }
        System.err.println("'" + serializedEntry + "' did not contain a valid password entry");
        return null;
    }
}
