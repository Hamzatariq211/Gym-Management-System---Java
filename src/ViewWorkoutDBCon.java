import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ViewWorkoutDBCon {
    private static ViewWorkoutDBCon instance;
    private Connection connection;

    private ViewWorkoutDBCon() {
        String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
        String DB_USER = "root";
        String DB_PASSWORD = "hamzasql12344321";
        try {
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  synchronized static ViewWorkoutDBCon getInstance() {
        if (instance == null) {
            instance = new ViewWorkoutDBCon();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    // Other database methods...

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
