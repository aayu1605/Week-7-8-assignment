import java.util.Scanner;

public class NumberChecker {

    /**
     * Method to check the sign of a number.
     * Returns 1 if positive, -1 if negative, and 0 if zero.
     */
    public static int checkSign(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Number Sign Checker ---");

        try {
            // Get integer input from the user
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();

            // Call the method to get the sign indicator (-1, 1, or 0)
            int signIndicator = checkSign(num);

            // Use the returned value to print the correct message
            if (signIndicator == 1) {
                System.out.println("The number " + num + " is positive.");
            } else if (signIndicator == -1) {
                System.out.println("The number " + num + " is negative.");
            } else {
                System.out.println("The number is zero.");
            }

        } catch (Exception e) {
            // Handle cases where the user types letters or decimals instead of integers
            System.out.println("Invalid input! Please enter a valid whole integer.");
        } finally {
            scanner.close();
        }
    }
}