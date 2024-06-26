import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.*;
import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.IVideoPicture;


public class Login_Register_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Register_admin frame = new Login_Register_admin();
	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	
	
	
	
	public Login_Register_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Move to Login Page
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Loginpage lp = new Loginpage();
				lp.show();
				
				dispose();
				
			}
		});
		btnNewButton.setBounds(282, 189, 192, 41);
		contentPane.add(btnNewButton);
		
		//Move To Register
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage rp = new RegisterPage();
				rp.show();
				
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(282, 249, 192, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Management");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLOGIN AL = new AdminLOGIN();
				AL.show();
				dispose();
				
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(282, 125, 192, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Trainer");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainerLogin trainerLogin = new TrainerLogin();
				trainerLogin.show();
				dispose();
				
				
				
			}
		});
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(282, 318, 192, 41);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 820, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PulseFusion Fitness");
		lblNewLabel.setBounds(204, 21, 321, 48);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login_Register_admin.class.getResource("/Images/6833079d2c591dd2f84f053533a8fca1.jpg")));
		lblNewLabel_1.setBounds(0, 88, 730, 339);
		contentPane.add(lblNewLabel_1);
		
		JLabel Video = new JLabel("New label");
		Video.setBounds(59, 267, 130, 53);
		contentPane.add(Video);
		
		
	
	}
}
