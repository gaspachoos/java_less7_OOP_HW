package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import servise.ComplexCalculable;
import util.Operators;


public class View {
    private final ComplexCalculable calculator;
    private final List<String> validOperators;

    public View(ComplexCalculable calculator) {
        this.calculator = calculator;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
    }

    public void run() {
        while (true) {
            prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void prepare() {
        double a = promptInt("Enter first argument: ");
        double b = promptInt("Enter first complex argument: ");
        String operator = getOperator();
        double c = promptInt("Enter second argument: ");
        double d = promptInt("Enter second complex argument: ");

        if (operator.equals("*")) {
            calculator.multiply(a, b, c, d);
        }

        if (operator.equals("+")) {
            calculator.sum(a, b, c, d);
        }

        if (operator.equals("/")) {
            calculator.divide(a, b, c, d);
        }

        if (operator.equals("-")) {
            calculator.subtraction(a, b, c, d);
        }

        calculator.result();
        calculator.clear();
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Entered invalid math operator. " + "Enter the math operation (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        int result = -1;
        try {
            result = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Not number was enter. Please enter number");
            promptInt(message);
        }
        return result;
    }

}