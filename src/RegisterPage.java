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



public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField usename;
	private JTextField password;
	private JTextField email;
	private JTextField phone;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
    private void saveRegistrationDetailsToFile() {
        try (FileWriter fileWriter = new FileWriter("registeredusers.txt", true)) {
            // Append user details to the file
            fileWriter.write("Name: " + name.getText() + "\n");
            fileWriter.write("Username: " + usename.getText() + "\n");
            fileWriter.write("Email: " + email.getText() + "\n");
            fileWriter.write("Phone: " + phone.getText() + "\n");
            fileWriter.write("Address: " + address.getText() + "\n\n");
            fileWriter.write("--------------------------------------------"+ "\n\n");
            JOptionPane.showMessageDialog(null, "User details saved to file.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error writing to file: " + ex.getMessage());
        }
    }
	
	
	
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(73, 47, 65, 28);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(148, 50, 159, 31);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 101, 104, 28);
		contentPane.add(lblNewLabel_1);
		
		usename = new JTextField();
		usename.setBounds(148, 104, 159, 31);
		contentPane.add(usename);
		usename.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(34, 156, 104, 25);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setBounds(148, 157, 159, 31);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(64, 207, 59, 22);
		contentPane.add(lblNewLabel_3);
		
		email = new JTextField();
		email.setBounds(148, 207, 159, 31);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(58, 261, 65, 28);
		contentPane.add(lblNewLabel_4);
		
		phone = new JTextField();
		phone.setBounds(148, 262, 159, 31);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(46, 311, 77, 22);
		contentPane.add(lblNewLabel_5);
		
		address = new JTextField();
		address.setBounds(148, 311, 159, 31);
		contentPane.add(address);
		address.setColumns(10);
		
		
		//register button
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
			            String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
			            String DB_USER = "root";
			            String DB_PASSWORD = "hamzasql12344321";

			            // Establish the database connection
			            Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

			            // Prepare SQL INSERT query to insert user data into the 'users' table
			            String sql = "INSERT INTO users (name, username, password, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
			            PreparedStatement preparedStatement = conn.prepareStatement(sql);

			            // Set values for the parameters in the SQL query using the user input
			            preparedStatement.setString(1, name.getText());
			            preparedStatement.setString(2, usename.getText());
			            preparedStatement.setString(3, password.getText());
			            preparedStatement.setString(4, email.getText());
			            preparedStatement.setString(5, phone.getText());
			            preparedStatement.setString(6, address.getText());

			            // Execute the query to insert the user data
			            int rowsInserted = preparedStatement.executeUpdate();

			            if (rowsInserted > 0) {
			            	saveRegistrationDetailsToFile();
			         Loginpage lpLoginpage = new Loginpage();
			         lpLoginpage.show();
			         dispose();
				           
			                // Additional actions after successful registration can be added here
			            } else {
			                // Registration failed
			                JOptionPane.showMessageDialog(null, "Registration Failed");
			            }

			            conn.close(); // Close the database connection
			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			        }
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(469, 207, 205, 51);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Become a member of PulseFusion to ensure Fitness");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Vladimir Script", Font.BOLD, 25));
		lblNewLabel_6.setBounds(335, 98, 467, 83);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Already A User? Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginpage LP = new Loginpage();
				LP.show();
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1.setBounds(442, 288, 267, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(RegisterPage.class.getResource("/Images/dark_black_and_red_hd_red_aesthetic.jpg")));
		lblNewLabel_7.setBounds(-625, -167, 1472, 611);
		contentPane.add(lblNewLabel_7);
	}
}
