import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckInDataFactory {
    private final Connection connection;

    public CheckInDataFactory() throws SQLException {
        this.connection = DBC.getInstance().getConnection();
    }

    public void populateTable(JTable table) {
        try {
            String query = "SELECT * FROM CheckIn";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("CheckInID");
            tableModel.addColumn("UserID");
            tableModel.addColumn("UserName");
            tableModel.addColumn("CheckInTime");

            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getInt("CheckInID"),
                        resultSet.getInt("UserID"),
                        resultSet.getString("UserName"),
                        resultSet.getTimestamp("CheckInTime")
                };
                tableModel.addRow(rowData);
            }

            // Set the model to the table
            table.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
