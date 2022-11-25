package course3.lesson5_calculator.exceptions;

public class CannotDivideByZeroException extends IllegalArgumentException {

    public CannotDivideByZeroException() {
    }

    public CannotDivideByZeroException(String s) {
        super(s);
    }
}
