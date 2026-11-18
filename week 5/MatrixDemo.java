// This program demonstrates two-dimensional (2D) arrays in Java.
// 2D arrays are useful for tables, grids, and matrices.
public class MatrixDemo {
    public static void main(String[] args) {
        
        // ========================================
        // SECTION 1: DECLARING AND INITIALIZING A 2D ARRAY
        // ========================================
        // Each inner curly brace represents a row.
        int[][] matrix = {
            {1, 2, 3}, // Row 0
            {4, 5, 6}, // Row 1
            {7, 8, 9}  // Row 2
        };
        
        // ========================================
        // SECTION 2: ACCESSING ELEMENTS
        // ========================================
        System.out.println("=== ACCESSING ELEMENTS ===");
        System.out.println("matrix[0][0] = " + matrix[0][0]); // 1
        System.out.println("matrix[1][2] = " + matrix[1][2]); // 6
        System.out.println("matrix[2][1] = " + matrix[2][1]); // 8
        
        System.out.println("Number of rows: " + matrix.length);
        System.out.println("Number of columns in row 0: " + matrix[0].length);
        
        // ========================================
        // SECTION 3: PRINTING THE MATRIX WITH NESTED LOOPS
        // ========================================
        System.out.println("\n=== PRINTING THE MATRIX ===");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // ========================================
        // SECTION 4: SUMMING ELEMENTS IN A 2D ARRAY
        // ========================================
        System.out.println("\n=== SUM OF ALL ELEMENTS ===");
        int totalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                totalSum += matrix[i][j];
            }
        }
        System.out.println("Sum of all elements: " + totalSum);
        
        // ========================================
        // SECTION 5: REAL-WORLD EXAMPLE - STUDENT MARKS TABLE
        // ========================================
        System.out.println("\n=== STUDENT MARKS TABLE ===");
        int[][] studentMarks = {
            {85, 90, 78}, // Alice: Math, English, Science
            {72, 88, 91}, // Bob
            {65, 75, 80}  // Charlie
        };
        String[] studentNames = {"Alice", "Bob", "Charlie"};
        String[] subjects = {"Math", "English", "Science"};
        
        // Print table header.
        System.out.print("Student\t");
        for (String subject : subjects) {
            System.out.print(subject + "\t");
        }
        System.out.println("Average");
        System.out.println("----------------------------------------");
        
        // Loop through each student.
        for (int i = 0; i < studentMarks.length; i++) {
            System.out.print(studentNames[i] + "\t");
            int total = 0;






            for (int j = 0; j < studentMarks[i].length; j++) {
                System.out.print(studentMarks[i][j] + "\t");
                total += studentMarks[i][j];
            }
            double avg = (double) total / studentMarks[i].length;
            System.out.printf("%.2f%n", avg);
        }
    }
}
