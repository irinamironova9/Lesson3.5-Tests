package course3.lesson5_calculator.service;

import course3.lesson5_calculator.exceptions.CannotDivideByZeroException;
import course3.lesson5_calculator.exceptions.ValueIsMissingException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String greet() {
        return "Добро пожаловать в калькулятор!";
    }

    public String plus(Integer num1, Integer num2) {
        validateValues(num1, num2);
        return String.format("%s + %s = %s", num1, num2, (num1 + num2));
    }

    public String minus(Integer num1, Integer num2) {
        validateValues(num1, num2);
        return String.format("%s - %s = %s", num1, num2, (num1 - num2));
    }

   public String multiply(Integer num1, Integer num2) {
       validateValues(num1, num2);
       return String.format("%s * %s = %s", num1, num2, (num1 * num2));
    }

    public String divide(Integer num1, Integer num2) {
        validateValues(num1, num2);
        if (num2 == 0) {
            throw new CannotDivideByZeroException("На ноль делить нельзя!");
        }
        return String.format("%s / %s = %s", num1, num2, (num1 / num2));
    }

    private static void validateValues(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new ValueIsMissingException("Не введены одно или оба числа!");
        }
    }
}
