// This program demonstrates implicit and explicit type conversion.
// It also shows what happens when types don't match.
public class TypeConversion {
    public static void main(String[] args) {
        // =========================================================
        // IMPLICIT CASTING (WIDENING) - automatic
        // =========================================================
        int intValue = 100;
        double doubleValue = intValue; // Automatic conversion
        System.out.println("=== IMPLICIT CASTING ===");
        System.out.println("int value: " + intValue);
        System.out.println("double value (from int): " + doubleValue);

        long longValue = intValue;
        System.out.println("long value (from int): " + longValue);

        float floatValue = 3.14f;
        double doubleFromFloat = floatValue;
        System.out.println("double value (from float): " + doubleFromFloat);

        // =========================================================
        // EXPLICIT CASTING (NARROWING) - manual
        // =========================================================
        double pi = 3.14159;
        int truncatedPi = (int) pi; // Explicit cast with (int)
        System.out.println("\n=== EXPLICIT CASTING ===");
        System.out.println("double pi: " + pi);
        System.out.println("int pi (truncated): " + truncatedPi);

        double largeDouble = 123.456789;
        float smallFloat = (float) largeDouble;
        System.out.println("double value: " + largeDouble);
        System.out.println("float value (cast): " + smallFloat);

        // =========================================================
        // TYPE MISMATCH ERRORS
        // =========================================================
        System.out.println("\n=== TYPE MISMATCH ERRORS ===");
        System.out.println("The following lines would cause compilation errors:");
        System.out.println("int wrongInt = 3.14; // double to int without cast");
        System.out.println("int wrongString = \"100\"; // String to int");
        System.out.println("int wrongBoolean = true; // boolean to int");
        System.out.println("String wrongChar = 'A'; // char to String");

        // =========================================================
        // STRING CONVERSION
        // =========================================================
        int number = 42;
        String numberString = "" + number; // Convert int to String

        String numericString = "123";
        int parsedInt = Integer.parseInt(numericString);

        String decimalString = "45.67";
        double parsedDouble = Double.parseDouble(decimalString);

        System.out.println("\n=== STRING CONVERSION ===");
        System.out.println("Number as string: " + numberString);
        System.out.println("Parsed int: " + parsedInt);
        System.out.println("Parsed double: " + parsedDouble);
    }
}
