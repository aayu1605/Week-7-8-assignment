import java.util.Scanner;

public class HandshakeCalculator {

    /**
     * Method to calculate the maximum number of possible handshakes.
     * Uses the combination formula: (n * (n - 1)) / 2
     */
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Maximum Handshakes Calculator ---");

        try {
            // Get integer input for the numberOfStudents variable
            System.out.print("Enter the number of students: ");
            int numberOfStudents = scanner.nextInt();

            // Basic validation to ensure we don't calculate for negative people
            if (numberOfStudents < 0) {
                System.out.println("The number of students cannot be negative.");
            } else {
                // Call the method to calculate handshakes
                int handshakes = calculateHandshakes(numberOfStudents);

                // Display the number of possible handshakes
                System.out.println("The maximum number of possible handshakes among " 
                                   + numberOfStudents + " students is " + handshakes + ".");
            }

        } catch (Exception e) {
            // Handle cases where the user types letters or decimals instead of whole numbers
            System.out.println("Invalid input! Please enter a valid integer for the number of students.");
        } finally {
            scanner.close();
        }
    }
}
