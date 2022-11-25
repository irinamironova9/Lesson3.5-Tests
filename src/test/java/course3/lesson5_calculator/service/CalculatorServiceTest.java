package course3.lesson5_calculator.service;

import course3.lesson5_calculator.controller.CalculatorController;
import course3.lesson5_calculator.exceptions.CannotDivideByZeroException;
import course3.lesson5_calculator.exceptions.ValueIsMissingException;
import org.junit.jupiter.api.Test;

import static course3.lesson5_calculator.service.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorController out = new CalculatorController(new CalculatorService());

    @Test
    public void greet() {
        String actual = out.greet();
        assertEquals(GREET, actual);
    }

    @Test
    public void plus() {
        String actual = out.plus(NUM1, NUM2);
        assertEquals(PLUS, actual);
    }

    @Test
    public void minus() {
        String actual = out.minus(NUM1, NUM2);
        assertEquals(MINUS, actual);
    }

    @Test
    public void multiply() {
        String actual = out.multiply(NUM1, NUM2);
        assertEquals(MULTIPLY, actual);
    }

    @Test
    public void divide() {
        String actual = out.divide(NUM1, NUM2);
        assertEquals(DIVIDE, actual);
    }

    @Test
    public void shouldThrowValueIsMissingException() {
        assertThrows(ValueIsMissingException.class, () -> out.plus(null, NUM2));
    }

    @Test
    public void shouldThrowCannotDivideByZeroException() {
        assertThrows(CannotDivideByZeroException.class, () -> out.divide(NUM1, 0));
    }
}