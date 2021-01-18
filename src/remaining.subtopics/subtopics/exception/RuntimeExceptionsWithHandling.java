package remaining.subtopics.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RuntimeExceptionsWithHandling {
    public static int quotient(int numerator, int denominator) {
        return numerator / denominator; // possible division by zero
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner for input

        System.out.print("Please enter an integer numerator: ");
        int numerator = scanner.nextInt();
        System.out.print("Please enter an integer denominator: ");
        int denominator = scanner.nextInt();
        try {
            int result = quotient(numerator, denominator);
            System.out.printf(
                    "\nResult: %d / %d = %d\n", numerator, denominator, result);
        } catch (InputMismatchException ex) {


        } catch (ArithmeticException ex) {
            System.out.println(ex.toString());
            System.out.println("Zero is an invalid denominator. Please try again.\n");


        }

    }
}
