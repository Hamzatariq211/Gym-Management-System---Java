import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends JFrame {
	private double calculatedBMI;
    private JPanel contentPane;
    private final JPanel panel = new JPanel();
    private JTextField textFieldHeight;
    private JTextField textFieldWeight;
    private JLabel lblResult;
    private JRadioButton rdbtnMan;
    private JRadioButton rdbtnWoman;
    private JFreeChart chart;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BMI frame = new BMI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private ChartPanel createChartPanel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(20, "Range", "Underweight (Men)");
        dataset.addValue(25, "Range", "Normal (Men)");
        dataset.addValue(30, "Range", "Overweight (Men)");
        dataset.addValue(40, "Range", "Obese (Men)");

        dataset.addValue(19, "Range", "Underweight (Women)");
        dataset.addValue(24, "Range", "Normal (Women)");
        dataset.addValue(29, "Range", "Overweight (Women)");
        dataset.addValue(39, "Range", "Obese (Women)");

        chart = ChartFactory.createBarChart("BMI Ranges", "", "", dataset); // Initialize the chart object
        return new ChartPanel(chart);
    }
    
    
    
    
    public BMI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 912, 612);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel.setBounds(0, 0, 901, 582);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblHeight = new JLabel("Height (m):");
        lblHeight.setForeground(new Color(255, 255, 255));
        lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHeight.setBounds(82, 110, 126, 29);
        panel.add(lblHeight);

        JLabel lblWeight = new JLabel("Weight (kg):");
        lblWeight.setForeground(new Color(255, 255, 255));
        lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblWeight.setBounds(82, 138, 142, 23);
        panel.add(lblWeight);

        textFieldHeight = new JTextField();
        textFieldHeight.setBounds(234, 113, 120, 24);
        panel.add(textFieldHeight);
        textFieldHeight.setColumns(10);

        textFieldWeight = new JTextField();
        textFieldWeight.setBounds(234, 142, 120, 24);
        panel.add(textFieldWeight);
        textFieldWeight.setColumns(10);

        JButton btnCalculate = new JButton("Calculate BMI");
        btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
        btnCalculate.setBounds(637, 120, 194, 42);
        panel.add(btnCalculate);

        lblResult = new JLabel("");
        lblResult.setForeground(new Color(255, 0, 0));
        lblResult.setFont(new Font("Elephant", Font.PLAIN, 15));
        lblResult.setBounds(74, 176, 318, 29);
        panel.add(lblResult);

        rdbtnMan = new JRadioButton("Male");
        rdbtnMan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnMan.setSelected(true);
        rdbtnMan.setBounds(424, 102, 134, 42);
        panel.add(rdbtnMan);

        rdbtnWoman = new JRadioButton("Female");
        rdbtnWoman.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnWoman.setBounds(426, 160, 134, 42);
        panel.add(rdbtnWoman);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rdbtnMan);
        genderGroup.add(rdbtnWoman);

        // Create the chart panel
        ChartPanel chartPanel = createChartPanel();
        chartPanel.setPreferredSize(new Dimension(600, 350));
        panel.add(chartPanel);
        chartPanel.setBounds(71, 212, 730, 350);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 901, 85);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("BMI CALCULATOR");
        lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(333, 10, 242, 65);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(BMI.class.getResource("/Images/gym.jpg")));
        lblNewLabel_1.setBounds(0, 74, 901, 508);
        panel.add(lblNewLabel_1);
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(textFieldHeight.getText());
            double weight = Double.parseDouble(textFieldWeight.getText());

            // Check for valid height and weight inputs
            if (height <= 0 || weight <= 0) {
                lblResult.setText("Please enter valid positive numbers for height and weight.");
                return;
            }

            // Calculate BMI
            double bmi = weight / (height * height);

            // Preserve the calculated BMI value
            calculatedBMI = bmi;

            // Determine the BMI range based on gender
            String bmiRange;
            if (rdbtnMan.isSelected()) {
                bmiRange = determineBmiRangeForMen(bmi);
            } else {
                bmiRange = determineBmiRangeForWomen(bmi);
            }

            // Display the result
            String result = String.format("Your BMI is: %.2f - %s", bmi, bmiRange);
            lblResult.setText(result);

            // Update the chart
            updateChart(bmi, rdbtnMan.isSelected());
        } catch (NumberFormatException ex) {
            lblResult.setText("Please enter valid numbers.");
        }
    }

    private void updateChart(double bmi, boolean isMan) {
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) chart.getCategoryPlot().getDataset();

        if (isMan) {
            dataset.addValue(20, "Range", "Underweight (Men)");
            dataset.addValue(25, "Range", "Normal (Men)");
            dataset.addValue(30, "Range", "Overweight (Men)");
            dataset.addValue(40, "Range", "Obese (Men)");
        } else {
            dataset.addValue(19, "Range", "Underweight (Women)");
            dataset.addValue(24, "Range", "Normal (Women)");
            dataset.addValue(29, "Range", "Overweight (Women)");
            dataset.addValue(39, "Range", "Obese (Women)");
        }

        dataset.addValue(bmi, "BMI", "Your BMI");

        // Notify the chart that the dataset has changed
        chart.fireChartChanged();
    }

    // Sample BMI ranges (adjust these ranges according to actual reference values)
    private String determineBmiRangeForMen(double bmi) {
        if (bmi < 20) {
            return "Underweight";
        } else if (bmi >= 20 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Sample BMI ranges (adjust these ranges according to actual reference values)
    private String determineBmiRangeForWomen(double bmi) {
        if (bmi < 19) {
            return "Underweight";
        } else if (bmi >= 19 && bmi < 24) {
            return "Normal";
        } else if (bmi >= 24 && bmi < 29) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
