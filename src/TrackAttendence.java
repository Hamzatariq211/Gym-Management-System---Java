import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrackAttendence extends JFrame {

    private JPanel contentPane;
    private CheckInDataFactory dataFactory;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrackAttendence frame = new TrackAttendence();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TrackAttendence() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 901, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTable table = new JTable();
        table.setBounds(1, 1, 698, 0);
        contentPane.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(99, 104, 700, 214);
        contentPane.add(scrollPane);

        try {
            dataFactory = new CheckInDataFactory();
            dataFactory.populateTable(table);
            
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0, 0, 0));
            panel.setBounds(0, 0, 912, 69);
            contentPane.add(panel);
            panel.setLayout(null);
            
            JLabel lblNewLabel = new JLabel("Track Attendance");
            lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
            lblNewLabel.setForeground(new Color(255, 255, 255));
            lblNewLabel.setBounds(349, 20, 233, 39);
            panel.add(lblNewLabel);
            
            JButton btnNewButton = new JButton("Back");
            btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		AdminOPT aoAdminOPT = new AdminOPT();
            		aoAdminOPT.show();
            		dispose();
            	}
            });
            btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnNewButton.setBounds(386, 362, 155, 43);
            contentPane.add(btnNewButton);
            
            JLabel lblNewLabel_1 = new JLabel("");
            lblNewLabel_1.setIcon(new ImageIcon(TrackAttendence.class.getResource("/Images/maxresdefault.jpg")));
            lblNewLabel_1.setBounds(0, 67, 887, 390);
            contentPane.add(lblNewLabel_1);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as required (e.g., show an error message)
        }
    }
}
