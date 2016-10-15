/**
 * @author crkimberley on 15/10/2016.
 */
public interface Book {

    String getAuthor();

    String getTitle();

    boolean isTaken();

    void setTaken(boolean taken);
}
