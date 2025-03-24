import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        this.isIssued = true;
    }

    public void returnBook() {
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Issued: " + (isIssued ? "Yes" : "No");
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library!");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issue();
                System.out.println("Book issued: " + title);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter book title to issue: ");
                    title = scanner.nextLine();
                    library.issueBook(title);
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
