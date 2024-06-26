import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.ImageIcon;

public class workoutAnalysis extends JFrame {

    static String monday; static String tuesday; static String wednesday; static String thursday; static String friday;
    static String saturday; static String sunday;
    
    private JPanel contentPane;
    private final JPanel panel = new JPanel();
    private final JPanel panel_1 = new JPanel();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    workoutAnalysis frame = new workoutAnalysis(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public workoutAnalysis(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 991, 598);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 977, 86);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_8 = new JLabel("Analysis");
        lblNewLabel_8.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblNewLabel_8.setForeground(new Color(255, 255, 255));
        lblNewLabel_8.setBounds(423, 10, 118, 66);
        panel_1.add(lblNewLabel_8);
        
        JLabel lblMonday = new JLabel("Monday: " + monday);
        lblMonday.setForeground(new Color(255, 255, 255));
        lblMonday.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMonday.setBounds(10, 112, 243, 49);
        contentPane.add(lblMonday);
        
        JLabel lblTuesday = new JLabel("Tuesday: " + tuesday);
        lblTuesday.setForeground(new Color(255, 255, 255));
        lblTuesday.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTuesday.setBounds(10, 171, 243, 32);
        contentPane.add(lblTuesday);
        
        JLabel lblWednesday = new JLabel("Wednesday: " + wednesday);
        lblWednesday.setForeground(new Color(255, 255, 255));
        lblWednesday.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblWednesday.setBounds(10, 213, 243, 45);
        contentPane.add(lblWednesday);
        
        JLabel lblThursday = new JLabel("Thursday: " + thursday);
        lblThursday.setForeground(new Color(255, 255, 255));
        lblThursday.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblThursday.setBounds(10, 268, 243, 43);
        contentPane.add(lblThursday);
        
        JLabel lblFriday = new JLabel("Friday: " + friday);
        lblFriday.setForeground(new Color(255, 255, 255));
        lblFriday.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblFriday.setBounds(10, 321, 243, 45);
        contentPane.add(lblFriday);
        
        JLabel lblSaturday = new JLabel("Saturday: " + saturday);
        lblSaturday.setForeground(new Color(255, 255, 255));
        lblSaturday.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSaturday.setBounds(10, 376, 243, 43);
        contentPane.add(lblSaturday);
        
        JLabel lblSunday = new JLabel("Sunday: " + sunday);
        lblSunday.setForeground(new Color(255, 255, 255));
        lblSunday.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSunday.setBounds(10, 429, 243, 51);
        contentPane.add(lblSunday);

        // Create dataset for the muscle groups with random intensity values
     // Create dataset for the muscle groups with random intensity values
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Random random = new Random();

        // Adding values for the workout days
        dataset.addValue(monday.equalsIgnoreCase("Rest") ? 0 : random.nextInt(10) + 1, "Muscle Groups", "Monday");
        dataset.addValue(tuesday.equalsIgnoreCase("Rest") ? 0 : random.nextInt(10) + 1, "Muscle Groups", "Tuesday");
        dataset.addValue(wednesday.equalsIgnoreCase("Rest") ? 0 : random.nextInt(10) + 1, "Muscle Groups", "Wednesday");
        dataset.addValue(thursday.equalsIgnoreCase("Rest") ? 0 : random.nextInt(10) + 1, "Muscle Groups", "Thursday");
        dataset.addValue(friday.equalsIgnoreCase("Rest") ? 0 : random.nextInt(10) + 1, "Muscle Groups", "Friday");
        dataset.addValue(saturday.equalsIgnoreCase("Rest") ? 0 : random.nextInt(10) + 1, "Muscle Groups", "Saturday");
        dataset.addValue(sunday.equalsIgnoreCase("Rest") ? 0 : random.nextInt(10) + 1, "Muscle Groups", "Sunday");


        // Create a bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Muscle Groups Analysis", // Chart title
                "Days", // X-Axis Label
                "Intensity", // Y-Axis Label
                dataset // Dataset
        );

        // Create a panel to display the chart
        JPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setBounds(300, 112, 660, 400); // Set bounds for chart panel
        contentPane.add(chartPanel); // Add chart panel to the content pane
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TrainerOPT trainerOPT = new TrainerOPT();
        		trainerOPT.show();
        	    dispose();
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(57, 492, 147, 43);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(workoutAnalysis.class.getResource("/Images/big-data-blue-wave-visualization-futuristic-infographic-information-aesthetic-design-visual-data-complexity-complex-business-chart-analytics-social-network-representation-abstract-data-graph_1217-6234 (1).png")));
        lblNewLabel.setBounds(0, 23, 977, 575);
        contentPane.add(lblNewLabel);

        // Back button code remains unchanged
    }
}
