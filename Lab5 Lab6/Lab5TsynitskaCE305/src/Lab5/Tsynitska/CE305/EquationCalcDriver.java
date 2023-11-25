package Lab5.Tsynitska.CE305;
import java.util.Scanner;
/**
 * The EquationCalcDriver class provides a simple user interface for using the ExpressionCalculator and ResultFileManager classes.
 * It takes user input for the file name, X value, and the selection of the π checkbox, performs calculations, and writes the result to both text and binary files.
 */
public class EquationCalcDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Prompt user for file name
        System.out.print("Введіть ім'я файлу: ");
        String fName = in.nextLine();

        // Prompt user for X value
        System.out.print("Введіть X: ");
        int x = in.nextInt();

        // Prompt user for π checkbox selection
        System.out.print("Is π checkbox selected? (true/false): ");
        boolean piCheckBox = in.nextBoolean();

        try {
            // Calculate expression and display result
            double result = ExpressionCalculator.calculateExpression(x, piCheckBox);
            System.out.println("Результат: " + result);

            // Write results to both text and binary files
            ResultFileManager.writeTextResult(fName, x, result);
            ResultFileManager.writeBinaryResult(fName, x, result);
        } catch (ArithmeticException ex) {
            System.out.println("Division by zero: cos(4x) equals zero.");
        }
    }
}