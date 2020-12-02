package ooo.sansk.adventofcode2020.day2.challenge1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEntryTest {

    @Test
    public void testPasswordEntry_createEntryFromString() {
        PasswordEntry testEntry = PasswordEntry.createEntryFromString("1-2 x: xpxc");
        assertEquals(1, testEntry.minOccurences);
        assertEquals(2, testEntry.maxOccurences);
        assertEquals( 'x', testEntry.character);
        assertEquals("xpxc", testEntry.actualPassword);
    }

    @Test
    public void testPasswordEntry_isValid() {
        PasswordEntry validEntry = PasswordEntry.createEntryFromString("1-2 x: xpxc");
        PasswordEntry invalidEntry = PasswordEntry.createEntryFromString("1-2 x: xpxcx");
        assertTrue(validEntry.isValid());
        assertFalse(invalidEntry.isValid());

    }

}
