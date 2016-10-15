import java.util.ArrayList;
import java.util.List;

/**
 * @author crkimberley on 15/10/2016.
 */
public class LibraryImpl implements Library {
    private String name;
    private int maxBooksPerUser = 3;
    private List<String> users;
    private int userCount = 0;
    private List<Book> books;
    private int bookCount = 0;
    private int bookBorowedCount = 0;

    public LibraryImpl(String name) {
        this.name = name;
        users = new ArrayList<String>();
        books = new ArrayList<Book>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID(String name) {
        for (int i=0; i<userCount; i++) {
            if (users.get(i).equals(name)) {
                return i + 1;
            }
        }
        users.add(name);
        userCount++;
        return userCount;
    }

    public int getMaxBooksPerUser() {
        return maxBooksPerUser;
    }

    @Override
    public void setMaxBooksPerUser(int number) {
        maxBooksPerUser = number;
    }

    @Override
    public void addBook(String author, String title) {
        books.add(new BookImpl(author, title));
        bookCount++;
    }

    @Override
    public Book takeBook(String title) {
        for (int i=0; i<bookCount; i++) {
            if (books.get(i).getTitle().equals(title) && !books.get(i).isTaken()) {
                books.get(i).setTaken(true);
                bookBorowedCount++;
                return books.get(i);
            }
        }
        return null;
    }

    @Override
    public void returnBook(Book book) {
        for (int i=0; i<bookCount; i++) {
            if (books.get(i).getTitle().equals(book.getTitle())) {
                book.setTaken(false);
                bookBorowedCount--;
                return;
            }
        }
    }

    @Override
    public int getReaderCount() {
        return userCount;
    }

    @Override
    public int getBookCount() {
        return bookCount;
    }

    @Override
    public int getBookBorrowedCount() {
        return bookBorowedCount;
    }
}
