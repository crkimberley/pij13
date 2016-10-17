import java.util.ArrayList;

/**
 * @author crkimberley on 15/10/2016.
 */
public class UserImpl implements User {
    private final String name;
    private int id;
    private Library library;
    private Book book;
    private ArrayList<String> titlesBorrowed;

    public UserImpl(String name) {
        this.name = name;
        titlesBorrowed = new ArrayList<String>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int register(Library library) {
        this.library = library;
        setID(library.getID(name));
        return id;
    }

    @Override
    public String getLibrary() {
        return library.getName();
    }

    @Override
    public Book takeBook(String title) {
        book = library.takeBook(title);
        if (book != null) {
            book.setBorrower(this);
            titlesBorrowed.add(title);
        }
        return book;
    }

    @Override
    public ArrayList<String> getTitlesBorrowed() {
        return titlesBorrowed;
    }

    @Override
    public void returnBook(Book book) {
        library.returnBook(book);
        titlesBorrowed.remove(book.getTitle());
    }
}
