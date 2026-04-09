// Represents a single book in the library
public class Book {

    // All fields are private — classic encapsulation
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // Full constructor — used when adding a new book
    public Book(int bookId, String title, String author) {
        this.bookId     = bookId;
        this.title      = title;
        this.author     = author;
        this.isAvailable = true; // every new book starts as available
    }

    // --- Getters ---
    public int     getBookId()      { return bookId; }
    public String  getTitle()       { return title; }
    public String  getAuthor()      { return author; }
    public boolean isAvailable()    { return isAvailable; }

    // --- Setters ---
    public void setTitle(String title)           { this.title = title; }
    public void setAuthor(String author)         { this.author = author; }
    public void setAvailable(boolean available)  { this.isAvailable = available; }

    // Readable string — helpful for displaying book info
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Issued";
        return String.format(
            "[ID: %d] %-35s | Author: %-20s | Status: %s",
            bookId, title, author, status
        );
    }
}
