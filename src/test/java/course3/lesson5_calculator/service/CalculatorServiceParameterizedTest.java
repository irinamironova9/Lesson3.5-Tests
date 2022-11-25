package course3.lesson5_calculator.service;

import course3.lesson5_calculator.controller.CalculatorController;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static course3.lesson5_calculator.service.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceParameterizedTest {

    CalculatorController out = new CalculatorController(new CalculatorService());

    @ParameterizedTest
    @MethodSource("provideParamsForPlus")
    public void plus(int num1, int num2, String result) {
        String actual = out.plus(num1, num2);
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinus")
    public void minus(int num1, int num2, String result) {
        String actual = out.minus(num1, num2);
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiply")
    public void multiply(int num1, int num2, String result) {
        String actual = out.multiply(num1, num2);
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivide")
    public void divide(int num1, int num2, String result) {
        String actual = out.divide(num1, num2);
        assertEquals(result, actual);
    }

    public static Stream<Arguments> provideParamsForPlus() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, PLUS),
                Arguments.of(0, 3, "0 + 3 = 3"),
                Arguments.of(4, 7, "4 + 7 = 11"),
                Arguments.of(-3, 7, "-3 + 7 = 4")
        );
    }

    public static Stream<Arguments> provideParamsForMinus() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, MINUS),
                Arguments.of(0, 3, "0 - 3 = -3"),
                Arguments.of(4, 7, "4 - 7 = -3"),
                Arguments.of(46, 27, "46 - 27 = 19")
        );
    }

    public static Stream<Arguments> provideParamsForMultiply() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, MULTIPLY),
                Arguments.of(0, 3, "0 * 3 = 0"),
                Arguments.of(4, 7, "4 * 7 = 28"),
                Arguments.of(-3, 7, "-3 * 7 = -21")
        );
    }

    public static Stream<Arguments> provideParamsForDivide() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, DIVIDE),
                Arguments.of(0, 3, "0 / 3 = 0"),
                Arguments.of(40, 8, "40 / 8 = 5"),
                Arguments.of(-10, -2, "-10 / -2 = 5")
        );
    }
}