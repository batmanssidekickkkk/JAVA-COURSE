import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataProcessor {
    private static File findInputFile() {
        String[] candidates = {
            "students.csv",
            "week10/students.csv",
            "WEEK 10/students.csv"
        };
        for (String path : candidates) {
            File f = new File(path);
            if (f.exists()) {
                return f;
            }
        }
        return new File("students.csv");
    }

    public static void main(String[] args) {
        Map<String, String> results = new HashMap<>();
        File file = findInputFile();
        String outputFile = "report.txt";
        double totalMarks = 0.0;
        int studentCount = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[1].trim();
                    int marks = Integer.parseInt(parts[2].trim());

                    totalMarks += marks;
                    studentCount++;

                    if (marks >= 50) {
                        results.put(name, "PASSED");
                    } else {
                        results.put(name, "FAILED");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file '" + file.getPath() + "' not found.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error: The file contains non-numeric marks.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("=== EXAMINATION REPORT ===");
            writer.println("Total Students Processed: " + studentCount);
            double average = (studentCount > 0) ? (totalMarks / studentCount) : 0.0;
            writer.println("Class Average: " + average);
            writer.println("----------------------------");

            for (Map.Entry<String, String> entry : results.entrySet()) {
                writer.println("Student: " + entry.getKey() + " | Result: " + entry.getValue());
            }

            System.out.println("Data processing complete! Check " + outputFile + " for results.");
        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
        }
    }
}
