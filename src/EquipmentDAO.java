import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class EquipmentDAO {
    public void addEquipment(Equipment equipment) {
        String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
        String DB_USER = "root";
        String DB_PASSWORD = "hamzasql12344321";

        String sql = "INSERT INTO GymEquipment (EquipmentName, Category, Manufacturer, Quantity, Price, PurchaseDate, Description) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        		PreparedStatement  preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, equipment.getEquipmentName());
            preparedStatement.setString(2, equipment.getCategory());
            preparedStatement.setString(3, equipment.getManufacturer());
            preparedStatement.setInt(4, equipment.getQuantity());
            preparedStatement.setDouble(5, equipment.getPrice());
            preparedStatement.setString(6, equipment.getPurchaseDate()); // Set PurchaseDate
            preparedStatement.setString(7, equipment.getDescription());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Equipment added to the database: " + equipment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
 
    
    
}
