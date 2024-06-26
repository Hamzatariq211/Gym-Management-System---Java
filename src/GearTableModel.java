import javax.swing.table.AbstractTableModel;
import java.util.List;

public class GearTableModel extends AbstractTableModel {
    private final List<GymGear> gearList;
    private final String[] columnNames = {"ID", "Name", "Type", "Price", "Quantity", "Supplier", "Purchase Date"};

    public GearTableModel(List<GymGear> gearList) {
        this.gearList = gearList;
    }

    @Override
    public int getRowCount() {
        return gearList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GymGear gear = gearList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return gear.getGearId();
            case 1:
                return gear.getGearName();
            case 2:
                return gear.getGearType();
            case 3:
                return gear.getPrice();
            case 4:
                return gear.getQuantity();
            case 5:
                return gear.getSupplier();
            case 6:
                return gear.getPurchaseDate();
            default:
                return null;
        }
    }

    // Optionally, you may need to override setValueAt() method for editable cells

    // Example:
    // @Override
    // public void setValueAt(Object value, int rowIndex, int columnIndex) {
    //     GymGear gear = gearList.get(rowIndex);
    //     switch (columnIndex) {
    //         case 0:
    //             gear.setGearId((int) value);
    //             break;
    //         case 1:
    //             gear.setGearName((String) value);
    //             break;
    //         // Add cases for other columns
    //         default:
    //             break;
    //     }
    //     fireTableCellUpdated(rowIndex, columnIndex);
    // }
}
