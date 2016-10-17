import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author crkimberley on 15/10/2016.
 */
public class BookTest {
    private Book book;
    private final static String author = "Shakespeare";
    private final static String title = "Hamlet";
    private User user;

    @Before
    public void setUp() {
        book = new BookImpl(author, title);
        user = new UserImpl("Cedric");
    }

    @Test
    public void testGetAuthor() {
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals(title, book.getTitle());
    }

    @Test
    public void testSetAndGetBorrower() {
        book.setBorrower(user);
        assertEquals(user, book.getBorrower());
    }

    @Test
    public void testGetBorrowerForUnBorrowedBook() {
        assertNull(book.getBorrower());
    }
}