import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class CheckIn extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckIn frame = new CheckIn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public class CheckInController {

        String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
        String DB_USER = "root";
        String DB_PASSWORD = "hamzasql12344321";

        public void addAttendance(int userID) {
            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
                String sql = "INSERT INTO CheckIn (UserID, UserName) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, userID);
                preparedStatement.setString(2, getUsernameFromUserID(userID));
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        public String getUsernameFromUserID(int userID) {
            String username = null;

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT username FROM users WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, userID);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    username = resultSet.getString("username");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return username;
        }
    }

    public CheckIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 781, 457);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 777, 76);
        panel.setBackground(new Color(0, 0, 0));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Add Attendance");
        lblNewLabel_1.setBounds(292, 10, 226, 60);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(245, 255, 250));
        lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));

        textField = new JTextField();
        textField.setBounds(304, 159, 173, 32);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("User ID");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(218, 155, 76, 32);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int userID = Integer.parseInt(textField.getText());
                CheckInController ccont = new CheckInController();
                ccont.addAttendance(userID);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(330, 227, 131, 38);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminOPT aOpt = new AdminOPT();
                aOpt.show();
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.setBounds(614, 345, 114, 45);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel_2.setIcon(new ImageIcon(CheckIn.class.getResource("/Images/red_and_black_aesthetic_hd_red_aesthetic.jpg")));
        lblNewLabel_2.setBounds(-185, 72, 962, 348);
        contentPane.add(lblNewLabel_2);
    }
}
