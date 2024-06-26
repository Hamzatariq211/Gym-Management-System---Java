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
import javax.swing.ImageIcon;

public class AddPayments extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField amount;
	private JTextField paydate;
	private JTextField Paymonth;
	private JTextField Description;
	private JTextField Userid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPayments frame = new AddPayments();
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
	public AddPayments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 725, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Payments");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(282, 24, 201, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserId");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(65, 140, 81, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(65, 186, 104, 54);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PayDate");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(65, 250, 105, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PayMonth");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(65, 306, 127, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Description");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(66, 363, 104, 47);
		contentPane.add(lblNewLabel_5);
		
		amount = new JTextField();
		amount.setBounds(194, 208, 131, 19);
		contentPane.add(amount);
		amount.setColumns(10);
		
		paydate = new JTextField();
		paydate.setBounds(195, 263, 130, 19);
		contentPane.add(paydate);
		paydate.setColumns(10);
		
		Paymonth = new JTextField();
		Paymonth.setBounds(194, 324, 131, 19);
		contentPane.add(Paymonth);
		Paymonth.setColumns(10);
		
		Description = new JTextField();
		Description.setBounds(198, 381, 127, 19);
		contentPane.add(Description);
		Description.setColumns(10);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                // Get values from text fields
	                String userIdValue = Userid.getText();
	                double amountValue = Double.parseDouble(amount.getText());
	                String payDateValue = paydate.getText();
	                String payMonthValue = Paymonth.getText();
	                String descriptionValue = Description.getText();

	                // Create Payment instance using Factory Method
	                Payment payment = new Payment(userIdValue, amountValue, payDateValue, payMonthValue, descriptionValue);
	            }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(454, 186, 146, 54);
		contentPane.add(btnNewButton);
		
		Userid = new JTextField();
		Userid.setBounds(189, 153, 136, 19);
		contentPane.add(Userid);
		Userid.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOPT aOpt = new AdminOPT();
			aOpt.show();
			dispose();
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(454, 289, 146, 54);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(AddPayments.class.getResource("/Images/gym-with-red-lights-black-gym-with-black-gym-equipment_911201-3357.png")));
		lblNewLabel_6.setBounds(48, 97, 640, 361);
		contentPane.add(lblNewLabel_6);
	}
}
