# Library-management-code

=== Setting up the library ===
Added: Clean Code
Added: The Pragmatic Programmer
Added: Effective Java
Added: Design Patterns
Added: Head First Java

=== Issuing book 101 ===
Issued: "Clean Code"

=== Issuing book 101 again (expect error) ===
Caught: Book "Clean Code" is already issued.

=== Returning book 101 ===
Returned: "Clean Code"

=== Returning book 102 (never issued — expect error) ===
Caught: Book "The Pragmatic Programmer" was not issued. Invalid return.

=== Issuing book 999 (doesn't exist — expect error) ===
Caught: No book found with ID: 999

--- Available Books ---
[ID: 101] Clean Code          | Author: Robert C. Martin | Status: Available
[ID: 102] The Pragmatic Programmer | Author: Andrew Hunt  | Status: Available
[ID: 104] Design Patterns     | Author: Gang of Four     | Status: Available
[ID: 105] Head First Java     | Author: Kathy Sierra     | Status: Available
------------------------
