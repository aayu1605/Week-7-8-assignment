import java.util.Scanner;

public class TriangularParkRun {

    /**
     * Computes the number of rounds required to complete a 5km run.
     * Uses the formula: rounds = distance / perimeter
     */
    public static double computeRounds(double side1, double side2, double side3) {
        // Calculate the perimeter (total distance of one round)
        double perimeter = side1 + side2 + side3;
        
        // 5 km is equal to 5000 meters
        double targetDistance = 5000.0; 
        
        // Return the number of rounds
        return targetDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- 5KM Park Run Calculator ---");

        try {
            // Take user input for the 3 sides of the triangular park
            System.out.print("Enter the first side of the park (in meters): ");
            double side1 = scanner.nextDouble();

            System.out.print("Enter the second side of the park (in meters): ");
            double side2 = scanner.nextDouble();

            System.out.print("Enter the third side of the park (in meters): ");
            double side3 = scanner.nextDouble();

            // Basic validation to ensure sides are positive numbers
            if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
                System.out.println("Invalid input. The sides of a park must be greater than zero.");
            } else {
                // Call the method to compute rounds
                double rounds = computeRounds(side1, side2, side3);
                double perimeter = side1 + side2 + side3;
                
                // Output the results
                System.out.printf("\nThe perimeter of the park is %.2f meters.\n", perimeter);
                System.out.printf("To complete a 5km (5000m) run, the athlete must run %.2f rounds.\n", rounds);
                
                // Real-world logic: athletes run whole rounds
                int fullRoundsNeeded = (int) Math.ceil(rounds);
                System.out.println("To guarantee they hit the 5km mark, they should complete " + fullRoundsNeeded + " full rounds.");
            }

        } catch (Exception e) {
            // Catches errors if the user inputs text instead of numbers
            System.out.println("\nInvalid input! Please enter numerical values only.");
        } finally {
            scanner.close();
        }
    }
}