package travel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

// Class to view customer details
public class ViewCustomers extends JFrame {
	Connection conn = null;
	JPanel contentPane;
	JTable table;
	JLabel lblAvailability;
	JLabel lblCleanStatus;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// Create and display the ViewCustomers frame
				ViewCustomers frame = new ViewCustomers();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ViewCustomers() {
		try {
			// Set up the frame
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(580, 220, 900, 680);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);


			// Set Frame to Open in the Center of the Screen at Runtime
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
			int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
			setLocation(centerX, centerY);


			// Add images to the frame
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
			Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
			ImageIcon i2 = new ImageIcon(i3);
			JLabel l1 = new JLabel(i2);
			l1.setBounds(0, 450, 626, 201);
			add(l1);

			ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
			Image i5 = i4.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
			ImageIcon i6 = new ImageIcon(i5);
			JLabel l2 = new JLabel(i6);
			l2.setBounds(615, 450, 626, 201);
			add(l2);

			// Table to display customer details
			table = new JTable();
			table.setBounds(0, 40, 900, 350);
			contentPane.add(table);

			// Fetch and display customer details in the table
			try {
				DBConnection c = new DBConnection();
				String displayCustomersql = "select * from customer";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			// Back button to go back to the previous screen
			JButton btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(e -> setVisible(false));
			btnNewButton.setBounds(390, 400, 120, 30);
			btnNewButton.setBackground(Color.BLACK);
			btnNewButton.setForeground(Color.WHITE);
			contentPane.add(btnNewButton);

			// Labels for table headers
			lblAvailability = new JLabel("Username");
			lblAvailability.setBounds(10, 15, 69, 14);
			contentPane.add(lblAvailability);

			lblCleanStatus = new JLabel("Id Type");
			lblCleanStatus.setBounds(110, 15, 76, 14);
			contentPane.add(lblCleanStatus);

			lblNewLabel = new JLabel("Number");
			lblNewLabel.setBounds(220, 15, 46, 14);
			contentPane.add(lblNewLabel);

			lblNewLabel_1 = new JLabel("Name");
			lblNewLabel_1.setBounds(320, 15, 76, 14);
			contentPane.add(lblNewLabel_1);

			lblId = new JLabel("Gender");
			lblId.setBounds(420, 15, 90, 14);
			contentPane.add(lblId);

			JLabel l3 = new JLabel("Country");
			l3.setBounds(520, 15, 90, 14);
			contentPane.add(l3);

			JLabel l4 = new JLabel("Address");
			l4.setBounds(620, 15, 90, 14);
			contentPane.add(l4);

			JLabel l5 = new JLabel("Phone");
			l5.setBounds(720, 15, 90, 14);
			contentPane.add(l5);

			JLabel l6 = new JLabel("Email");
			l6.setBounds(820, 15, 90, 14);
			contentPane.add(l6);

			getContentPane().setBackground(Color.WHITE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}