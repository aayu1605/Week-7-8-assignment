import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {

    /**
     * 1. Method to find the count of digits in the number.
     */
    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        number = Math.abs(number); // Handle negative inputs safely
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    /**
     * 2. Method to store the digits of the number in an array.
     */
    public static int[] getDigitsArray(int number) {
        if (number == 0) return new int[]{0};
        
        int count = countDigits(number);
        int[] digits = new int[count];
        number = Math.abs(number);
        
        // Populate the array from right to left so the digits stay in the correct order
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    /**
     * 3. Method to check if a number is a Duck number using the digits array.
     * (A Duck number contains at least one '0').
     */
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 4. Method to check if the number is an Armstrong number using the digits array.
     */
    public static boolean isArmstrongNumber(int originalNumber, int[] digits) {
        int sum = 0;
        int power = digits.length; // The number of digits
        
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        
        // Check if the sum of powers equals the original number
        return sum == originalNumber;
    }

    /**
     * 5. Method to find the largest and second largest elements.
     * Returns an array where index 0 is Largest, index 1 is Second Largest.
     */
    public static int[] findLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest; // Old largest becomes second largest
                largest = digit;         // Update new largest
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;   // Update second largest if it's strictly less than largest
            }
        }
        return new int[]{largest, secondLargest};
    }

    /**
     * 6. Method to find the smallest and second smallest elements.
     * Returns an array where index 0 is Smallest, index 1 is Second Smallest.
     */
    public static int[] findSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest; // Old smallest becomes second smallest
                smallest = digit;          // Update new smallest
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;    // Update second smallest if it's strictly greater than smallest
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Advanced Number Checker Utility ---");

        try {
            System.out.print("Enter an integer to analyze (e.g., 153, 402, 1983): ");
            int number = scanner.nextInt();

            // Store digits in array
            int[] digits = getDigitsArray(number);

            System.out.println("\n--- Results for " + number + " ---");
            System.out.println("Digits Array: " + Arrays.toString(digits));
            System.out.println("Digit Count: " + countDigits(number));
            
            System.out.println("Is Duck Number: " + isDuckNumber(digits));
            System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));

            // Largest / Second Largest
            int[] largestStats = findLargest(digits);
            System.out.println("\nLargest Digit: " + largestStats[0]);
            // If all digits are the exact same (e.g., 111), there is no second largest
            if (largestStats[1] == Integer.MIN_VALUE) {
                System.out.println("Second Largest Digit: None (all digits are identical)");
            } else {
                System.out.println("Second Largest Digit: " + largestStats[1]);
            }

            // Smallest / Second Smallest
            int[] smallestStats = findSmallest(digits);
            System.out.println("Smallest Digit: " + smallestStats[0]);
            if (smallestStats[1] == Integer.MAX_VALUE) {
                System.out.println("Second Smallest Digit: None (all digits are identical)");
            } else {
                System.out.println("Second Smallest Digit: " + smallestStats[1]);
            }

        } catch (Exception e) {
            System.out.println("\nInvalid input! Please enter a valid whole number.");
        } finally {
            scanner.close();
        }
    }
}