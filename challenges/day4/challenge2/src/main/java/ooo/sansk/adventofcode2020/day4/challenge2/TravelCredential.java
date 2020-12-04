package ooo.sansk.adventofcode2020.day4.challenge2;

import java.util.List;

public class TravelCredential {

    private final Integer birthYear;
    private final Integer issueYear;
    private final Integer expirationYear;
    private final Height height;
    private final String hairColor;
    private final String eyeColor;
    private final String passportId;

    public TravelCredential(Integer birthYear, Integer issueYear, Integer expirationYear, Height height, String hairColor, String eyeColor, String passportId) {
        this.birthYear = birthYear;
        this.issueYear = issueYear;
        this.expirationYear = expirationYear;
        this.height = height;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.passportId = passportId;
    }

    public boolean isValid() {
        return isBirthYearValid()
            && isIssueYearValid()
            && isExpirationYearValid()
            && isHeightValid()
            && isHairColorValid()
            && isEyeColorValid()
            && isPassportIdValid();
    }

    private boolean isBirthYearValid() {
        boolean valid = birthYear != null && birthYear >= 1920 && birthYear <= 2002;
        if (!valid) {
            System.out.println("birthYear " + birthYear + " was invalid");
        }
        return valid;
    }

    private boolean isIssueYearValid() {
        boolean valid = issueYear != null && issueYear >= 2010 && issueYear <= 2020;
        if (!valid) {
            System.out.println("issueYear " + issueYear + " was invalid");
        }
        return valid;
    }

    private boolean isExpirationYearValid() {
        boolean valid = expirationYear != null && expirationYear >= 2020 && expirationYear <= 2030;
        if (!valid) {
            System.out.println("expirationYear  " + expirationYear + " was invalid");
        }
        return valid;
    }

    private boolean isHeightValid() {
        boolean valid = height != null && height.isValid();
        if (!valid) {
            System.out.println("height " + height + " was invalid");
        }
        return valid;
    }

    private boolean isHairColorValid() {
        boolean valid = hairColor != null && hairColor.matches("#[\\da-z]{6}");
        if (!valid) {
            System.out.println("hairColor " + hairColor + " was invalid");
        }
        return valid;
    }

    private boolean isEyeColorValid() {
        boolean valid = eyeColor != null && List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(eyeColor);
        if (!valid) {
            System.out.println("eyeColor " + eyeColor + " was invalid");
        }
        return valid;
    }

    private boolean isPassportIdValid() {
        boolean valid = passportId != null && passportId.matches("\\d{9}");
        if (!valid) {
            System.out.println("passportId " + passportId + " was invalid");
        }
        return valid;

    }
}


