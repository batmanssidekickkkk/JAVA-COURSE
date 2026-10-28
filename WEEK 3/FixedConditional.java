// This program corrects the logic error.
public class FixedConditional {
    public static void main(String[] args) {
        int age = 20;
        
        if (age >= 18 && age <= 65) {
            System.out.println("You are of working age.");
        } else {
            System.out.println("You are not of working age.");
        }
    }
}
