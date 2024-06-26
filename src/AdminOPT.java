import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminOPT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOPT frame = new AdminOPT();
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
	public AdminOPT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 915, 92);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN CONTROLS");
		lblNewLabel.setBounds(341, 26, 247, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		
		JButton btnNewButton = new JButton("Attendance");
		btnNewButton.setBounds(75, 141, 138, 43);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckIn checkIn = new CheckIn();
				checkIn.show();
				dispose();
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Track Attendance");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrackAttendence TA = new TrackAttendence();
				TA.show();
				dispose();
				
				
				
			}
		});
		btnNewButton_1.setBounds(350, 141, 192, 43);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Equipment handling");
		btnNewButton_2.setBounds(659, 140, 192, 45);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EquipmentHandling EH = new EquipmentHandling(null);
				EH.show();
				dispose();
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Payments");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPayments ap= new AddPayments();
				ap.show();
				dispose();
				
				
			}
		});
		btnNewButton_3.setBounds(187, 270, 192, 43);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Handle Payments");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HandlePayments HP = new HandlePayments();
				HP.show();
				dispose();
			}
		});
		btnNewButton_4.setBounds(539, 270, 210, 43);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminOPT.class.getResource("/Images/red_and_black_aesthetic_hd_red_aesthetic.jpg")));
		lblNewLabel_1.setBounds(-572, 0, 1535, 465);
		contentPane.add(lblNewLabel_1);
	}
}
