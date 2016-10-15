/**
 * @author crkimberley on 15/10/2016.
 */
public class UserImpl implements User {
    private final String name;
    private int id;

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }
}
