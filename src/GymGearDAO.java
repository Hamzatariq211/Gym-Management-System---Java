import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GymGearDAO {
    private static GymGearDAO instance;
    private Connection connection;

    private GymGearDAO() {
        // Initialize the database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
            String DB_USER = "root";
            String DB_PASSWORD = "hamzasql12344321";
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static GymGearDAO getInstance() {
        if (instance == null) {
            instance = new GymGearDAO();
        }
        return instance;
    }

    public List<GymGear> getAllGear() {
        List<GymGear> gears = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM GymGear");
            while (resultSet.next()) {
                GymGear gear = new GymGear();
                gear.setGearId(resultSet.getInt("gear_id"));
                gear.setGearName(resultSet.getString("gear_name"));
                gear.setGearType(resultSet.getString("gear_type"));
                gear.setPrice(resultSet.getBigDecimal("price"));
                gear.setQuantity(resultSet.getInt("quantity"));
                gear.setSupplier(resultSet.getString("supplier"));
                gear.setPurchaseDate(resultSet.getTimestamp("purchase_date"));
                gears.add(gear);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gears;
    }
}
