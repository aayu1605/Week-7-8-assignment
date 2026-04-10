import java.util.Scanner;

public class NaturalNumberSum {

    /**
     * Method to find the sum using recursion.
     * It adds 'n' to the sum of '(n-1)' natural numbers until it reaches 1.
     */
    public static long recursiveSum(int n) {
        // Base case: The sum of the first 1 natural number is 1
        if (n == 1) {
            return 1;
        }
        // Recursive step: n + sum of numbers up to (n-1)
        return n + recursiveSum(n - 1);
    }

    /**
     * Method to find the sum using the mathematical formula: n * (n + 1) / 2.
     */
    public static long formulaSum(int n) {
        // We cast 'n' to a long to prevent integer overflow if the user enters a large number
        return (long) n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Sum of Natural Numbers Comparator ---");

        try {
            // Take the user input
            System.out.print("Enter a natural number (n > 0): ");
            int n = scanner.nextInt();

            // Check whether it's a Natural number
            if (n <= 0) {
                System.out.println("Invalid input! Natural numbers are positive integers strictly greater than 0.");
            } else {
                // Compute using both methods
                long resultFromRecursion = recursiveSum(n);
                long resultFromFormula = formulaSum(n);

                // Print the results
                System.out.println("\nCalculations for n = " + n + ":");
                System.out.println("Result from Recursive Method: " + resultFromRecursion);
                System.out.println("Result from Formula Method:   " + resultFromFormula);

                // Compare the two results
                if (resultFromRecursion == resultFromFormula) {
                    System.out.println("\nSuccess! Both computations yield the exact same correct result.");
                } else {
                    System.out.println("\nError! The computations do not match.");
                }
            }

        } catch (StackOverflowError e) {
            // A special catch block just in case the user enters a massive number (like 50,000) 
            // which causes the recursive stack to run out of memory!
            System.out.println("\nWhoops! The number is too large for the recursive method and caused a StackOverflow.");
            System.out.println("This is why the formula method is generally better for large numbers!");
        } catch (Exception e) {
            // Catches inputs like letters or decimals
            System.out.println("\nInvalid input! Please enter a valid whole number.");
        } finally {
            scanner.close();
        }
    }
}