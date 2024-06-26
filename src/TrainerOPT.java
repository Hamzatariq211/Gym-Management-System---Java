import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainerOPT extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;
    private final JPanel panel = new JPanel();
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrainerOPT frame = new TrainerOPT();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    // Helper method to convert ResultSet to TableModel
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        var metaData = rs.getMetaData();
        var columnCount = metaData.getColumnCount();

        // Create column names
        var columnNames = new String[columnCount];
        for (int column = 0; column < columnCount; column++) {
            columnNames[column] = metaData.getColumnLabel(column + 1);
        }

        // Create data table
        var tableModel = new DefaultTableModel(columnNames, 0);
        while (rs.next()) {
            var row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            tableModel.addRow(row);
        }
        return tableModel;
    }
    
    
    
    
    public TrainerOPT() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1005, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(113, 104, 807, 251);
        contentPane.add(scrollPane);
        panel.setBounds(0, 0, 1031, 73);
        panel.setBackground(new Color(0, 0, 0));
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblNewLabel = new JLabel("Workout Plan Analysis");
        lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(376, 10, 295, 53);
        panel.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Generate Analysis");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String monday = (String) table.getValueAt(selectedRow, 2);
                    String tuesday = (String) table.getValueAt(selectedRow, 3);
                    String wednesday = (String) table.getValueAt(selectedRow, 4);
                    String thursday = (String) table.getValueAt(selectedRow, 5);
                    String friday = (String) table.getValueAt(selectedRow, 6);
                    String saturday = (String) table.getValueAt(selectedRow, 7);
                    String sunday = (String) table.getValueAt(selectedRow, 8);

                    workoutAnalysis workoutAnalysisFrame = new workoutAnalysis(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
                    workoutAnalysisFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Please select a row.");
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnNewButton.setBounds(342, 382, 344, 45);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(TrainerOPT.class.getResource("/Images/Your-Four-week-Workout-Plan.jpg")));
        lblNewLabel_1.setBounds(0, 75, 1021, 383);
        contentPane.add(lblNewLabel_1);

        // Fetch and display data in the table
        displayWorkoutPlans();
    }

    private void displayWorkoutPlans() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PulseFusion", "root", "hamzasql12344321");
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM workout_plan");
            ResultSet rs = statement.executeQuery();

            // Create JTable with ResultSet data
            table = new JTable(buildTableModel(rs));
            scrollPane.setViewportView(table);

            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
