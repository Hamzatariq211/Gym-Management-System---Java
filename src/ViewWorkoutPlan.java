import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ViewWorkoutPlan extends JFrame {
    private static int userID;
    private JPanel contentPane;
    private final JPanel panel = new JPanel();
    private final JLabel lblNewLabel = new JLabel("New label");
    private final JLabel lblNewLabel_1 = new JLabel("New label");
    private final JLabel lblNewLabel_2 = new JLabel("New label");
    private final JLabel lblNewLabel_3 = new JLabel("New label");
    private final JLabel lblNewLabel_4 = new JLabel("New label");
    private final JLabel lblNewLabel_5 = new JLabel("New label");
    private final JLabel lblNewLabel_6 = new JLabel("New label");
    private final JButton btnNewButton = new JButton("Back");
    private final JLabel lblNewLabel_7 = new JLabel("");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewWorkoutPlan frame = new ViewWorkoutPlan(userID);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    private void fetchAndSetWorkoutDetails() {
        ViewWorkoutDBCon dbConnection = ViewWorkoutDBCon.getInstance();
        WorkoutPlanFactory workoutPlanFactory = new WorkoutPlanFactory();

        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM workout_plan WHERE user_id = ?");
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String[] workoutDetails = new String[7];
                workoutDetails[0] = resultSet.getString("monday");
                workoutDetails[1] = resultSet.getString("tuesday");
                workoutDetails[2] = resultSet.getString("wednesday");
                workoutDetails[3] = resultSet.getString("thursday");
                workoutDetails[4] = resultSet.getString("friday");
                workoutDetails[5] = resultSet.getString("saturday");
                workoutDetails[6] = resultSet.getString("sunday");
 
                WorkoutPlan workoutPlan = workoutPlanFactory.createWorkoutPlan(workoutDetails);
                lblNewLabel.setText("Monday: " + workoutPlan.getMonday());
                lblNewLabel_1.setText("Tuesday: " + workoutPlan.getTuesday());
                lblNewLabel_2.setText("Wednesday: " + workoutPlan.getWednesday());
                lblNewLabel_3.setText("Thursday: " + workoutPlan.getThursday());
                lblNewLabel_4.setText("Friday: " + workoutPlan.getFriday());
                lblNewLabel_5.setText("Saturday: " + workoutPlan.getSaturday());
                lblNewLabel_6.setText("Sunday: " + workoutPlan.getSunday());
            }


            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }
    
    
    
    

    public ViewWorkoutPlan(int userID) {
        this.userID = userID;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 870, 501);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(0, 0, 856, 89);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("View Workout Plan");
        lblTitle.setBounds(311, 10, 262, 74);
        panel.add(lblTitle);
        lblTitle.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblTitle.setForeground(new Color(255, 255, 255));
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 23));
        lblNewLabel.setBounds(248, 99, 228, 40);
        
        contentPane.add(lblNewLabel);
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 23));
        lblNewLabel_1.setBounds(248, 149, 228, 40);
        
        contentPane.add(lblNewLabel_1);
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setFont(new Font("Monotype Corsiva", Font.BOLD, 23));
        lblNewLabel_2.setBounds(248, 199, 228, 40);
        
        contentPane.add(lblNewLabel_2);
        lblNewLabel_3.setForeground(new Color(255, 0, 0));
        lblNewLabel_3.setFont(new Font("Monotype Corsiva", Font.BOLD, 23));
        lblNewLabel_3.setBounds(248, 249, 228, 33);
        
        contentPane.add(lblNewLabel_3);
        lblNewLabel_4.setForeground(new Color(255, 0, 0));
        lblNewLabel_4.setFont(new Font("Monotype Corsiva", Font.BOLD, 23));
        lblNewLabel_4.setBounds(248, 292, 228, 40);
        
        contentPane.add(lblNewLabel_4);
        lblNewLabel_5.setForeground(new Color(255, 0, 0));
        lblNewLabel_5.setFont(new Font("Monotype Corsiva", Font.BOLD, 23));
        lblNewLabel_5.setBounds(248, 342, 228, 40);
        
        contentPane.add(lblNewLabel_5);
        lblNewLabel_6.setForeground(new Color(255, 0, 0));
        lblNewLabel_6.setFont(new Font("Monotype Corsiva", Font.BOLD, 23));
        lblNewLabel_6.setBounds(248, 392, 228, 40);
        
        contentPane.add(lblNewLabel_6);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		WorkoutOPT workoutOPT = new WorkoutOPT(userID);
        		workoutOPT.show();
        		dispose();
        		
        		
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnNewButton.setBounds(675, 392, 171, 50);
        
        contentPane.add(btnNewButton);
        lblNewLabel_7.setIcon(new ImageIcon(ViewWorkoutPlan.class.getResource("/Images/Office-Gyms-Blog4.jpg")));
        lblNewLabel_7.setBounds(0, 87, 856, 377);
        
        contentPane.add(lblNewLabel_7);

        // Initialize other JLabels and set their bounds similarly...

        fetchAndSetWorkoutDetails();
    }


}