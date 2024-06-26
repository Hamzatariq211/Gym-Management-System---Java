import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import javax.swing.JPasswordField;


public class Loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
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
	
    private void saveCredentialsToFile() {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        // Create a FileWriter object to write to a file named "credentials.txt"
        try (FileWriter fileWriter = new FileWriter("credentials.txt")) {
            // Write the entered username and password to the file
            fileWriter.write("Username: " + enteredUsername + "\n");
            fileWriter.write("Password: " + enteredPassword + "\n");
            fileWriter.write("------------------------------------" + "\n");
            JOptionPane.showMessageDialog(null, "Username and password saved to file.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error writing to file: " + ex.getMessage());
        }
    }
	
	
	
	
	
	public Loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(187, 126, 101, 42);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(298, 129, 221, 42);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(187, 214, 96, 26);
		contentPane.add(lblNewLabel_1);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(298, 209, 221, 42);
		contentPane.add(password);
		password.setColumns(10);
		
		
		
		
		
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {
		            String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
		            String DB_USER = "root";
		            String DB_PASSWORD = "hamzasql12344321";

		            // Establish the database connection
		            Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

		            // Prepare SQL query to check if user exists with given credentials
		            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		            PreparedStatement preparedStatement = conn.prepareStatement(sql);
		            preparedStatement.setString(1, username.getText());
		            preparedStatement.setString(2, password.getText());

		            // Execute the query
		            ResultSet resultSet = preparedStatement.executeQuery();

		            if (resultSet.next()) {
		            	 int userID = resultSet.getInt("id");
		            	saveCredentialsToFile();
		            	 UserPage up = new UserPage(userID); 
						up.show();
						
						dispose();
		                
		                
		            } else {
		                // No user found with provided credentials
		                JOptionPane.showMessageDialog(null, "Invalid username or password. Login Failed");
		            }

		            conn.close(); // Close the database connection
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		        }
		    
				
				
				
				
				
				
				
				
				
				
				
	}
				
		}
			
				);
		
		
		
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(233, 306, 168, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(411, 306, 168, 37);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 820, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" LOG IN TO ENSURE FITNESS");
		lblNewLabel_2.setBounds(214, 10, 390, 48);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_2.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		
		JButton btnNewButton_2 = new JButton("NOT A USER? SIGN IN!");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage rPage = new RegisterPage();
				rPage.show();
				dispose();
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(267, 353, 272, 37);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Loginpage.class.getResource("/Images/dark_black_and_red_hd_red_aesthetic.jpg")));
		lblNewLabel_3.setBounds(-512, -199, 1445, 641);
		contentPane.add(lblNewLabel_3);
	}
}
