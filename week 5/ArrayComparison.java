// This program compares the characteristics of standard Arrays vs ArrayLists.
public class ArrayComparison {
    public static void main(String[] args) {
        
        System.out.println("=== ARRAY VS ARRAYLIST TRADE-OFFS ===");
        
        // 1. Size Flexibility
        System.out.println("\n1. Size Flexibility:");
        System.out.println("- Array: Fixed size. Once created (e.g., new int[5]), its length cannot change.");
        System.out.println("- ArrayList: Dynamic size. Automatically grows and shrinks as needed.");
        
        // 2. Data Types
        System.out.println("\n2. Data Types:");
        System.out.println("- Array: Can store both primitives (int, double, char) and objects.");
        System.out.println("- ArrayList: Can ONLY store objects. Must use wrapper classes (Integer, Double) for primitives.");
        
        // 3. Performance / Memory
        System.out.println("\n3. Performance & Memory:");
        System.out.println("- Array: Memory efficient, faster access when size is known and fixed.");
        System.out.println("- ArrayList: Slight memory overhead due to internal array resizing and object wrapping.");
        
        // 4. Syntax & Convenience
        System.out.println("\n4. Syntax & Convenience:");
        System.out.println("- Array: Uses bracket notation (arr[0]) and .length property.");
        System.out.println("- ArrayList: Uses built-in methods like .add(), .get(), .set(), and .size().");
    }
}





