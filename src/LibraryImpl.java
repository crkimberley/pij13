import java.util.*;

/**
 * @author crkimberley on 15/10/2016.
 */
public class LibraryImpl implements Library {
    private String name;
    private int maxBooksPerUser = 3;
    private List<String> users;
    private List<User> userImpls;
    private int userCount = 0;
    private List<Book> books;
    private int bookCount = 0;
    private int bookBorowedCount = 0;

    public LibraryImpl(String name) {
        this.name = name;
        users = new ArrayList<String>();
        userImpls = new ArrayList<User>();
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

    public int getID(User user, String name) {
        userImpls.add(user);
        return getID(name);
    }

    public int getMaxBooksPerUser() {
        return maxBooksPerUser;
    }

    @Override
    public ArrayList<String> setMaxBooksPerUser(int max) {
        ArrayList<String> overMax = new ArrayList<String>();
        maxBooksPerUser = max;
        for (User user : userImpls) {
            if (user.getTitlesBorrowed().size() > max) {
                overMax.add(user.getName());
            }
        }
        return overMax;
    }

    @Override
    public void addBook(String author, String title) {
        addBook(new BookImpl(author, title));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
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

    @Override
    public Set<String> getBorrowingUsers() {
        Set<String> borrowingUsers = new HashSet<String>();
        for (int i=0; i<bookCount; i++) {
            if (books.get(i).isTaken()) {
                borrowingUsers.add(books.get(i).getBorrower().getName());
            }
        }
        return borrowingUsers;
    }

    @Override
    public Set<String> getUsers() {
        return new HashSet<String>(users);
    }

    @Override
    public String getBookBorrower(String title) {
        for (int i=0; i<bookCount; i++) {
            if (books.get(i).getTitle().equals(title) && books.get(i).isTaken()) {
                return books.get(i).getBorrower().getName();
            }
        }
        return null;
    }
}
