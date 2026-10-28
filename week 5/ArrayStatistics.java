
// This program demonstrates common array algorithms:
// - Finding the maximum value
// - Finding the minimum value
// - Calculating the average
// - Linear search
public class ArrayStatistics {
    public static void main(String[] args) {
        // Declare and initialize an array of marks[cite: 9].
        int[] marks = {65, 72, 48, 91, 57, 83, 69, 75, 52, 88};

        // Print the array for reference[cite: 9].
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\n");

        // ========================================
        // ALGORITHM 1: FIND THE MAXIMUM VALUE (O(n))
        // ========================================
        System.out.println("=== FIND MAXIMUM ===");
        // Assume the first element is the maximum[cite: 9].
        int max = marks[0];
        // Iteration counter to analyze efficiency[cite: 9].
        int maxIterations = 0;

        // Loop through all elements[cite: 9, 10].
        for (int i = 0; i < marks.length; i++) {
            maxIterations++;
            // If the current element is greater than max, update max[cite: 10].
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        System.out.println("Maximum mark: " + max);
        System.out.println("Iterations: " + maxIterations);
        System.out.println("Time Complexity: O(n)");

        // ========================================
        // ALGORITHM 2: FIND THE MINIMUM VALUE (O(n))
        // ========================================
        System.out.println("\n=== FIND MINIMUM ===");
        // Assume the first element is the minimum[cite: 10].
        int min = marks[0];
        // Iteration counter[cite: 10].
        int minIterations = 0;

        // Loop through all elements[cite: 10, 11].
        for (int i = 0; i < marks.length; i++) {
            minIterations++;
            // If the current element is less than min, update min[cite: 11].
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        System.out.println("Minimum mark: " + min);
        System.out.println("Iterations: " + minIterations);
        System.out.println("Time Complexity: O(n)");

        // ========================================
        // ALGORITHM 3: CALCULATE THE AVERAGE (O(n))
        // ========================================
        System.out.println("\n=== CALCULATE AVERAGE ===");
        // Variable to hold the sum of all marks[cite: 11].
        int sum = 0;
        // Loop through the array and add each element to sum[cite: 11].
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        // Calculate the average as a double[cite: 12].
        double average = (double) sum / marks.length;
        System.out.println("Sum: " + sum);
        System.out.println("Number of marks: " + marks.length);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Time Complexity: O(n)");

        // ========================================
        // ALGORITHM 4: LINEAR SEARCH (O(n))
        // ========================================
        System.out.println("\n=== LINEAR SEARCH ===");
        // The value we are looking for[cite: 12].
        int target = 83;
        // Variable to store the position (index). -1 means not found[cite: 12].
        int foundIndex = -1;
        // Iteration counter[cite: 12].
        int searchIterations = 0;

        // Loop through the array looking for the target[cite: 12, 13].
        for (int i = 0; i < marks.length; i++) {
            searchIterations++;
            if (marks[i] == target) {
                foundIndex = i;
                break; // Exit loop once found (early exit optimization)[cite: 13]
            }
        }

        // Report the result[cite: 13].
        if (foundIndex != -1) {
            System.out.println("Found " + target + " at index " + foundIndex);
        } else {
            System.out.println(target + " not found in the array.");
        }
        System.out.println("Iterations: " + searchIterations);
        System.out.println("Time Complexity: O(n) - best case O(1), worst case O(n)");

        // ========================================
        // ALGORITHM 5: COUNT ELEMENTS ABOVE THRESHOLD (O(n))
        // ========================================
        System.out.println("\n=== COUNT ABOVE THRESHOLD ===");
        // Threshold value (pass mark)[cite: 13].
        int threshold = 70;
        // Counter for elements above threshold[cite: 13, 14].
        int count = 0;

        // Loop through the array[cite: 14].
        for (int mark : marks) {
            // Increment count if the mark is >= threshold[cite: 14].
            if (mark >= threshold) {
                count++;
            }
        }
        System.out.println("Marks above or equal to " + threshold + ": " + count);
        System.out.println("Total marks: " + marks.length);
        System.out.println("Time Complexity: O(n)");

        // ========================================
        // COMPLEXITY SUMMARY
        // ========================================
        System.out.println("\n=== COMPLEXITY SUMMARY ===");
        System.out.println("Algorithm          | Iterations | Complexity");
        System.out.println("---------------------------------------------");
        System.out.println("Find Maximum       | " + maxIterations + "         | O(n)");
        System.out.println("Find Minimum       | " + minIterations + "         | O(n)");
        System.out.println("Average            | " + marks.length + "         | O(n)");
        System.out.println("Linear Search      | " + searchIterations + "          | O(n)");
        System.out.println("Count Above        | " + marks.length + "         | O(n)");
    }
}