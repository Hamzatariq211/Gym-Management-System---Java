import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// EquipmentController class using Singleton for DB connection
public class EquipmentController {
    private final Connection connection;

    public EquipmentController() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void displayEquipmentData(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("EquipmentID");
        model.addColumn("EquipmentName");
        model.addColumn("Category");
        model.addColumn("Manufacturer");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("PurchaseDate");
        model.addColumn("Description");

        try {
            String query = "SELECT * FROM GymEquipment";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getInt("EquipmentID"),
                        resultSet.getString("EquipmentName"),
                        resultSet.getString("Category"),
                        resultSet.getString("Manufacturer"),
                        resultSet.getInt("Quantity"),
                        resultSet.getDouble("Price"),
                        resultSet.getDate("PurchaseDate"),
                        resultSet.getString("Description")
                });
            }

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
