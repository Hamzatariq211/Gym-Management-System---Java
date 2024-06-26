import java.sql.Connection;
import java.sql.DriverManager;

// Singleton for managing database connection
public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private final Connection connection;

    private DatabaseConnection() {
        // Establish database connection
    	String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
        String DB_USER = "root";
        String DB_PASSWORD = "hamzasql12344321";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection = conn;
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
