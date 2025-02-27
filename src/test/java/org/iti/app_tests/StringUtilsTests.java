package org.iti.app_tests;

import org.iti.app.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTests {

    @ParameterizedTest
    @ValueSource(strings = {"level", "racecar", "maram", "madam", "abccba"})
    void testPalindromeStrings(String input) {
        StringUtils str = new StringUtils();
        assertNotNull(str);
        assertTrue(str.isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test", "Abc", "exit", "abcbad"})
    void testNoPalindromeStrings(String input) {
        StringUtils str = new StringUtils();
        assertFalse(str.isPalindrome(input));
    }
}
