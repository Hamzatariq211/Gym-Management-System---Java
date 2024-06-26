import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EquipmentHandling extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentHandling frame = new EquipmentHandling(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param table 
	 */
	public EquipmentHandling(JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 814, 101);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Manage Equipment");
		lblNewLabel_2.setBounds(298, 26, 244, 48);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(602, 174, -384, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(568, 142, -332, 85);
		contentPane.add(lblNewLabel_1);
		
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(31, 126, 751, 194);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        EquipmentController controller = EquipmentControllerFactory.getEquipmentController();
        controller.displayEquipmentData(table);
        
        JButton btnNewButton = new JButton("Add Item");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddEquipment AE = new AddEquipment();
        		AE.show();
        		dispose();
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(153, 362, 173, 52);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Move To Damaged Equipment");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		MovetoDamagedEquipment MDE = new MovetoDamagedEquipment();
        		MDE.show();
        		dispose();
        		
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.setBounds(419, 362, 289, 52);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(EquipmentHandling.class.getResource("/Images/gym.jpg")));
        lblNewLabel_3.setBounds(0, 101, 814, 373);
        contentPane.add(lblNewLabel_3);
	}
}
