package travel;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewPackage extends JFrame {
	JPanel contentPane;
	Choice c1;

	// Main method to launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// Create and display the frame
				ViewPackage frame = new ViewPackage("");
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// Constructor to initialize the frame
	public ViewPackage(String username) {
		// Frame properties
		setBounds(580, 220, 850, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Set Frame to Open in the Center of the Screen at Runtime
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
		setLocation(centerX, centerY);

		// Add background image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel la1 = new JLabel(i2);
		la1.setBounds(450, 40, 350, 350);
		add(la1);

		// Label to display package details title
		JLabel lblName = new JLabel("View Package Details");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(88, 11, 350, 53);
		contentPane.add(lblName);

		// Label for displaying username
		JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);

		// Label to display username fetched from the database
		JLabel l1 = new JLabel();
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);

		// Label for displaying package name
		JLabel lblId = new JLabel("Package :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

		// Label to display package name fetched from the database
		JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);

		// Label for displaying number of persons
		JLabel lb2 = new JLabel("Number of Persons :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);

		// Label to display number of persons fetched from the database
		JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);

		// Other labels for displaying package details
		JLabel lblName_1 = new JLabel("ID :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);

		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

		JLabel lblGender = new JLabel("Number :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);

		JLabel l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);

		JLabel lblCountry = new JLabel("Phone :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);

		JLabel l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);

		JLabel lblReserveRoomNumber = new JLabel("Price :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);

		JLabel l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);

		// Fetch package details from the database and display them
		DBConnection c = new DBConnection();
		try {
			ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '" + username + "'");
			while (rs.next()) {
				l1.setText(rs.getString(1)); // Set username
				l2.setText(rs.getString(2)); // Set package name
				l3.setText(rs.getString(3)); // Set number of persons
				l4.setText(rs.getString(4)); // Set ID
				l5.setText(rs.getString(5)); // Set number
				l6.setText(rs.getString(6)); // Set phone
				l7.setText(rs.getString(7)); // Set price
			}
			rs.close();
		} catch (SQLException e) {
			// Throw a runtime exception if SQL error occurs
			throw new RuntimeException(e);
		}

		// Button to go back
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(e -> setVisible(false)); // Hide the frame when clicked
		btnExit.setBounds(160, 350, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Set background color of the frame
		getContentPane().setBackground(Color.WHITE);
	}
}