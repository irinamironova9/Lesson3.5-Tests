package course3.lesson5_calculator.exceptions;

public class ValueIsMissingException extends IllegalArgumentException {

    public ValueIsMissingException() {
    }

    public ValueIsMissingException(String s) {
        super(s);
    }
}
