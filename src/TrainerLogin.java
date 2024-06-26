import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerLogin extends JFrame {
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private TrainerFactory trainerFactory;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrainerLogin frame = new TrainerLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TrainerLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 820, 490);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        trainerFactory = TrainerFactory.getInstance(); // Initialize TrainerFactory

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUsername.setBounds(184, 163, 112, 27);
        contentPane.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(324, 163, 185, 35);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPassword.setBounds(184, 210, 112, 20);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(324, 208, 185, 34);
        contentPane.add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform login authentication here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Get the Trainer object based on the entered username
                Trainer trainer = trainerFactory.getTrainerByUsername(username);

                if (trainer != null && password.equals(trainer.getPassword())) {
                    // Successful login
                    // Add your logic here to open a new frame or perform actions after login
                	
                    JOptionPane.showMessageDialog(contentPane, "Login Successful");
                    TrainerOPT trainerOPT = new TrainerOPT();
                    trainerOPT.show();
                    dispose();
                    
                } else {
                    // Invalid credentials
                    JOptionPane.showMessageDialog(contentPane, "Invalid username or password");
                }
            }
        });
        btnLogin.setBounds(314, 292, 208, 45);
        contentPane.add(btnLogin);
        
        panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(0, 0, 806, 85);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblNewLabel = new JLabel("Trainer Login");
        lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(329, 28, 184, 47);
        panel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel_1.setIcon(new ImageIcon(TrainerLogin.class.getResource("/Images/trainer-for-gym-motivation-77dc2m6jddloishf.jpg")));
        lblNewLabel_1.setBounds(-595, 72, 1417, 1006);
        contentPane.add(lblNewLabel_1);
    }
}
