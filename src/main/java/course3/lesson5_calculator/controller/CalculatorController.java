package course3.lesson5_calculator.controller;

import course3.lesson5_calculator.exceptions.CannotDivideByZeroException;
import course3.lesson5_calculator.exceptions.ValueIsMissingException;
import course3.lesson5_calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String greet() {
        return service.greet();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return service.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return service.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return service.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return service.divide(num1, num2);
    }

    @ExceptionHandler(value = ValueIsMissingException.class)
    public ResponseEntity<String> ValueIsMissingExceptionHandler(ValueIsMissingException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = CannotDivideByZeroException.class)
    public ResponseEntity<String> CannotDivideByZeroExceptionHandler(CannotDivideByZeroException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
