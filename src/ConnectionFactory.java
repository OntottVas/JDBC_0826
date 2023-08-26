import javax.xml.transform.Result;
import java.sql.*;

public class ConnectionFactory {

    public static final String url = System.getenv("url");
    public static final String user = System.getenv("user");
    public static final String password = System.getenv("password"); // System.getenv("password");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static void main(String[] args) throws SQLException {

        try (Statement statement = getConnection().createStatement()){
            String query = "SELECT * FROM user";
            try (ResultSet resultSet = statement.executeQuery(query)){
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    int age = resultSet.getInt(4);

                    User user1 = new User(id, name, password, age);

                    System.out.println("ID: " + id
                                        + ", name: " + name
                                        + ", password: " + password
                                        + ", age: " + age);

                    System.out.println(user1);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        String preparedQuery = "SELECT name FROM user";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(preparedQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
