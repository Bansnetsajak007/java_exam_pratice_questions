import java.util.Scanner;
import java.io.FileWriter;

public class FileWriter {
    public static void main(String[] args) {
        try {
            // with open file "output.txt" in write mode as file:
            FileWriter file = new FileWriter("output.txt");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text to write to file: ");
            String input = scanner.nextLine();

            file.write(input);
            file.close();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}