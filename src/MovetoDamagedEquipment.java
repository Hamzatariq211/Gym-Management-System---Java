import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovetoDamagedEquipment extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-17,4
	 */
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovetoDamagedEquipment frame = new MovetoDamagedEquipment();
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
	public MovetoDamagedEquipment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 788, 110);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Move To Damaged Equipment");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(200, 21, 425, 56);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Equipment No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(42, 144, 168, 42);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(243, 152, 176, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Move to Damaged ");
		// Inside the actionPerformed method of btnNewButton ActionListener
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get data from text fields
		        int equipmentID = Integer.parseInt(textField.getText());
		        String damageDescription = textField_1.getText();
		        String reportedDate = textField_2.getText();

		        // Assuming you have a DamagedEquipmentDAO instance named damagedEquipmentDAO
		        DamagedEquipmentDAO damagedEquipmentDAO = new DamagedEquipmentDAO();

		        // Move equipment to damaged table and delete from GymEquipment table
		        damagedEquipmentDAO.moveEquipment(equipmentID, damageDescription, reportedDate);

		        // Show a success message using JOptionPane
		        JOptionPane.showMessageDialog(null, "Equipment moved to damaged equipment successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		    }
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(519, 343, 244, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Damage Description");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(42, 215, 206, 42);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(243, 217, 176, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Reported Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(42, 288, 206, 35);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(243, 288, 176, 42);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
