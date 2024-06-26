import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
    private static DBC instance;
    private Connection connection;
    String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DB_USER = "root";
    String DB_PASSWORD = "hamzasql12344321";

    private DBC() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBC getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBC();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBC();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
