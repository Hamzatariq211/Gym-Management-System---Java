import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cartconnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "hamzasql12344321";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
