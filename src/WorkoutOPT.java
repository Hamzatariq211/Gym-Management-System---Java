import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkoutOPT extends JFrame {

	private JPanel contentPane;
	private static int userID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkoutOPT frame = new WorkoutOPT(userID);
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
	public WorkoutOPT(int userID) {
		this.userID = userID;
		System.out.print(userID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 905, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Workout Options");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(326, 24, 261, 81);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Workout Plan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkout aWorkout = new AddWorkout(userID);
				aWorkout.show();
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(206, 214, 198, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Workout Plan");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWorkoutPlan viewWorkoutPlan = new ViewWorkoutPlan(userID);
				viewWorkoutPlan.show();
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(522, 214, 198, 64);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(WorkoutOPT.class.getResource("/Images/red_and_black_aesthetic_hd_red_aesthetic.jpg")));
		lblNewLabel_1.setBounds(-625, -46, 1530, 495);
		contentPane.add(lblNewLabel_1);
	}

}
