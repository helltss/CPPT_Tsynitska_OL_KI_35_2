package Lab5.Tsynitska.CE305;
import java.io.*;
import java.util.Scanner;
/**
 * The ExpressionCalculator class performs calculations based on a given mathematical expression.
 * It includes a method to calculate the expression for a given value of x and a method to write the result to a file.
 */
class ExpressionCalculator {
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
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            ResultFileManager.writeTextResult("result", x, result);
            throw new ArithmeticException();
        }

        return result;
    }
}

/**
 * The ResultFileManager class provides methods to write and read results to and from files.
 */
class ResultFileManager {
    /**
     * Writes the result of the expression calculation to a text file.
     *
     * @param fileName The name of the file to write to.
     * @param x        The input value used in the calculation.
     * @param result   The result of the expression calculation.
     */
    public static void writeTextResult(String fileName, double x, double result) {
        // Write result to a text file
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".txt"))) {
            writer.println("Введене значення X: " + x);
            writer.println("Значення y при x = " + x + " дорівнює " + result);
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }

    /**
     * Writes the result of the expression calculation to a binary file.
     *
     * @param fileName The name of the file to write to.
     * @param x        The input value used in the calculation.
     * @param result   The result of the expression calculation.
     */
    public static void writeBinaryResult(String fileName, double x, double result) {
        // Write result to a binary file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".dat"))) {
            oos.writeDouble(x);
            oos.writeDouble(result);
        } catch (IOException ex) {
            System.err.println("Error writing to binary file: " + ex.getMessage());
        }
    }

    /**
     * Reads the result of the expression calculation from a text file.
     *
     * @param fileName The name of the file to read from.
     * @return The result of the expression calculation.
     */
    public static double readTextResult(String fileName) {
        // Read result from a text file
        try (Scanner scanner = new Scanner(new File(fileName + ".txt"))) {
            double x = scanner.nextDouble();
            double result = scanner.nextDouble();
            return result;
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
            return 0.0;
        }
    }

    /**
     * Reads the result of the expression calculation from a binary file.
     *
     * @param fileName The name of the file to read from.
     * @return The result of the expression calculation.
     */
    public static double readBinaryResult(String fileName) {
        // Read result from a binary file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".dat"))) {
            double x = ois.readDouble();
            double result = ois.readDouble();
            return result;
        } catch (IOException ex) {
            System.err.println("Error reading from binary file: " + ex.getMessage());
            return 0.0;
        }
    }
}