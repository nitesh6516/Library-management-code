import java.util.HashMap;
import java.util.Map;

// Library holds all books and exposes operations on them
public class Library {

    // HashMap gives O(1) lookup by book ID — much faster than a list
    private final Map<Integer, Book> books = new HashMap<>();

    // Add a book — reject duplicates right away
    public void addBook(Book book) {
        if (books.containsKey(book.getBookId())) {
            throw new LibraryException(
                "Book with ID " + book.getBookId() + " already exists.",
                book.getBookId()
            );
        }
        books.put(book.getBookId(), book);
        System.out.println("Added: " + book.getTitle());
    }

    // Issue a book — fails if not found or already issued
    public void issueBook(int bookId) {
        Book book = findBook(bookId); // helper throws if missing

        if (!book.isAvailable()) {
            throw new LibraryException(
                "Book \"" + book.getTitle() + "\" is already issued.",
                bookId
            );
        }

        book.setAvailable(false); // mark as unavailable
        System.out.println("Issued: \"" + book.getTitle() + "\"");
    }

    // Return a book — fails if not found or was never issued
    public void returnBook(int bookId) {
        Book book = findBook(bookId);

        if (book.isAvailable()) {
            // Returning a book that was never issued makes no sense
            throw new LibraryException(
                "Book \"" + book.getTitle() + "\" was not issued. Invalid return.",
                bookId
            );
        }

        book.setAvailable(true);
        System.out.println("Returned: \"" + book.getTitle() + "\"");
    }

    // Show only the books currently on the shelf
    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");

        boolean found = false;
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books available right now.");
        }
        System.out.println("------------------------\n");
    }

    // Private helper — centralises the "book not found" check
    private Book findBook(int bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            throw new LibraryException(
                "No book found with ID: " + bookId, bookId
            );
        }
        return book;
    }
}
