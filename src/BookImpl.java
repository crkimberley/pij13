/**
 * @author crkimberley on 15/10/2016.
 */
public class BookImpl implements Book {
    private final String author;
    private final String title;
    private boolean taken;
    private User borrower;

    public BookImpl(String author, String title) {
        this.author = author;
        this.title = title;
        taken = false;
        borrower = null;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isTaken() {
        return taken;
    }

    @Override
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public void setBorrower(User user) {
        borrower = user;
    }

    @Override
    public User getBorrower() {
        return borrower;
    }
}