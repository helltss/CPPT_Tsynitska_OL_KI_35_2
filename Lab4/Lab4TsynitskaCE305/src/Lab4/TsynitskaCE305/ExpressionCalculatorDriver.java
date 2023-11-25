import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import static java.lang.System.out;

/**
 * The ExpressionCalculatorDriver class provides a simple user interface for using the ExpressionCalculator class.
 * It takes user input for the file name, X value, and the selection of the π checkbox, performs calculations, and writes the result to a file.
 */
public class ExpressionCalculatorDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Prompt user for file name
        out.print("Введіть ім'я файлу: ");
        String fName = in.nextLine();

        // Prompt user for X value
        out.print("Введіть X: ");
        double x = in.nextInt();

        // Prompt user for π checkbox selection
        out.print("Is π checkbox selected? (true/false): ");
        boolean piCheckBox = in.nextBoolean();

        PrintWriter fout = null;
        try {
            fout = new PrintWriter(new FileWriter(fName + ".txt"));

            // Write input values to file
            fout.println("Введене значення X: " + x);
            fout.println("Is π checkbox selected? " + piCheckBox);

            // Calculate and write result to file and console
            double result = ExpressionCalculator.calculateExpression(x, piCheckBox);
            fout.println("Результат: " + result);
            out.println("Результат: " + result);
        } catch (IOException ex) {
            out.println("Error writing to file: " + ex.getMessage());
        } catch (ArithmeticException ex) {
            out.println("Division by zero: cos(4x) equals zero.");
        } finally {
            // Close the PrintWriter
            if (fout != null) {
                fout.close();
            }
        }
    }
}
