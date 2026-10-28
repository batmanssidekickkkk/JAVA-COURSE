// This program demonstrates common array algorithms:
// - Finding the maximum value
// - Finding the minimum value
// - Calculating the average
// - Linear search
public class ArrayAlgorithms {
    public static void main(String[] args) {
        
        // Declare and initialize an array of marks.
        int[] marks = {65, 72, 48, 91, 57, 83, 69, 75, 52, 88};
        
        // Print the array for reference.
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\n");
        
        // ========================================
        // ALGORITHM 1: FIND THE MAXIMUM VALUE (O(n))
        // ========================================
        System.out.println("=== FIND MAXIMUM ===");
        int max = marks[0]; // Assume the first element is the maximum.
        int maxIterations = 0;
        
        for (int i = 0; i < marks.length; i++) {
            maxIterations++;
            if (marks[i] > max) {
                max = marks[i]; // Update max if we find a larger number
            }
        }
        System.out.println("Maximum mark: " + max);
        System.out.println("Iterations: " + maxIterations);
        System.out.println("Time Complexity: O(n)");
        
        // ========================================
        // ALGORITHM 2: FIND THE MINIMUM VALUE (O(n))
        // ========================================
        System.out.println("\n=== FIND MINIMUM ===");
        int min = marks[0]; // Assume the first element is the minimum.
        int minIterations = 0;
        
        for (int i = 0; i < marks.length; i++) {
            minIterations++;
            if (marks[i] < min) {
                min = marks[i]; // Update min if we find a smaller number
            }
        }
        System.out.println("Minimum mark: " + min);
        System.out.println("Iterations: " + minIterations);
        System.out.println("Time Complexity: O(n)");
        
        // ========================================
        // ALGORITHM 3: CALCULATE THE AVERAGE (O(n))
        // ========================================
        System.out.println("\n=== CALCULATE AVERAGE ===");
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        // Cast to double to get decimals in the average
        double average = (double) sum / marks.length;
        System.out.println("Sum: " + sum);
        System.out.println("Number of marks: " + marks.length);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Time Complexity: O(n)");
        
        // ========================================
        // ALGORITHM 4: LINEAR SEARCH (O(n))
        // ========================================
        System.out.println("\n=== LINEAR SEARCH ===");
        int target = 83;
        int foundIndex = -1; // -1 means not found
        int searchIterations = 0;
        
        for (int i = 0; i < marks.length; i++) {
            searchIterations++;
            if (marks[i] == target) {
                foundIndex = i;
                break; // Exit loop once found (optimization)
            }
        }
        
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
        int threshold = 70;
        int count = 0;
        
        for (int mark : marks) {
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
    

