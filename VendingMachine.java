import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String productNames[] = {"Soleti", "Vafla", "Schokolad", "Voda", "Oshe", "Kinder", "Cola", "Tutki"};
        double price[] = {0.80, 1.20, 2.50, 1.00, 3.00, 2.20, 1.80, 3.50, 1.00};
        int quantity[] = {10, 5, 6, 3, 10, 5, 4, 8, 2};
        printAllItems(productNames, price, quantity);
        System.out.println("Enter the product code to purchase: ");
        int productCode = sc.nextInt();
        if (productCode < 1 || productCode > productNames.length) {
            System.out.println("Invalid product code. Please try again.");
            return;
        }
        buy(productNames, price, quantity, productCode, sc);
    }

    public static void printAllItems(String[] productName, double[] price, int[] quantity) {
        System.out.println("Product / Price / Quantity");
        for (int i = 0; i < productName.length; i++) {
            System.out.println((i + 1) + " " + productName[i] + " / " + price[i] + " / " + quantity[i]);
        }
    }

    public static void buy(String[] productName, double[] price, int[] quantity, int code, Scanner sc) {
        int index = code - 1;
        if (quantity[index] <= 0) {
            System.out.println("Sorry, " + productName[index] + " is out of stock.");
            return;
        }

        System.out.println("Please insert money: ");
        double insertedMoney = sc.nextDouble();

        if (insertedMoney < price[index]) {
            System.out.println("Not enough money.");
        } else {
            quantity[index]--;
            double change = insertedMoney - price[index];
            System.out.println("Dispensing " + productName[index]);
            if (change > 0) {
                System.out.println("Your change: " + change);
            }
        }
    }
}
