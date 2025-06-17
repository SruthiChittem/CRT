import java.util.Scanner;
public class ASCIICalculator {
    public static double convertToNumeric(String input) {
        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
            return (double) input.charAt(0);
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char operator;
        while (true) {
            System.out.println("+ -- Addition");
            System.out.println("- -- Subtraction");
            System.out.println("* -- Multiplication");
            System.out.println("/ -- Division");
            System.out.println("Enter operator: ");
            String opInput = scanner.next();
            if (opInput.length() == 1 && "+-*/".indexOf(opInput.charAt(0)) != -1) {
                operator = opInput.charAt(0);
                break;
            } else {
                System.out.println("Invalid operator. Please enter one of +, -, *, /.");
            }
        }
        String input1;
        double operand1;
        while (true) {
            System.out.print("Enter first operand (number or single letter): ");
            input1 = scanner.next();
            try {
                operand1 = convertToNumeric(input1);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a single letter or a valid number.");
            }
        }
        String input2;
        double operand2 = 0;
        int zeroCount = 0;
        while (true) {
            System.out.print("Enter second operand (number or single letter): ");
            input2 = scanner.next();
            if (input2.equalsIgnoreCase("exit")) {
                System.out.println("User terminated the program.");
                scanner.close();
                return;
            }
            try {
                operand2 = convertToNumeric(input2);
                if (operator == '/' && Math.abs(operand2) < 1e-10) {
                    zeroCount++;
                    if (zeroCount == 2) {
                        System.out.println("Zero entered twice consecutively. Terminating program.");
                        scanner.close();
                        return;
                    }
                    System.out.println("Denominator cannot be zero. Type another operand or 'exit' to quit.");
                } else {
                    break; 
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a single letter or a valid number (or 'exit' to quit).");
            }
        }
        double result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        System.out.println("Result: " + result);
        if (result == (int) result && result >= 32 && result <= 126) {
            System.out.println("Result (ASCII char): " + (char) ((int) result));
        }
        scanner.close();
    }
}