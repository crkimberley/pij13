/**
 * @author crkimberley on 15/10/2016.
 */
public interface User {

    String getName();

    int getID();

    void setID(int id);

    int register(Library library);

    String getLibrary();
}