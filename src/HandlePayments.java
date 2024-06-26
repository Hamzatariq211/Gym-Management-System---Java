import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HandlePayments extends JFrame {
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HandlePayments frame = new HandlePayments();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HandlePayments() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 834, 502);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(0, 0, 820, 81);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Handle Payments");
        lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(284, 22, 226, 49);
        panel.add(lblNewLabel);

        // Get data from the database using PaymentDAO
        List<SinglePayment> payments = PaymentDAO.getAllPayments();

        // Convert List<SinglePayment> to a 2D array for table data
        Object[][] data = new Object[payments.size()][6];
        for (int i = 0; i < payments.size(); i++) {
            SinglePayment payment = payments.get(i);
            data[i] = new Object[]{
                payment.getPaymentID(),
                payment.getUserID(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getPaymonth(),
                payment.getDescription()
            };
        }

        // Column names
        String[] columnNames = {"PaymentID", "UserID", "Amount", "PaymentDate", "Paymonth", "Description"};

        // Create JTable with data
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 91, 800, 254);
        contentPane.add(scrollPane);
        
        JButton btnNewButton = new JButton("Add Payments");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddPayments ap = new AddPayments();
        		ap.show();
        		dispose();
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(172, 374, 165, 43);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AdminOPT aOpt = new AdminOPT();
        		aOpt.show();
        		dispose();
        		
        		
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(457, 374, 150, 43);
        contentPane.add(btnNewButton_1);
    }
}
