import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> getUser(int id) {
        String query = "SELECT * FROM user WHERE id = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractFromResultSet(rs));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getUser(String name) {
        String query = "SELECT * FROM user WHERE name = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(query)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractFromResultSet(rs));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public Set<User> getAllUsers() {
        String query = "SELECT * FROM user";
        Set<User> users = new HashSet<>();
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                users.add(extractFromResultSet(rs));
            }
            return users;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    @Override
    public boolean updatePassword(int id, String newPassword) {
        String updateQuery = "UPDATE user SET password = ? WHERE id = ?"; //getUser(id).get();
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(updateQuery)) {
            ps.setString(1, newPassword);
            ps.setInt(2, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        String deleteQuery = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(deleteQuery)){
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static User extractFromResultSet(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getInt("age")
        );
    }

    private static Optional<User> extractFromRS(ResultSet rs) {
        try {
            return Optional.of(new User(rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getString("password"),
                                        rs.getInt("age")));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
