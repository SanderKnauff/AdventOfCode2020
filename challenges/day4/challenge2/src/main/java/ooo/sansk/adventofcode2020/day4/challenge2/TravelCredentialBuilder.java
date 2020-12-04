package ooo.sansk.adventofcode2020.day4.challenge2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TravelCredentialBuilder {
    private Integer birthYear;
    private Integer issueYear;
    private Integer expirationYear;
    private Height height;
    private String hairColor;
    private String eyeColor;
    private String passportId;

    public TravelCredentialBuilder setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public TravelCredentialBuilder setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
        return this;
    }

    public TravelCredentialBuilder setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
        return this;
    }

    public TravelCredentialBuilder setHeight(String height) {
        Matcher matcher = Pattern.compile("(?<height>\\d+)(?<unit>\\w+)").matcher(height);
        if (matcher.find()) {
            int heightNumber = Integer.parseInt(matcher.group("height"));
            this.height = switch (matcher.group("unit")) {
                case "cm" -> new MetricHeight(heightNumber);
                case "in" -> new ImperialHeight(heightNumber);
                default -> null;
            };
        }
        return this;
    }

    public TravelCredentialBuilder setHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public TravelCredentialBuilder setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    public TravelCredentialBuilder setPassportId(String passportId) {
        this.passportId = passportId;
        return this;
    }

    public TravelCredential createTravelCredential() {
        return new TravelCredential(birthYear, issueYear, expirationYear, height, hairColor, eyeColor, passportId);
    }
}
