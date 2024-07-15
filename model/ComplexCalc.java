package model;

import servise.ComplexCalculable;

public class ComplexCalc implements ComplexCalculable {
    private double result;
    private double complexResult;
    public ComplexCalc() {
        this.result = 0;
        this.complexResult = 0;
    }

    @Override
    public void clear() {
        this.result = 0;
        this.complexResult = 0;

    }

    @Override
    public void divide(double a, double b, double c, double d) {
        try {
            double tempResult = ((a*c)+(b*d)) / ((c*c)+(d*d));
            double tempComplexResult = ((b*c)-(a*d)) / ((c*c)+(d*d));
            result+= tempResult;
            complexResult+=tempComplexResult;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divide by zero exception");
        }

    }

    @Override
    public void multiply(double a, double b, double c, double d) {
        double tempResult = (a * c) - (b * d);
        result+= tempResult;
        double tempComplexResult = (b * c) + (a * d);
        complexResult+= tempComplexResult;

    }

    @Override
    public double result() {
        return result;
    }

    @Override
    public double complexResult() {
        return complexResult;
    }

    @Override
    public void subtraction(double a, double b, double c, double d) {
        double tempResult = a - c;
        result+= tempResult;
        double tempComplexResult = b - d;
        complexResult+= tempComplexResult;

    }

    @Override
    public void sum(double a, double b, double c, double d) {
        double tempResult = a + c;
        result+= tempResult;
        double tempComplexResult = b + d;
        complexResult+= tempComplexResult;

    }



}