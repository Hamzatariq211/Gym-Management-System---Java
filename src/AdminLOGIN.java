import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.sql.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;




public class AdminLOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLOGIN frame = new AdminLOGIN();
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
	public AdminLOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 804, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setBounds(309, 20, 181, 48);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(198, 147, 92, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(198, 224, 92, 36);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(311, 153, 181, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 228, 181, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(309, 370, 127, -46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
	            String DB_USER = "root";
	            String DB_PASSWORD = "hamzasql12344321";
			     
		                String username = textField.getText();
		                String password = textField_1.getText();

		                try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
		                    String sql = "SELECT * FROM Admins WHERE Username = ? AND Password = ?";
		                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
		                    preparedStatement.setString(1, username);
		                    preparedStatement.setString(2, password);

		                    ResultSet resultSet = preparedStatement.executeQuery();

		                    if (resultSet.next()) {

		                    	 JOptionPane.showMessageDialog(null, "Login successful");
		                       AdminOPT aOpt = new AdminOPT();
		                       aOpt.show();
		                       dispose();
		                       
		                    	 
		                    	 
		                    } else {

		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            
				
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(319, 306, 160, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AdminLOGIN.class.getResource("/Images/photo-1593079831268-3381b0db4a77.png")));
		lblNewLabel_3.setBounds(0, 86, 804, 387);
		contentPane.add(lblNewLabel_3);
	}
}
