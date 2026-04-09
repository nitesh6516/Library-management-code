public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // --- Seed the library with 5 books ---
        System.out.println("=== Setting up the library ===");
        library.addBook(new Book(101, "Clean Code",                "Robert C. Martin"));
        library.addBook(new Book(102, "The Pragmatic Programmer",   "Andrew Hunt"));
        library.addBook(new Book(103, "Effective Java",             "Joshua Bloch"));
        library.addBook(new Book(104, "Design Patterns",            "Gang of Four"));
        library.addBook(new Book(105, "Head First Java",            "Kathy Sierra"));

        // --- Normal issue ---
        System.out.println("\n=== Issuing book 101 ===");
        library.issueBook(101);

        // --- Try issuing the same book again — should blow up ---
        System.out.println("\n=== Issuing book 101 again (expect error) ===");
        try {
            library.issueBook(101);
        } catch (LibraryException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // --- Normal return ---
        System.out.println("\n=== Returning book 101 ===");
        library.returnBook(101);

        // --- Try returning a book that was never issued ---
        System.out.println("\n=== Returning book 102 (never issued — expect error) ===");
        try {
            library.returnBook(102);
        } catch (LibraryException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // --- Try fetching a non-existent book ---
        System.out.println("\n=== Issuing book 999 (doesn't exist — expect error) ===");
        try {
            library.issueBook(999);
        } catch (LibraryException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Issue a couple more before the final display
        library.issueBook(103);

        // --- Show what's left on the shelf ---
        library.displayAvailableBooks();
    }
}
