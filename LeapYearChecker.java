import java.util.Scanner;

public class LeapYearChecker {

    /**
     * Method to check if a given year is a leap year.
     * Uses the rule: Divisible by 4 AND not divisible by 100, OR divisible by 400.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Leap Year Checker ---");

        try {
            // Take year as input from the user
            System.out.print("Enter a year to check: ");
            int year = scanner.nextInt();

            // Validate that the year falls within the Gregorian calendar timeframe
            if (year < 1582) {
                System.out.println("Invalid input. The Leap Year rules only apply to years greater than or equal to 1582 (Gregorian calendar).");
            } else {
                // Call the method to check the condition
                boolean result = isLeapYear(year);

                // Output whether it is a leap year or not
                if (result) {
                    System.out.println("The year " + year + " is a Leap Year.");
                } else {
                    System.out.println("The year " + year + " is NOT a Leap Year.");
                }
            }

        } catch (Exception e) {
            // Handles errors if the user inputs text or symbols instead of a number
            System.out.println("\nInvalid input! Please enter a valid numerical year.");
        } finally {
            scanner.close();
        }
    }
}