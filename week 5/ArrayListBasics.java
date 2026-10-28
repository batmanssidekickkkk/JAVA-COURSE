// This program demonstrates the basics of ArrayLists in Java.
// ArrayList is a dynamic array that can grow and shrink.

// Import the ArrayList class from java.util package.
import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        
        // ========================================
        // SECTION 1: CREATING AN ARRAYLIST
        // ========================================
        // The <String> is called a generic type parameter.
        // It ensures only Strings can be added to this list.
        ArrayList<String> names = new ArrayList<>();
        
        // ========================================
        // SECTION 2: ADDING ELEMENTS - add()
        // ========================================
        System.out.println("=== ADDING ELEMENTS ===");
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("After adding: " + names);
        
        // Add an element at a specific index (shifts subsequent elements right).
        names.add(1, "Diana");
        System.out.println("After adding Diana at index 1: " + names);
        
        // ========================================
        // SECTION 3: ACCESSING ELEMENTS - get()
        // ========================================
        System.out.println("\n=== ACCESSING ELEMENTS ===");
        System.out.println("First element: " + names.get(0));
        System.out.println("Element at index 2: " + names.get(2));
        System.out.println("Last element: " + names.get(names.size() - 1));
        
        // ========================================
        // SECTION 4: SIZE - size()
        // ========================================
        System.out.println("\n=== SIZE ===");
        System.out.println("Number of names: " + names.size());
        
        // ========================================
        // SECTION 5: CHECKING FOR ELEMENTS - contains()
        // ========================================
        System.out.println("\n=== CONTAINS ===");
        System.out.println("Contains Bob? " + names.contains("Bob"));
        System.out.println("Contains Eve? " + names.contains("Eve"));
        
        // ========================================
        // SECTION 6: FINDING INDEX - indexOf()
        // ========================================
        System.out.println("\n=== INDEX OF ===");
        System.out.println("Index of Charlie: " + names.indexOf("Charlie"));
        System.out.println("Index of Eve: " + names.indexOf("Eve")); // returns -1 if not found
        
        // ========================================
        // SECTION 7: REMOVING ELEMENTS - remove()
        // ========================================
        System.out.println("\n=== REMOVING ELEMENTS ===");
        names.remove("Bob"); // remove by object
        System.out.println("After removing Bob: " + names);
        
        names.remove(0); // remove by index
        System.out.println("After removing element at index 0: " + names);
        
        // ========================================
        // SECTION 8: UPDATING ELEMENTS - set()
        // ========================================
        System.out.println("\n=== UPDATING ELEMENTS ===");
        names.set(0, "Eve"); // replaces element at index 0
        System.out.println("After setting index 0 to Eve: " + names);
        
        // ========================================
        // SECTION 9: ITERATING WITH A FOR LOOP
        // ========================================
        System.out.println("\n=== ITERATING WITH TRADITIONAL FOR LOOP ===");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Index " + i + ": " + names.get(i));
        }
        
        // ========================================
        // SECTION 10: ITERATING WITH ENHANCED FOR LOOP
        // ========================================
        System.out.println("\n=== ITERATING WITH ENHANCED FOR LOOP ===");
        for (String name : names) {
            System.out.println("Name: " + name);
        }
        
        // ========================================
        // SECTION 11: CLEARING THE LIST - clear()
        // ========================================
        System.out.println("\n=== CLEARING THE LIST ===");
        names.clear();
        System.out.println("After clearing: " + names);
        System.out.println("Size after clearing: " + names.size());
        
        // ========================================
        // SECTION 12: ARRAYLIST OF INTEGERS (WRAPPER CLASSES)
        // ========================================
        System.out.println("\n=== ARRAYLIST OF INTEGERS ===");
        // ArrayList cannot store primitive int; use Integer (wrapper class).
        ArrayList<Integer> scores = new ArrayList<>();
        
        scores.add(85); // Autoboxing converts int to Integer
        scores.add(92);
        scores.add(78);
        System.out.println("Scores: " + scores);
        
        int firstScore = scores.get(0); // Unboxing converts Integer to int
        System.out.println("First score: " + firstScore);
        
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        System.out.println("Total: " + total);
    }
}



