import java.util.Scanner;
import java.util.Arrays;

public class FactorAnalyzer {

    /**
     * Method to find the factors of a number, store them in an array, and return it.
     * Uses two loops: one to determine the array size, and one to populate it.
     */
    public static int[] findFactors(int number) {
        int count = 0;

        // First loop: Find the total number of factors to size the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize the array with the exact count
        int[] factors = new int[count];
        int index = 0;

        // Second loop: Populate the array with the factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    /**
     * Method to find the sum of the factors.
     */
    public static int calculateSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    /**
     * Method to find the product of the factors.
     * Note: Using 'long' because products can get very large, very quickly!
     */
    public static long calculateProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    /**
     * Method to find the sum of the squares of the factors using Math.pow().
     * Math.pow returns a double, so we return a double here.
     */
    public static double calculateSumOfSquares(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Factor Analyzer ---");

        try {
            // Take the input for a number
            System.out.print("Enter a positive integer: ");
            int number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Please enter a strictly positive integer greater than zero.");
            } else {
                // Call the methods
                int[] factorsArray = findFactors(number);
                int sum = calculateSum(factorsArray);
                long product = calculateProduct(factorsArray);
                double sumOfSquares = calculateSumOfSquares(factorsArray);

                // Display the results
                System.out.println("\nResults for the number " + number + ":");
                // Arrays.toString is a handy way to print arrays neatly like [1, 2, 4]
                System.out.println("Factors: " + Arrays.toString(factorsArray));
                System.out.println("Sum of Factors: " + sum);
                System.out.println("Product of Factors: " + product);
                System.out.println("Sum of Squares of Factors: " + sumOfSquares);
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid whole number.");
        } finally {
            scanner.close();
        }
    }
}