import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;

public interface UserDao {
    Optional<User> getUser(int id);
    Optional<User> getUser(String name);
    Set<User> getAllUsers();
    boolean updatePassword(int id, String newPassword);
    boolean deleteUser(int id);
}


// Data
// ACCESS
// OBJECT

// CRUD
// CREATE
// READ
// UPDATE
// DELETE
