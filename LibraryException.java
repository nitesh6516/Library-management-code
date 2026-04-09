// Custom exception for all library-related errors.
// Extending RuntimeException keeps the code clean — no forced try-catch everywhere.
public class LibraryException extends RuntimeException {

    private final int bookId; // store the problematic book ID for context

    public LibraryException(String message, int bookId) {
        super(message);
        this.bookId = bookId;
    }

    public int getBookId() { return bookId; }
}
