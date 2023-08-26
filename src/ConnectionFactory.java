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

    /*public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoImpl();

        //System.out.println(userDao.getUser(1));
        System.out.println(userDao.getUser("Andris"));
        //System.out.println(userDao.getAllUsers());

        //System.out.println(userDao.updatePassword(1, "sharknado"));

        //System.out.println(userDao.getUser(1));

        //System.out.println(userDao.deleteUser(4));

        //System.out.println(userDao.getAllUsers());




        *//*String query = "SELECT * FROM user";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)){
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String password = rs.getString(3);
                    int age = rs.getInt(4);

                    User user1 = new User(id, name, password, age);

                    System.out.println("ID: " + id
                                        + ", name: " + name
                                        + ", password: " + password
                                        + ", age: " + age);

                    System.out.println(user1);
                }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }*//*


        *//*String preparedQuery = "SELECT name FROM user";
        try (PreparedStatement ps = getConnection().prepareStatement(preparedQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }*//*
    }*/

}
