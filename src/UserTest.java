import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author crkimberley on 15/10/2016.
 */
public class UserTest {
    private User user;
    private final static String name = "Derek";

    @Before
    public void setUp() throws Exception {
        user = new UserImpl(name);
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
    public void testGetID() {
        user.setID(13);
        assertEquals(13, user.getID());
    }
}