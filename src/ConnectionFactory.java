import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String url = "jdbc:mysql://localhost:3306/firstdatabase";
    public static final String user = "root";
    public static final String password = "A7K7K7V7A7L+mysql";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

}
