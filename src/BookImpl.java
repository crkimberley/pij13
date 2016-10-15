/**
 * @author crkimberley on 15/10/2016.
 */
public class BookImpl implements Book {
    private final String author;
    private final String title;
    private boolean taken;

    public BookImpl(String author, String title) {
        this.author = author;
        this.title = title;
        taken = false;
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
}