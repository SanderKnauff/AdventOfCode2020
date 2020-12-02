package ooo.sansk.adventofcode2020.day2.challenge1;

public class PoliciedPassword {

    private final int minOccurences;
    private final int maxOccurences;
    private final char character;
    private final String actualPassword;

    public PoliciedPassword(int minOccurences, int maxOccurences, char character, String actualPassword) {
        this.minOccurences = minOccurences;
        this.maxOccurences = maxOccurences;
        this.character = character;
        this.actualPassword = actualPassword;
    }

    public boolean isValid() {

    }
}
