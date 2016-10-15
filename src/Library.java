/**
 * @author crkimberley on 15/10/2016.
 */
public interface Library {

    String getName();

    int getID(String name);

    int getMaxBooksPerUser();

    void setMaxBooksPerUser(int number);

    void addBook(String author, String title);

    Book takeBook(String title);

    void returnBook(Book book);
}
