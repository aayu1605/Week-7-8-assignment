import java.util.Arrays;

public class FootballTeamHeights {

    /**
     * Method to find the sum of all elements present in the array.
     */
    public static int calculateSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    /**
     * Method to find the mean height of the players.
     * Uses the calculateSum method to avoid rewriting code!
     */
    public static double calculateMean(int[] heights) {
        int sum = calculateSum(heights);
        // We cast the sum to a double so the division doesn't drop the decimal values
        return (double) sum / heights.length;
    }

    /**
     * Method to find the shortest height of the players.
     */
    public static int findShortest(int[] heights) {
        // Assume the first player is the shortest initially
        int shortest = heights[0]; 
        for (int height : heights) {
            if (height < shortest) {
                shortest = height; // Found someone shorter, update the variable
            }
        }
        return shortest;
    }

    /**
     * Method to find the tallest height of the players.
     */
    public static int findTallest(int[] heights) {
        // Assume the first player is the tallest initially
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height; // Found someone taller, update the variable
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        System.out.println("--- Football Team Heights Analyzer ---");

        // Create an int array named heights of size 11
        int[] heights = new int[11];

        // Define the range for the heights
        int minHeight = 150;
        int maxHeight = 250;

        // Populate the array with random heights in the given range
        for (int i = 0; i < heights.length; i++) {
            // Formula to get a random integer within a specific range [min, max] inclusive
            heights[i] = (int) (Math.random() * ((maxHeight - minHeight) + 1)) + minHeight;
        }

        // Display the randomly generated team
        System.out.println("Generated Team Heights (in cms): " + Arrays.toString(heights));

        // Call the methods to perform calculations
        int sum = calculateSum(heights);
        double mean = calculateMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        // Display the final results
        System.out.println("\nResults:");
        System.out.println("Sum of all heights: " + sum + " cms");
        // Using printf to format the mean to 2 decimal places so it looks neat
        System.out.printf("Mean height: %.2f cms\n", mean);
        System.out.println("Shortest player height: " + shortest + " cms");
        System.out.println("Tallest player height: " + tallest + " cms");
    }
}