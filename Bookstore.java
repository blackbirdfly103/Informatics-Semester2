import java.util.Scanner;

public class Bookstore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title[] = {"Jumbo", "Shark", "Jorge", "Cheese"};
        double price[] = {12.4, 13.2, 9.8, 5.4};
        int quantity[] = {3, 4, 7, 3};

        printInventory(title, price, quantity);
        boolean userpur = true;
        while (userpur) {
            System.out.println("Enter 1-Search / 2-Buy");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter title");
                    String searchTitle = sc.nextLine();
                    bookSearchInventory(searchTitle, title, price, quantity);
                    break;
                case 2:
                    System.out.println("Enter book index to buy:");
                    int bookIndex = sc.nextInt();
                    if (bookIndex >= 0 && bookIndex < title.length) {
                        buyBook(bookIndex, title, price, quantity, sc);
                    }
                    userpur=false;
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
    }

    public static void printInventory(String[] title, double[] price, int[] quantity) {
        System.out.println("Index\tTitle\tPrice\tQuantity");
        for (int i = 0; i < title.length; i++) {
            System.out.println(i + "\t" + title[i] + "\t" + price[i] + "\t" + quantity[i]);
        }
    }

    public static void bookSearchInventory(String search, String[] title, double[] price, int[] quantity) {
        boolean found = false;
        for (int i = 0; i < title.length; i++) {
            if (title[i].equalsIgnoreCase(search)) {
                System.out.println("Index: " + i);
                System.out.println("Title: " + title[i]);
                System.out.println("Price: " + price[i]);
                System.out.println("Quantity: " + quantity[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void buyBook(int index, String[] title, double[] price, int[] quantity, Scanner sc) {
        if (quantity[index] > 0) {
            System.out.println("Book: " + title[index] + " - Price: $" + price[index]);
            System.out.println("Enter payment amount:");
            double payment = sc.nextDouble();

            if (payment >= price[index]) {
                quantity[index]--;
                System.out.println("Purchase successful! Change: $" + (payment - price[index]));
            } else {
                System.out.println("Insufficient funds. Purchase failed.");
            }
        } else {
            System.out.println("Sorry, this book is out of stock.");
        }
    }
}
