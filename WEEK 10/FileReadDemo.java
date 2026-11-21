import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReadDemo {
    public static void main(String[] args) {
        String fileName = "transactions.txt";
        File file = new File(fileName);

        if (!file.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                pw.println("TRX001, DEPOSIT, 5000, SUCCESS");
                pw.println("TRX002, WITHDRAW, 2000, SUCCESS");
                pw.println("TRX003, DEPOSIT, 15000, SUCCESS");
                pw.println("TRX004, TRANSFER, 1000, FAILED");
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;
            }
        }

        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("=== READING FILE: " + fileName + " ===");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            System.out.println("=== FILE READING COMPLETE ===");
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + fileName + "' was not found.");
        }
    }
}
