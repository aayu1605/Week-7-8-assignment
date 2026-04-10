import java.util.Scanner;

public class SimpleInterestCalculator {

    /**
     * Method to calculate the simple interest given principal, rate, and time.
     */
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100.0;
    }

    public static void main(String[] args) {
        // Scanner is used to read user input in Java
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Simple Interest Calculator ---");

        try {
            // Take user input for principal, rate, and time
            System.out.print("Enter the Principal amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter the Rate of Interest (in %): ");
            double rate = scanner.nextDouble();

            System.out.print("Enter the Time (in years): ");
            double time = scanner.nextDouble();

            // Call the method to calculate the interest
            double interest = calculateSimpleInterest(principal, rate, time);

            // Output the result in the exact format requested
            // printf is used to inject variables and format decimals (%.2f limits it to 2 decimal places)
            System.out.printf("\nThe Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f\n", 
                              interest, principal, rate, time);

        } catch (Exception e) {
            // Catches errors if the user inputs text instead of numbers
            System.out.println("\nInvalid input! Please enter numerical values only.");
        } finally {
            // Closes the scanner to prevent memory leaks
            scanner.close();
        }
    }
}