package controller.loging.impl;

import controller.loging.Loggable;
import servise.ComplexCalculable;

public class LoggedComplexCalculator implements ComplexCalculable {
    private final ComplexCalculable calculable;
    private final Loggable logger;

    public LoggedComplexCalculator(ComplexCalculable calculable, Loggable logger) {
        this.calculable = calculable;
        this.logger = logger;
    }

    @Override
    public void sum(double a, double b, double c, double d) {
        logger.log(String.format("Sum up %s + i%s and %s + i%s", a, b, c, d));
        calculable.sum(a, b, c, d);
    }

    @Override
    public void multiply(double a, double b, double c, double d) {
        logger.log(String.format("Multiply %s + i%s and %s + i%s", a, b, c, d));
        calculable.multiply(a, b, c, d);
    }

    @Override
    public void divide(double a, double b, double c, double d) {
        logger.log(String.format("Divide %s + i%s and %s + i%s", a, b, c, d));
        calculable.divide(a, b, c, d);
    }

    @Override
    public void subtraction(double a, double b, double c, double d) {
        logger.log(String.format("Subtract  %s + i%s from %s + i%s", c, d, a, b));
        calculable.subtraction(a, b, c, d);
    }

    @Override
    public double result() {
        double result = calculable.result();
        double complexResult = calculable.complexResult();
        logger.log(String.format("Result: %s + i%s", result, complexResult));
        return result;
    }

    @Override
    public double complexResult() {
        double complexResult = calculable.complexResult();
        logger.log(String.format("complexResult: i%s", complexResult));
        return complexResult;
    }

    @Override
    public void clear() {
        calculable.clear();
    }
}