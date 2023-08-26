import java.util.Optional;
import java.util.Set;

public interface UserDao {
    Optional<User> getUser(int id);
    Set<User> getAllUsers();
    boolean updatePassword(int id, String newPassword);

}
