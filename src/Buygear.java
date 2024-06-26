import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class Buygear extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private GymGearDAO gearDAO;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Buygear frame = new Buygear();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Buygear() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 746, 533);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 747, 90);
        panel.setBackground(new Color(0, 0, 0));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Buy Gear");
        lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(301, 25, 139, 37);
        panel.add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(69, 151, 601, 248);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(127, 432, 65, 28);
        spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        contentPane.add(spinner);
        
        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBounds(273, 419, 123, 44);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get selected row from the table
                int selectedRow = table.getSelectedRow();
                
                if (selectedRow != -1) { // If a row is selected
                    try {
                        int itemId = (int) table.getValueAt(selectedRow, 0); // Assuming gear_id is in the first column
                        String itemName = (String) table.getValueAt(selectedRow, 1); // Assuming gear_name is in the second column
                        BigDecimal price = (BigDecimal) table.getValueAt(selectedRow, 3);  // Assuming price is in the fourth column

                        int quantity = (int) spinner.getValue(); // Get the selected quantity from the spinner

                        // Calculate total price
                        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(quantity));

                        // Create a CartItem object
                        CartItem cartItem = new CartItem();
                        cartItem.setItemId(itemId);
                        cartItem.setItemName(itemName);
                        cartItem.setQuantity(quantity);
                        cartItem.setPrice(price);
                        cartItem.setTotalPrice(totalPrice);

                        // Add the item to the cart
                        cartItem.addToCart(cartconnection.getConnection()); // Assuming you have a method to get connection in GymGearDAO

                        // Optionally, you can update the table after adding the item to the cart
                        populateGearTable();

                        // Notify the user that the item was added successfully (you can use JOptionPane or any other method)
                        JOptionPane.showMessageDialog(Buygear.this, "Item added to cart successfully!");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(Buygear.this, "Error adding item to cart.");
                    }
                } else {
                    JOptionPane.showMessageDialog(Buygear.this, "Please select an item from the table.");
                }
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Move to Cart");
        btnNewButton_1.setBounds(471, 419, 163, 44);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		CartShow cartshow = new CartShow();
        		cartshow.show();
        		dispose();
        		
        		
        		
        		
        		
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Buygear.class.getResource("/Images/696fa5079601723ea9f0c2a59615ea96.jpg")));
        lblNewLabel.setBounds(0, 89, 747, 414);
        contentPane.add(lblNewLabel);

        gearDAO = GymGearDAO.getInstance();
        populateGearTable();
    }

    private void populateGearTable() {
        List<GymGear> gearList = gearDAO.getAllGear();
        GearTableModel tableModel = new GearTableModel(gearList);
        table.setModel(tableModel);
    }
}
