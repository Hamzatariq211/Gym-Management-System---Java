import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CartShow extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JTextField cardholdername;
    private JTextField cardholdernumber;
    private JTextField cvv;
    private JLabel tp;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CartShow frame = new CartShow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private double calculateTotalPriceFromDatabase() {
        double totalPrice = 0.0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PulseFusion", "root", "hamzasql12344321");
            Statement statement = connection.createStatement();

            String query = "SELECT SUM(total_price) AS total FROM Cart"; // Calculate total price from the 'total_price' column in 'Cart'
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                totalPrice = resultSet.getDouble("total");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    private void displayCart() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PulseFusion", "root", "hamzasql12344321");

            String query = "SELECT * FROM Cart";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            CartTableModel cartTableModel = new CartTableModel(resultSet);
            table.setModel(cartTableModel);

            resultSet.close();
            statement.close();
            connection.close();

            double totalPrice = calculateTotalPriceFromDatabase();
            tp.setText("Total Price: " + totalPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CartShow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 937, 566);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 923, 73);
        panel.setBackground(Color.BLACK);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("View Order");
        lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(409, 10, 160, 53);
        panel.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(26, 89, 490, 242);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel_1 = new JLabel("Card Holder Name");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(40, 351, 176, 33);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_1);

        cardholdername = new JTextField();
        cardholdername.setBounds(214, 354, 233, 36);
        contentPane.add(cardholdername);
        cardholdername.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Card Holder Number");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(40, 404, 190, 33);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_2);

        cardholdernumber = new JTextField();
        cardholdernumber.setBounds(240, 408, 207, 33);
        contentPane.add(cardholdernumber);
        cardholdernumber.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("CVV");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(40, 455, 57, 33);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_3);

        cvv = new JTextField();
        cvv.setBounds(107, 458, 96, 36);
        contentPane.add(cvv);
        cvv.setColumns(10);

        tp = new JLabel("");
        tp.setForeground(new Color(255, 255, 255));
        tp.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 40));
        tp.setBounds(237, 451, 376, 36);
        contentPane.add(tp);

        JButton btnNewButton = new JButton("Pay");
        btnNewButton.addActionListener(e -> {
            String name = cardholdername.getText().trim();
            String number = cardholdernumber.getText().trim();
            String cvvValue = cvv.getText().trim();

            if (name.isEmpty() || number.isEmpty() || cvvValue.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PulseFusion", "root", "hamzasql12344321");
                    Statement statement = connection.createStatement();

                    String query = "DELETE FROM Cart";
                    statement.executeUpdate(query);

                    cardholdername.setText("");
                    cardholdernumber.setText("");
                    cvv.setText("");

                    displayCart();

                    JOptionPane.showMessageDialog(null, "Payment Successful!");

                    statement.close();
                    connection.close();

                    Buygear buygear = new Buygear();
                    buygear.show();
                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(713, 105, 176, 46);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(CartShow.class.getResource("/Images/wp6193340.png")));
        lblNewLabel_4.setBounds(-240, 40, 1189, 629);
        contentPane.add(lblNewLabel_4);

        displayCart();
    }
}
