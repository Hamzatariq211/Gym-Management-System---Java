import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartTableModel extends AbstractTableModel {

    private List<String[]> data = new ArrayList<>();
    private int rowCount;
    private int columnCount;

    public CartTableModel(ResultSet resultSet) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                data.add(rowData);
            }
            rowCount = data.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        // Replace with appropriate column names from your Cart table
        // This is just an example; modify it according to your table schema
        switch (columnIndex) {
            case 0:
                return "cart_id";
            case 1:
                return "item_id";
            case 2:
                return "item_name";
            case 3:
                return "quantity";
            case 4:
                return "price";
            case 5:
                return "total_price";
            default:
                return "";
        }
    }

    // Method to calculate total price from the table data
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        int totalPriceColumnIndex = 5; // Assuming total_price column is at index 5 (0-based)

        for (String[] row : data) {
            totalPrice += Double.parseDouble(row[totalPriceColumnIndex]);
        }

        return totalPrice;
    }
}
