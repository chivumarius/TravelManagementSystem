package travel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Signup extends JFrame implements ActionListener {

	// Panel for the content
	JPanel contentPane;

	// Text fields for user input
	private final JTextField textField;
	private final JTextField textField_1;
	private final JTextField textField_2;
	private final JTextField textField_3;

	// Buttons for actions
	private final JButton b1;
	private final JButton b2;

	// ComboBox for selecting security questions
	private final JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Signup().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Signup() {

		// Set window title
		setTitle(" Signup");

		// Set frame properties
		setBounds(600, 250, 700, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		// Set Frame to Open in the Center of the Screen at Runtime
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
		setLocation(centerX, centerY);

		// Labels for user input fields
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(99, 86, 92, 26);
		contentPane.add(lblUsername);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(99, 123, 92, 26);
		contentPane.add(lblName);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(99, 160, 92, 26);
		contentPane.add(lblPassword);

		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setForeground(Color.DARK_GRAY);
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(99, 234, 92, 26);
		contentPane.add(lblAnswer);

		JLabel lblSecurityQuestion = new JLabel("Security Question :");
		lblSecurityQuestion.setForeground(Color.DARK_GRAY);
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecurityQuestion.setBounds(99, 197, 140, 26);
		contentPane.add(lblSecurityQuestion);

		// ComboBox for selecting security questions
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Your NickName?", "Your Lucky Number?",
				"Your child SuperHero?", "Your childhood Name ?" }));
		comboBox.setBounds(265, 202, 148, 20);
		contentPane.add(comboBox);

		// ImageIcon for visual representation
		ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel l6 = new JLabel(i2);
		l6.setBounds(460, 70, 200, 200);
		add(l6);

		// Text fields for user input
		textField = new JTextField();
		textField.setBounds(265, 91, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(265, 128, 148, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(265, 165, 148, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(265, 239, 148, 20);
		contentPane.add(textField_3);

		// Buttons for actions
		b1 = new JButton("Create");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 13));
		b1.setBounds(140, 289, 100, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);

		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		b2.setBounds(300, 289, 100, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		contentPane.add(b2);

		// Panel for grouping components
		JPanel panel = new JPanel();
		panel.setForeground(new Color(34, 139, 34));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
		panel.setBounds(31, 30, 640, 310);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
	}

	/**
	 * Action event handler for button clicks.
	 */
	public void actionPerformed(ActionEvent ae) {
		try {
			DBConnection con = new DBConnection();

			// Handle "Create" button click
			if (ae.getSource() == b1) {
				String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";
				PreparedStatement st = con.c.prepareStatement(sql);

				st.setString(1, textField.getText());
				st.setString(2, textField_1.getText());
				st.setString(3, textField_2.getText());
				st.setString(4, (String) comboBox.getSelectedItem());
				st.setString(5, textField_3.getText());

				int i = st.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Account Created Successfully ");
				}

				// Clear input fields after creating account
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}

			// Handle "Back" button click
			if (ae.getSource() == b2) {
				this.setVisible(false);
				new Login().setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}