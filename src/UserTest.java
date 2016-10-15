import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author crkimberley on 15/10/2016.
 */
public class UserTest {
    private User user;
    private Library library;
    private int id;
    private final static String name = "Derek";

    @Before
    public void setUp() {
        user = new UserImpl(name);
        library = new LibraryImpl("Birkbeck");
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

    @Test
    public void testRegisterReturnsMockID13() {
        assertEquals(13, user.register(library));
    }

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
}