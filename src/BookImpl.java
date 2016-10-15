/**
 * @author crkimberley on 15/10/2016.
 */
public class BookImpl implements Book {
    private final String author;
    private final String title;

    public BookImpl(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }
}