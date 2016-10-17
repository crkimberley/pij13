/**
 * @author crkimberley on 17/10/2016.
 */
public class LibraryScript {
    private Book bookA, bookB, bookC, bookD, bookE, bookF;
    public static void main(String[] args) {
        new LibraryScript().launch();
    }

    private void launch() {

        bookA = new BookImpl("James Joyce", "Ulysses");
        bookB = new BookImpl("Herman Melville", "Moby Dick");
        bookC = new BookImpl("Leo Tolstoy", "War and Peace");
        bookD = new BookImpl("Marcel Proust", "In Search of Lost Time");
        bookE = new BookImpl("F. Scott Fitzgerald", "The Great Gatsby");
        bookF = new BookImpl("Miguel de Cervantes", "Don Quixote");

        User userA = new UserImpl("Amy");
        User userB = new UserImpl("Beth");
        User userC = new UserImpl("Claire");

        System.out.println("Create Birkbeck library");
        Library library = new LibraryImpl("Birkbeck");
        System.out.println("Library name: " + library.getName());
        System.out.println("Add some books to the library");
        library.addBook(bookA);
        library.addBook(bookB);
        library.addBook(bookC);
        library.addBook(bookD);
        library.addBook(bookE);
        library.addBook(bookF);
        System.out.println("Number of books in library: " + library.getBookCount());

/*
        System.out.println("Library policy - max books per user: " + library.getMaxBooksPerUser());
        System.out.println("Number of library users: " + library.getReaderCount());
        System.out.println("Number of books borrowed from the library: " + library.getBookBorrowedCount());
        System.out.println("Number of library users: " + library.getReaderCount());
*/

        System.out.println("\nAmy registers with Birkbeck library");
        userA.register(library);
        System.out.println("Number of library users: " + library.getReaderCount());
        System.out.println("User name: " + userA.getName());
        System.out.println("User ID: " + userA.getID());
        System.out.println("Amy takes Don Quixote out");
        userA.takeBook("Don Quixote");
        System.out.println("Titles borrowed by Amy: " + userA.getTitlesBorrowed());
        System.out.println("Number of books borrowed from the library: " + library.getBookBorrowedCount());
        System.out.println("Amy returns Don Quixote");
        userA.returnBook(bookF);
        System.out.println("Titles borrowed by Amy: " + userA.getTitlesBorrowed());
        System.out.println("Number of books borrowed from the library: " + library.getBookBorrowedCount());

        System.out.println("\nAmy takes out 4 more books: War and Peace, Moby Dick, Ulysses and The Great Gatsby");
        userA.takeBook("War and Peace");
        userA.takeBook("Moby Dick");
        userA.takeBook("Ulysses");
        userA.takeBook("The Great Gatsby");
        System.out.println("Titles borrowed by Amy: " + userA.getTitlesBorrowed());
        System.out.println("Number of books borrowed from the library: " + library.getBookBorrowedCount());
        System.out.println("Library sets max book policy of 3");
        System.out.println("Users with too many books: " + library.setMaxBooksPerUser(3));
        System.out.println("Amy returns Moby Dick");
        userA.returnBook(bookB);
        System.out.println("Users with too many books: " + library.setMaxBooksPerUser(3));
        System.out.println("Titles borrowed by Amy: " + userA.getTitlesBorrowed());

        System.out.println("\nBeth and Claire join the library");
        userB.register(library);
        userC.register(library);
        System.out.println("Beth takes out In Search of Lost Time");
        userB.takeBook("In Search of Lost Time");
        System.out.println("Claire takes out Moby Dick");
        userC.takeBook("Moby Dick");
        System.out.println("Who has In Search of Lost Time?  -  " + library.getBookBorrower("In Search of Lost Time"));

        System.out.println("\nLibrary reduces max books to 1. Users with too many books: " + library.setMaxBooksPerUser(1));
        System.out.println("Library reduces max books to 0. Users with too many books: " + library.setMaxBooksPerUser(0));
        System.out.println("Library restores max books to 3. Users with too many books: " + library.setMaxBooksPerUser(3));
    }
}
