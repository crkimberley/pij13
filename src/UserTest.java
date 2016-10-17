import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author crkimberley on 15/10/2016.
 */
public class UserTest {
    private User user, user1;
    private Library library;
    private int id;
    private final static String name = "Derek";
    private final static String name1 = "Bert";
    private Book book, book1;
    private ArrayList<String> expectedTitles;

    @Before
    public void setUp() {
        user = new UserImpl(name);
        user1 = new UserImpl(name1);
        library = new LibraryImpl("Birkbeck");
        expectedTitles = new ArrayList<String>();
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(name, user.getName());
    }

    @Test
    public void testGetIDBeforeSetID() {
        assertEquals(0, user.getID());
    }

    @Test
    public void testSetThenGetID() {
        user.setID(13);
        assertEquals(13, user.getID());
    }

    /*@Test
    public void testRegisterReturnsMockID13() {
        assertEquals(13, user.register(library));
    }*/

    @Test
    public void testRegisterThenGetLibraryReturnsName() {
        user.register(library);
        assertEquals("Birkbeck", user.getLibrary());
    }

    @Test
    public void testGetIDReturnsSameIDAsRegister() {
        id = user.register(library);
        assertEquals(id, user.getID());
    }

    @Test
    public void testGetMaxBooksPerUser() {
        user.register(library);
        assertEquals(3, library.getMaxBooksPerUser());
    }

    @Test
    public void testTakeBookThenGetBorrower() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        id = user.register(library);
        book = user.takeBook("Ulysses");
        assertEquals(user, book.getBorrower());
    }

    @Test
    public void testGetTitlesBorrowedByUser() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        user.register(library);
        book = user.takeBook("Ulysses");
        book1 = user.takeBook("Moby Dick");
        expectedTitles.add(book.getTitle());
        expectedTitles.add(book1.getTitle());
        assertEquals(expectedTitles, user.getTitlesBorrowed());
    }

    @Test
    public void testGetTitlesBorrowedBeforeAnyTaken() {
        user.register(library);
        assertEquals(new ArrayList<String>(), user.getTitlesBorrowed());
    }

    @Test
    public void testGetTitlesBorrowedByUserAfterReturningOne() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        user.register(library);
        book = user.takeBook("Ulysses");
        book1 = user.takeBook("Moby Dick");
        user.returnBook(book1);
        expectedTitles.add(book.getTitle());
        assertEquals(expectedTitles, user.getTitlesBorrowed());
    }



}