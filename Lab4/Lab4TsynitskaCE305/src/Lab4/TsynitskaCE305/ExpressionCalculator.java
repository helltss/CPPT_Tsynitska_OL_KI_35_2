/**
 * The ExpressionCalculator class performs calculations based on a given mathematical expression.
 * It includes a method to calculate the expression for a given value of x and a method to write the result to a file.
 */
package Lab4.TsynitskaCE305;

import java.io.*;

/**
 * The ExpressionCalculator class provides methods for calculating a mathematical expression with an option for using π and writing the result to a file.
 */
class ExpressionCalculator {
    // Static variable to store the file name
    private static String fileName;

    /**
     * Calculates the value of a mathematical expression for a given input value x.
     *
     * @param x          The input value for the expression.
     * @param piCheckBox A boolean indicating whether to consider π in the calculation.
     * @return The result of the expression calculation.
     * @throws ArithmeticException if the result is infinite or NaN.
     */
    public static double calculateExpression(double x, boolean piCheckBox) {
        // Calculate the expression result with an option to use π
        double result = 1 / ((piCheckBox && ((Math.abs(4 * x) == 0.5)||(((4 * x - 0.5) % 1) == 0))) ? 0 : Math.cos(4 * x));

        // Check for infinity or NaN and write result to file
        if (Double.isInfinite(result)|| Double.isNaN(result)) {
            writeResultToFile(fileName, x, result);
            throw new ArithmeticException();
        }

        return result;
    }

    /**
     * Writes the result of the expression calculation to a file.
     *
     * @param fileName The name of the file to write to.
     * @param x        The input value used in the calculation.
     * @param result   The result of the expression calculation.
     */
    private static void writeResultToFile(String fileName, double x, double result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".txt"))) {
            writer.println("Введене значення X: " + x);
            writer.println("Значення y при x = " + x + " дорівнює " + result);
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }
}
