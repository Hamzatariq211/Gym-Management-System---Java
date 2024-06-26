import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddWorkout extends JFrame {

	private JPanel contentPane;
	private static int userID;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkout frame = new AddWorkout(userID);
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
	public AddWorkout(int userID) {
		this.userID = userID;
		System.out.print(userID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 791, 93);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Workout Plan");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(283, 25, 256, 58);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Monday");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(55, 113, 140, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tuesday");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(55, 155, 135, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Wednesday");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(55, 197, 140, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thursday");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(55, 239, 140, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Friday");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(55, 281, 140, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Saturday");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(55, 323, 107, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sunday");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(55, 365, 107, 32);
		contentPane.add(lblNewLabel_7);
		
		
		JComboBox Monday = new JComboBox();
		Monday.setModel(new DefaultComboBoxModel(new String[] {"Chest (Recommended)", "Back", "Shouder", "Arms", "Abdominal", "Leg", "Hip", "Core", "ForeArms + BiTri", "Calfs"}));
		Monday.setBounds(178, 111, 169, 38);
		contentPane.add(Monday);
		
		JComboBox Tuesday = new JComboBox();
		Tuesday.setModel(new DefaultComboBoxModel(new String[] {"Chest", "Back ", "Shouder (Recommended)", "Arms", "Abdominal", "Leg", "Hip", "Core", "ForeArms + BiTri", "Calfs"}));
		Tuesday.setBounds(178, 155, 169, 32);
		contentPane.add(Tuesday);
		
		JComboBox Wednesday = new JComboBox();
		Wednesday.setModel(new DefaultComboBoxModel(new String[] {"Chest", "Back (Recommended)", "Shouder", "Arms", "Abdominal", "Leg", "Hip", "Core", "ForeArms + BiTri", "Calfs"}));
		Wednesday.setBounds(178, 197, 169, 32);
		contentPane.add(Wednesday);
		
		JComboBox Thursday = new JComboBox();
		Thursday.setModel(new DefaultComboBoxModel(new String[] {"Chest", "Back", "Shouder", "Arms", "Abdominal", "Leg", "Hip", "Core (Recommended)", "ForeArms + BiTri", "Calfs"}));
		Thursday.setBounds(178, 239, 169, 32);
		contentPane.add(Thursday);
		
		JComboBox Friday = new JComboBox();
		Friday.setModel(new DefaultComboBoxModel(new String[] {"Chest", "Back", "Shouder", "Arms", "Abdominal", "Leg", "Hip", "Core", "ForeArms + BiTri (Recommended)", "Calfs"}));
		Friday.setBounds(178, 281, 169, 32);
		contentPane.add(Friday);
		
		JComboBox Saturday = new JComboBox();
		Saturday.setModel(new DefaultComboBoxModel(new String[] {"Chest", "Back", "Shouder", "Arms", "Abdominal", "Leg (Recommended)", "Hip", "Core", "ForeArms + BiTri", "Calfs"}));
		Saturday.setBounds(178, 323, 169, 32);
		contentPane.add(Saturday);
		
		JComboBox Sunday = new JComboBox();
		Sunday.setModel(new DefaultComboBoxModel(new String[] {"Chest", "Back", "Shouder", "Arms", "Abdominal", "Leg", "Hip", "Core", "ForeArms + BiTri", "Calfs", "Rest (Recommended)"}));
		Sunday.setBounds(178, 365, 169, 32);
		contentPane.add(Sunday);
		
		
		
		
		
		
		
        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] selectedWorkouts = new String[7];
                selectedWorkouts[0] = (String) Monday.getSelectedItem();
                selectedWorkouts[1] = (String) Tuesday.getSelectedItem();
                selectedWorkouts[2] = (String) Wednesday.getSelectedItem();
                selectedWorkouts[3] = (String) Thursday.getSelectedItem();
                selectedWorkouts[4] = (String) Friday.getSelectedItem();
                selectedWorkouts[5] = (String) Saturday.getSelectedItem();
                selectedWorkouts[6] = (String) Sunday.getSelectedItem();
            

                WorkoutPlanFactory workoutPlanFactory = new WorkoutPlanFactory();
                WorkoutPlan workoutPlan = workoutPlanFactory.createWorkoutPlan(selectedWorkouts);

                DatabaseConnectionWorkoutAdd databaseConnection = DatabaseConnectionWorkoutAdd.getInstance();
                databaseConnection.addWorkoutPlan(userID, workoutPlan);
            }
        });
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(547, 207, 169, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(AddWorkout.class.getResource("/Images/gymdesign_render_Two_collumn_grid_cb1b5850-fa8e-4a7b-a2b3-190c2e45facd.png")));
		lblNewLabel_8.setBounds(0, 85, 791, 332);
		contentPane.add(lblNewLabel_8);
		

	}
}
