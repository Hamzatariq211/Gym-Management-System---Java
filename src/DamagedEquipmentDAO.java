import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DamagedEquipmentDAO {
    public void moveEquipment(int equipmentID, String damageDescription, String reportedDate) {
    	String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
        String DB_USER = "root";
        String DB_PASSWORD = "hamzasql12344321";
        
        String insertSql = "INSERT INTO DamagedEquipment (EquipmentID, DamageDescription, DateReported) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {

            insertStatement.setInt(1, equipmentID);
            insertStatement.setString(2, damageDescription);
            insertStatement.setString(3, reportedDate);

            int rowsInserted = insertStatement.executeUpdate();

            if (rowsInserted > 0) {
            	JOptionPane.showMessageDialog(null, "Equipment moved to DamagedEquipment table");
            } else {
            	   JOptionPane.showMessageDialog(null, "Failed to move equipment to DamagedEquipment table");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Other methods for handling DamagedEquipment operations
    // ...
}
