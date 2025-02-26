import java.util.Scanner;

public class LibraryProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = {
                new Book("One Piece", "Oda", 1997),
                new Book("Matilda", "Roald Dahl", 2007),
                new Book("Gorge", "Goshko", 2024)
        };
        int continuity = 1;
        while (continuity == 1) {
            System.out.println("\n--------------------------------------------");
            System.out.println("Welcome to the Library! Choose an option:");
            System.out.println("1 - Display Books");
            System.out.println("2 - Borrow a Book");
            System.out.println("3 - Return a Book");
            System.out.println("4 - Exit");
            System.out.println("--------------------------------------------");
            System.out.print("Choose Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayLibrary(books);
                    break;
                case 2:
                    borrowBook(books, scanner);
                    break;
                case 3:
                    returnBook(books, scanner);
                    break;
                case 4:
                    continuity = 0;
            }
        }
    }

    public static void displayLibrary(Book[] books) {
        System.out.println("Library Inventory:");
        for (Book book : books) {
            System.out.println(book.getDetails());
        }
    }

    public static void borrowBook(Book[] books, Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();

        int index = findBookByTitle(books, title);
        if (index != -1) {
            System.out.println(books[index].borrowBook(name));
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public static void returnBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();

        int index = findBookByTitle(books, title);
        if (index != -1) {
            System.out.println(books[index].returnBook());
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public static int findBookByTitle(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }
}

class Book {
    private String title;
    private String author;
    private int yearPublished;
    private String borrowerName;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowerName = null;
    }

    public String getDetails() {
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished;
    }

    public void updateBookInfo(String newTitle, String newAuthor, int newYearPublished) {
        this.title = newTitle;
        this.author = newAuthor;
        this.yearPublished = newYearPublished;
    }

    public String borrowBook(String borrowerName) {
        if (this.borrowerName == null) {
            this.borrowerName = borrowerName;
            return title + " borrowed by: " + this.borrowerName;
        }
        return  "Sorry book was already borrowed";
    }

    public String returnBook() {
        if (this.borrowerName != null) {
            this.borrowerName = null;
            return "Book returned";
        }
        return "Book wasn't borrowed";
    }

    public String getTitle() {
        return title;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
}


