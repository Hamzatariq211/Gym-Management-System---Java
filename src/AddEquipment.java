import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEquipment extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField Equipmentname;
	private JTextField Category;
	private JTextField Manufacturer;
	private JTextField Quantity;
	private JTextField Price;
	private JTextField Description;
	private JTextField Purchasedate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEquipment frame = new AddEquipment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddEquipment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 819, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Equipment");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(295, 25, 240, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(445, 144, 99, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(45, 204, 131, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(445, 204, 99, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Manufacturer");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(45, 256, 131, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Description");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(445, 256, 112, 31);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Equipment Name");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(45, 137, 131, 44);
		contentPane.add(lblNewLabel_7);
		
		Equipmentname = new JTextField();
		Equipmentname.setBounds(186, 152, 131, 19);
		contentPane.add(Equipmentname);
		Equipmentname.setColumns(10);
		
		Category = new JTextField();
		Category.setBounds(186, 212, 131, 19);
		contentPane.add(Category);
		Category.setColumns(10);
		
		Manufacturer = new JTextField();
		Manufacturer.setBounds(186, 264, 131, 19);
		contentPane.add(Manufacturer);
		Manufacturer.setColumns(10);
		
		Quantity = new JTextField();
		Quantity.setBounds(554, 152, 152, 19);
		contentPane.add(Quantity);
		Quantity.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(554, 204, 152, 19);
		contentPane.add(Price);
		Price.setColumns(10);
		
		Description = new JTextField();
		Description.setBounds(554, 264, 152, 19);
		contentPane.add(Description);
		Description.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String equipmentName = Equipmentname.getText();
		        if (!equipmentName.isEmpty()) {
		        	
		            String category = Category.getText();
		            String manufacturer = Manufacturer.getText();
		            int quantity = Integer.parseInt(Quantity.getText());
		            double price = Double.parseDouble(Price.getText());
		            String PurchaseDate = Purchasedate.getText();
		            String description = Description.getText();

		            Equipment equipment = new Equipment(equipmentName, category, manufacturer, quantity, price,PurchaseDate, description);
		            EquipmentDAO equipmentDAO = new EquipmentDAO();
		            equipmentDAO.addEquipment(equipment);

		            // Clear text fields after adding equipment (if needed)
		            Equipmentname.setText("");
		            Category.setText("");
		            Manufacturer.setText("");
		            Quantity.setText("");
		            Price.setText("");
		            Description.setText("");
		        } else {
		            // Show an error message or handle the case when EquipmentName is empty
		        }
		    }
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(556, 320, 164, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Purchase Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 320, 112, 31);
		contentPane.add(lblNewLabel_1);
		
		Purchasedate = new JTextField();
		Purchasedate.setBounds(182, 326, 142, 25);
		contentPane.add(Purchasedate);
		Purchasedate.setColumns(10);
	}
}
