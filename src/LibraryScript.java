/**
 * @author crkimberley on 17/10/2016.
 */
public class LibraryScript {
    public static void main(String[] args) {
        new LibraryScript().launch();
    }

    private void launch() {
        Library library = new LibraryImpl("Birkbeck");
        Book bookA = new BookImpl("Shakespeare", "Hamlet");
        library.addBook(bookA);
        User userA = new UserImpl("Amy");

        System.out.println("Amy registers with Birkbeck library, takes out Hamlet then returns it");
        System.out.println("Library name: " + library.getName());
        System.out.println("Library policy - max books per user: " + library.getMaxBooksPerUser());
        System.out.println("User name: " + userA.getName());
        System.out.println("User ID: " + userA.getID());
        userA.register(library);
        System.out.println("Number of library users: " + library.getReaderCount());
        userA.takeBook("Hamlet");
        System.out.println("Titles borrowed by user: " + userA.getTitlesBorrowed());


        userA.returnBook(bookA);
    }
}
