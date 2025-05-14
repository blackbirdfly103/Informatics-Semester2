import java.io.*;
import java.util.Scanner;

public class GroceryList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file to store your grocery list: ");
        String fileName = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            System.out.println("Enter your grocery items (type 'done' to finish):");

            while (true) {
                String item = scanner.nextLine();

                if (item.equalsIgnoreCase("done")) {
                    break;
                }

                writer.println(item);
            }

            System.out.println("Grocery list saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
