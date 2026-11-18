// This program analyzes the efficiency of different loop algorithms.
public class LoopEfficiency {
    public static void main(String[] args) {
        int n = 10;

        // ALGORITHM 1: Linear Loop - O(n)
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            count1++;
        }

        // ALGORITHM 2: Nested Loop - O(n^2)
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count2++;
            }
        }

        // ALGORITHM 3: Triangular Loop - O(n^2/2)
        int count3 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                count3++;
            }
        }

        // ALGORITHM 4: Loop with Condition - O(n)
        int count4 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                count4++;
            }
        }

        System.out.println("=== ALGORITHM 1: Linear Loop ===");
        System.out.println("n = " + n);
        System.out.println("Iterations: " + count1);
        System.out.println("Time Complexity: O(n)\n");

        System.out.println("=== ALGORITHM 2: Nested Loop (Square) ===");
        System.out.println("n = " + n);
        System.out.println("Iterations: " + count2);
        System.out.println("Time Complexity: O(n^2)\n");

        System.out.println("=== ALGORITHM 3: Triangular Loop ===");
        System.out.println("n = " + n);
        System.out.println("Iterations: " + count3);
        System.out.println("Formula: n*(n+1)/2 = " + (n * (n + 1) / 2) + "\n");

        System.out.println("=== ALGORITHM 4: Loop with Condition ===");
        System.out.println("n = " + n);
        System.out.println("Even numbers counted: " + count4);
        System.out.println("Time Complexity: O(n)\n");

        System.out.println("=== COMPARISON TABLE ===");
        System.out.println("Algorithm   | Iterations | Complexity");
        System.out.println("------------+------------+------------");
        System.out.println("Linear      | " + count1 + "          | O(n)");
        System.out.println("Nested      | " + count2 + "         | O(n^2)");
        System.out.println("Triangular  | " + count3 + "          | O(n^2/2)");
        System.out.println("Condition   | " + count4 + "           | O(n)");
    }
}
