import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author crkimberley on 15/10/2016.
 */
public class LibraryTest {
    private Library library;
    private final static String name = "Birkbeck";
    private User userA, userB, userC;
    private Book bookA, bookB, bookC, bookD;

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl(name);
        userA = new UserImpl("Amy");
        userB = new UserImpl("Beth");
        userC = new UserImpl("Claire");
        bookA = new BookImpl("James Joyce", "Ulysses");
        bookB = new BookImpl("Herman Melville", "Moby Dick");
        bookC = new BookImpl("Leo Tolstoy", "War and Peace");
        bookD = new BookImpl("Marcel Proust", "In Search of Lost Time");
    }

    @Test
    public void testGetName() {
        assertEquals("Birkbeck", library.getName());
    }

    /*@Test
    public void testGetIDReturnsMockValue13() {
        assertEquals(13, library.getID());
    }*/

    @Test
    public void testGetMaxBooksPerUserInitialValue3() {
        assertEquals(3, library.getMaxBooksPerUser());
    }

    @Test
    public void testSetMaxBooksPerUserThenGet() {
        library.setMaxBooksPerUser(10);
        assertEquals(10, library.getMaxBooksPerUser());
    }

    @Test
    public void testIDsAllocatedForNewUsers() {
        int idA = userA.register(library);
        int idB = userB.register(library);
        int idC = userC.register(library);
        assertEquals(1, idA);
        assertEquals(2, idB);
        assertEquals(3, idC);
    }

    @Test
    public void testCorrectIDReturnedForExistingUsers() {
        int idA = userA.register(library);
        int idB = userB.register(library);
        int idC = userC.register(library);
        assertEquals(idA, library.getID("Amy"));
        assertEquals(idB, library.getID("Beth"));
        assertEquals(idC, library.getID("Claire"));
    }

    @Test
    public void testAddBooksThenTakeThem() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        assertEquals("James Joyce", library.takeBook("Ulysses").getAuthor());
        assertEquals("Herman Melville", library.takeBook("Moby Dick").getAuthor());
    }

    @Test
    public void testTakeNonExistentBook() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        assertNull(library.takeBook("War and Peace"));
    }

    @Test
    public void testTakeBookFromEmptyList() {
        assertNull(library.takeBook("War and Peace"));
    }

    @Test
    public void testTakeBookAndTryToTakeAgain() {
        library.addBook("James Joyce", "Ulysses");
        library.takeBook("Ulysses");
        assertNull(library.takeBook("Ulysses"));
    }

    @Test
    public void testTakeBookReturnAndTakeAgain() {
        library.addBook("James Joyce", "Ulysses");
        Book book = library.takeBook("Ulysses");
        library.returnBook(book);
        assertEquals("James Joyce", library.takeBook("Ulysses").getAuthor());
    }

    @Test
    public void testAdd3UsersThenGetReaderCount() {
        int idA = userA.register(library);
        int idB = userB.register(library);
        int idC = userC.register(library);
        assertEquals(3, library.getReaderCount());
    }

    @Test
    public void testGetReaderCountForEmptyList() {
        assertEquals(0, library.getReaderCount());
    }

    @Test
    public void testAdd2BooksThenGetBookCount() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        assertEquals(2, library.getBookCount());
    }

    @Test
    public void testGetBookCountForEmptyList() {
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testBorrow0BooksThenGetBookBorrowedCount() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        assertEquals(0, library.getBookBorrowedCount());
    }

    @Test
    public void testBorrow2BooksThenGetBookBorrowedCount() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        library.takeBook("Ulysses");
        library.takeBook("Moby Dick");
        assertEquals(2, library.getBookBorrowedCount());
    }

    @Test
    public void testBorrow2BooksReturn1ThenGetBookBorrowedCount() {
        library.addBook("James Joyce", "Ulysses");
        library.addBook("Herman Melville", "Moby Dick");
        library.takeBook("Ulysses");
        Book book = library.takeBook("Moby Dick");
        library.returnBook(book);
        assertEquals(1, library.getBookBorrowedCount());
    }

    @Test
    public void testGetAllBorrowingUsers() {
        userA.register(library);
        userB.register(library);
        library.addBook(bookA);
        library.addBook(bookB);
        userA.takeBook("Ulysses");
        userB.takeBook("Moby Dick");
        Set<String> expectedUsers = new HashSet<String>();
        expectedUsers.add("Amy");
        expectedUsers.add("Beth");
        assertEquals(expectedUsers, library.getBorrowingUsers());
    }

    @Test
    public void testGetAllBorrowingUsersWhen1UserHas2Books() {
        userA.register(library);
        userB.register(library);
        userC.register(library);
        library.addBook(bookA);
        library.addBook(bookB);
        library.addBook(bookC);
        library.addBook(bookD);
        userA.takeBook("Ulysses");
        userA.takeBook("War and Peace");
        userB.takeBook("In Search of Lost Time");
        userC.takeBook("Moby Dick");
        Set<String> expectedUsers = new HashSet<String>();
        expectedUsers.add("Amy");
        expectedUsers.add("Beth");
        expectedUsers.add("Claire");
        assertEquals(expectedUsers, library.getBorrowingUsers());
    }

    @Test
    public void testGetAllUsers() {
        userA.register(library);
        userB.register(library);
        userC.register(library);
        Set<String> expectedUsers = new HashSet<String>();
        expectedUsers.add("Amy");
        expectedUsers.add("Beth");
        expectedUsers.add("Claire");
        assertEquals(expectedUsers, library.getUsers());
    }

    @Test
    public void testGetBorroweForTitle() {
        userA.register(library);
        library.addBook(bookA);
        userA.takeBook("Ulysses");
        assertEquals("Amy", library.getBookBorrower("Ulysses"));
    }
}