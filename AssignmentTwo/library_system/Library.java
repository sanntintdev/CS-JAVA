package AssignmentTwo.library_system;

import AssignmentTwo.library_system.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();

            try {
                Integer menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        borrowBook();
                        break;
                    case 3:
                        returnBook();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
        }
    }

    private static void displayMenu() {
        System.out.println(
            "\nWelcome to Sann Tint Aung Library Management System"
        );
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
    }

    private static void addBook() {
        System.out.print("Enter book title...");
        String title = scanner.next();
        System.out.print("Enter book author...");
        String author = scanner.next();
        System.out.print("Enter book quantity...");
        Integer quantity = scanner.nextInt();

        boolean bookExists = false;
        for (Book book : books) {
            if (
                book.getTitle().equals(title) && book.getAuthor().equals(author)
            ) {
                Integer oldQuantity = book.getQuantity();
                oldQuantity += quantity;
                book.setQuantity(oldQuantity);
                System.out.println("Book already exists. Quantity increased.");
                bookExists = true;
                break; // Exit the loop since we found the book
            }
        }

        if (!bookExists) {
            books.add(new Book(title, author, quantity));
            System.out.println("Book added successfully.");
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book title...");
        String title = scanner.next();
        System.out.print("Enter number of book...");
        Integer quantity = scanner.nextInt();

        for (Book book : books) {
            if (
                book.getTitle().equals(title) && book.getQuantity() >= quantity
            ) {
                book.borrowBook(quantity);
                System.out.println("Book borrowed successfully.");
                return;
            } else {
                System.out.println("Not enough books to borrow.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void returnBook() {
        System.out.print("Enter book title...");
        String title = scanner.next();
        System.out.print("Enter number of book...");
        Integer quantity = scanner.nextInt();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.returnBook(quantity);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
