package org.iti.app_tests;

import org.iti.app.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTests {
    private static Calculator calc;

    @BeforeEach
    void beforeEachTestCase() {
        System.out.println("Before each test method");
    }

    @AfterEach
    void afterEachTestCase() {
        System.out.println("After each test method");
    }

    @BeforeAll
    static void beforeAllTests() {
        calc = new Calculator();  // 1
        System.out.println("Before all test methods");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("After all test methods");
    }

    @ParameterizedTest
    @DisplayName("Feature-123 Addition Functionality")
    @Tag("FEB-RELEASE")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testAddition(String input1, String input2, String sum) {
        System.out.println("Addition TestCase");
        assertEquals(Double.parseDouble(sum), calc.add(Double.parseDouble(input1), Double.parseDouble(input2)));
    }

    @ParameterizedTest
    @DisplayName("Feature-123 Subtraction Functionality")
    @MethodSource(value = "provideTestDataForSubtraction")
    void testSubtraction(double in1, double in2, double result) {
        assertEquals(result, calc.sub(in1, in2));
        System.out.println("Subtraction TestCase");

    }

    @Test
    @DisplayName("Feature-123 Multiplication Functionality")
    void testMultiplication() {
        System.out.println("Multiplication TestCase");
        // Arrange

        //Act , Asserts
        assertEquals(1000000, calc.mul(2000, 500), "Multiplication is not correct");
        assertEquals(1000000, calc.mul(-20, -50000));
        assertEquals(0, calc.mul(0, -50000));
        assertEquals(0, calc.mul(-2000, 0));
    }

    @Test
    @DisplayName("Feature-123 Division Functionality")
    @Tag("FEB-RELEASE")
    void testDivision() {

        System.out.println("Division TestCase");
        // Arrange

        //Act , Asserts
        assertEquals(4, calc.div(2000, 500), "Division is not correct");
        assertEquals(4, calc.div(-2000, -500));
        assertEquals(-100, calc.div(-1000, 10));
        assertEquals(0, calc.div(0, -50000));


        Exception ex = assertThrowsExactly(IllegalArgumentException.class, () -> calc.div(5, 0));
        assertEquals("Dividing by Zero!", ex.getMessage(), "Errors messages are not the same");
    }

    @Test
    @DisplayName("Feature-123 Square Root Functionality")
    @Tag("FEB-RELEASE")
    void testSquareRoot() {

        System.out.println("Square Root TestCase");
        // Arrange

        //Act , Asserts
        assertEquals(10, calc.getSquareRoot(100), "Square Root is not correct");
        assertEquals(13, calc.getSquareRoot(169));
        assertEquals(0, calc.getSquareRoot(0));

    }

    @Test
    @DisplayName("Feature-123 Absolute Values Functionality")
    void testAbsoluteValues() {

        System.out.println("bsolute Values TestCase");
        // Arrange

        //Act , Asserts
        assertEquals(100, calc.abs(-100), "Absolute Values is not correct");
        assertEquals(169, calc.abs(169));
        assertEquals(0, calc.abs(0));

    }

    @ParameterizedTest
    @MethodSource(value = "provideTestData")
    void testPositiveNumbers(double value, boolean status) {
        System.out.println("Positive Numbers Test Case");
        assertEquals(status, calc.isPositive(value));
    }




    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(-1, false),
                Arguments.of(-19.50, false),
                Arguments.of(19.50, true)
        );
    }

    static Stream<Arguments> provideTestDataForSubtraction() {
        return Stream.of(
                Arguments.of(2000, 500, 1500),
                Arguments.of(-2000, -50000, 48000),
                Arguments.of(0, -50000, 50000),
                Arguments.of(-2000, 0, -2000)
        );
    }



}
