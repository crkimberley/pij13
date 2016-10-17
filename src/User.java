import java.util.ArrayList;

/**
 * @author crkimberley on 15/10/2016.
 */
public interface User {

    String getName();

    int getID();

    void setID(int id);

    int register(Library library);

    String getLibrary();

    Book takeBook(String title);

    ArrayList<String> getTitlesBorrowed();

    void returnBook(Book book1);
}
