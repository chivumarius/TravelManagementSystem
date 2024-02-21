package travel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	JPanel panel;
	private final JTextField textField;
	private final JPasswordField passwordField;
	private final JButton b1, b2, b3;

	// Constructor to initialize the login window
	public Login() {
		// Set window title
		setTitle(" Login");

		// Set window size and background color
		setBackground(new Color(255, 255, 204));
		setBounds(550, 250, 700, 400);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);

		// Set Frame to Open in the Center of the Screen at Runtime
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
		setLocation(centerX, centerY);

		// Labels and text fields for username and password
		JLabel l1 = new JLabel("Username : ");
		l1.setBounds(124, 89, 95, 24);
		panel.add(l1);

		JLabel l2 = new JLabel("Password : ");
		l2.setBounds(124, 124, 95, 24);
		panel.add(l2);

		textField = new JTextField();
		textField.setBounds(210, 93, 157, 20);
		panel.add(textField);

		passwordField = new JPasswordField();
		passwordField.setBounds(210, 128, 157, 20);
		panel.add(passwordField);

		// Image icon for login image
		ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i1 = c1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);

		JLabel l6 = new JLabel(i2);
		l6.setBounds(480, 70, 150, 150);
		add(l6);

		// Buttons for login, sign up, and forgot password
		b1 = new JButton("Login");
		b1.addActionListener(this);
		b1.setForeground(new Color(46, 139, 87));
		b1.setBackground(new Color(176, 224, 230));
		b1.setBounds(149, 181, 113, 25);
		panel.add(b1);

		b2 = new JButton("Signup");
		b2.addActionListener(this);
		b2.setForeground(new Color(139, 69, 19));
		b2.setBackground(new Color(255, 235, 205));
		b2.setBounds(289, 181, 113, 25);
		panel.add(b2);

		b3 = new JButton("Forgot Password");
		b3.addActionListener(this);
		b3.setForeground(new Color(205, 92, 92));
		b3.setBackground(new Color(253, 245, 230));
		b3.setBounds(199, 231, 179, 25);
		panel.add(b3);

		// Label for trouble in login
		JLabel l5 = new JLabel("Trouble in Login?");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setForeground(new Color(255, 0, 0));
		l5.setBounds(70, 235, 110, 20);
		panel.add(l5);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBounds(24, 40, 434, 263);
		panel.add(panel2);
	}

	// Method to handle button clicks
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) { // Login button clicked
			login(); // Call login method
		} else if (ae.getSource() == b2) { // Sign up button clicked
			signUp(); // Call sign up method
		} else if (ae.getSource() == b3) { // Forgot password button clicked
			forgotPassword(); // Call forgot password method
		}
	}

	// Method to handle login functionality
	private void login() {
		try {
			DBConnection con = new DBConnection();
			String sql = "select * from account where username=? and password=?";
			PreparedStatement st = con.c.prepareStatement(sql);

			st.setString(1, textField.getText());

			char[] passwordChars = passwordField.getPassword();
			String password = new String(passwordChars);
			st.setString(2, password);

			ResultSet rs = st.executeQuery();
			if (rs.next()) { // If username and password match
				this.setVisible(false);
				new MainScreen(textField.getText()).setVisible(true); // Open the main screen
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Login or Password!"); // Show error message
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	// Method to handle sign up functionality
	private void signUp() {
		setVisible(false); // Hide the login window
		Signup su = new Signup(); // Create a new instance of the Signup class
		su.setVisible(true); // Show the sign-up window
	}

	// Method to handle forgot password functionality
	private void forgotPassword() {
		setVisible(false); // Hide the login window
		ForgotPassword forgot = new ForgotPassword(); // Create a new instance of the ForgotPassword class
		forgot.setVisible(true); // Show the forgot password window
	}

	// Main method to create and display the login window
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}