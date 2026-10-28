// This program demonstrates arithmetic, relational, and logical operators.
// It also shows operator precedence and type conversion.
public class OperatorsDemo {
    public static void main(String[] args) {
        // =========================================================
        // ARITHMETIC OPERATORS
        // =========================================================
        int a = 17;
        int b = 5;

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;     // Integer division (decimal truncated)
        int remainder = a % b;    // Modulus (remainder of division)

        System.out.println("=== ARITHMETIC OPERATORS ===");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Sum (a + b): " + sum);
        System.out.println("Difference (a - b): " + difference);
        System.out.println("Product (a * b): " + product);
        System.out.println("Quotient (a / b): " + quotient);
        System.out.println("Remainder (a % b): " + remainder);

        // =========================================================
        // OPERATOR PRECEDENCE
        // =========================================================
        int precedence1 = 10 + 5 * 2;     // 5*2 happens first = 20
        int precedence2 = (10 + 5) * 2;   // (10+5) happens first = 30
        int precedence3 = 20 % 3 + 4 * 2; // 20%3=2, 4*2=8, 2+8=10

        System.out.println("\n=== OPERATOR PRECEDENCE ===");
        System.out.println("10 + 5 * 2 = " + precedence1);
        System.out.println("(10 + 5) * 2 = " + precedence2);
        System.out.println("20 % 3 + 4 * 2 = " + precedence3);

        // =========================================================
        // RELATIONAL OPERATORS (Returns true or false)
        // =========================================================
        boolean isEqual = (a == b);
        boolean isNotEqual = (a != b);
        boolean isGreater = (a > b);
        boolean isLess = (a < b);
        boolean isGreaterOrEqual = (a >= b);
        boolean isLessOrEqual = (a <= b);

        System.out.println("\n=== RELATIONAL OPERATORS ===");
        System.out.println("a == b: " + isEqual);
        System.out.println("a != b: " + isNotEqual);
        System.out.println("a > b: " + isGreater);
        System.out.println("a < b: " + isLess);
        System.out.println("a >= b: " + isGreaterOrEqual);
        System.out.println("a <= b: " + isLessOrEqual);

        // =========================================================
        // LOGICAL OPERATORS
        // =========================================================
        boolean x = true;
        boolean y = false;

        boolean andResult = x && y; // AND: true only if BOTH are true
        boolean orResult = x || y;  // OR: true if AT LEAST ONE is true
        boolean notResult = !x;     // NOT: reverses true to false

        System.out.println("\n=== LOGICAL OPERATORS ===");
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x && y: " + andResult);
        System.out.println("x || y: " + orResult);
        System.out.println("!x: " + notResult);

        // =========================================================
        // INCREMENT AND DECREMENT OPERATORS
        // =========================================================
        int counter = 5;
        int postIncrement = counter++; // Uses current value (5), then increments to 6
        int preIncrement = ++counter;  // Increments first (6->7), then uses new value (7)

        System.out.println("\n=== INCREMENT/DECREMENT ===");
        System.out.println("postIncrement value: " + postIncrement);
        System.out.println("preIncrement value: " + preIncrement);
        System.out.println("Final counter value: " + counter);
    }
}