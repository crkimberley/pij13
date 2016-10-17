import java.util.List;
import java.util.Set;

/**
 * @author crkimberley on 15/10/2016.
 */
public interface Library {

    String getName();

    int getID(String name);

    int getMaxBooksPerUser();

    void setMaxBooksPerUser(int number);

    void addBook(String author, String title);

    void addBook(Book book);

    Book takeBook(String title);

    void returnBook(Book book);

    int getReaderCount();

    int getBookCount();

    int getBookBorrowedCount();

    Set<String> getBorrowingUsers();

    Set<String> getUsers();

    String getBookBorrower(String title);
}
