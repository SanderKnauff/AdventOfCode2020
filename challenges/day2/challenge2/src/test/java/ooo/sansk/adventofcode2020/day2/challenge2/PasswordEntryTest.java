package ooo.sansk.adventofcode2020.day2.challenge2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEntryTest {

    @Test
    public void testPasswordEntry_createEntryFromString() {
        PasswordEntry testEntry = PasswordEntry.createEntryFromString("1-2 x: xpxc");
        assertEquals(1, testEntry.firstPossiblePosition);
        assertEquals(2, testEntry.secondPossiblePosition);
        assertEquals( 'x', testEntry.character);
        assertEquals("xpxc", testEntry.actualPassword);
    }

    @Test
    public void testPasswordEntry_isValid() {
        PasswordEntry validEntry_firstPosition = PasswordEntry.createEntryFromString("1-2 x: xpxc");
        PasswordEntry validEntry_secondPosition = PasswordEntry.createEntryFromString("1-2 x: axxc");
        PasswordEntry invalidEntry_bothMatch = PasswordEntry.createEntryFromString("1-3 x: xpxc");
        PasswordEntry invalidEntry_noMatch = PasswordEntry.createEntryFromString("1-3 x: axac");
        assertTrue(validEntry_firstPosition.isValid());
        assertTrue(validEntry_secondPosition.isValid());
        assertFalse(invalidEntry_bothMatch.isValid());
        assertFalse(invalidEntry_noMatch.isValid());

    }

}
