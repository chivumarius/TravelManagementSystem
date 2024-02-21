package travel;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookHotel extends JFrame {
	JPanel contentPane;
	private final JTextField t1, t2;
	private final Choice c1, c2, c3;

	/*
	 * The main method creates and displays a BookHotel frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				BookHotel frame = new BookHotel("");
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/*
	 * The BookHotel constructor initializes the frame and its components.
	 */
	public BookHotel(String username) {
		// Set frame properties
		setBounds(420, 220, 1100, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);


		// Set Frame to Open in the Center of the Screen at Runtime
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
		setLocation(centerX, centerY);


		// Set background image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel la1 = new JLabel(i2);
		la1.setBounds(450, 100, 700, 300);
		add(la1);

		// Add labels and input fields for user information
		JLabel lblName = new JLabel("Book Hotel");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);

		JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		contentPane.add(la2);

		JLabel l1 = new JLabel(username);
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);

		JLabel lblId = new JLabel("Select Hotel :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

		// Add choice component for selecting hotel
		c1 = new Choice();
		DBConnection c = new DBConnection();
		try {
			ResultSet rs = c.s.executeQuery("select * from hotels");
			while (rs.next()) {
				c1.add(rs.getString("name"));
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		c1.setBounds(271, 110, 150, 30);
		add(c1);

		// Add labels and input fields for hotel details
		JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		contentPane.add(la3);

		t1 = new JTextField();
		t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		JLabel la4 = new JLabel("Number of Days");
		la4.setBounds(35, 190, 200, 14);
		contentPane.add(la4);

		t2 = new JTextField();
		t2.setText("0");
		t2.setBounds(271, 190, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JLabel la5 = new JLabel("Air Conditioned / Non Air Conditioned");
		la5.setBounds(35, 230, 200, 14);
		contentPane.add(la5);

		// Add choice component for selecting room type
		c2 = new Choice();
		c2.add("Air Conditioned");
		c2.add("Non Air Conditioned");
		c2.setBounds(271, 230, 150, 30);
		add(c2);

		JLabel la6 = new JLabel("Food Included :");
		la6.setBounds(35, 270, 200, 14);
		contentPane.add(la6);

		// Add choice component for selecting food options
		c3 = new Choice();
		c3.add("Yes");
		c3.add("No");
		c3.setBounds(271, 270, 150, 30);
		add(c3);

		// Add labels and input fields for user contact information
		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 310, 200, 14);
		contentPane.add(lbl1);

		JLabel l2 = new JLabel();
		l2.setBounds(271, 310, 200, 14);
		contentPane.add(l2);

		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 350, 200, 14);
		contentPane.add(lbl2);

		JLabel l3 = new JLabel();
		l3.setBounds(271, 350, 200, 14);
		contentPane.add(l3);

		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 390, 200, 14);
		contentPane.add(lbl3);

		JLabel l4 = new JLabel();
		l4.setBounds(271, 390, 200, 14);
		contentPane.add(l4);

		JLabel lblDeposit = new JLabel("Total Price :");
		lblDeposit.setBounds(35, 430, 200, 14);
		contentPane.add(lblDeposit);

		JLabel l5 = new JLabel();
		l5.setBounds(271, 430, 200, 14);
		l5.setForeground(Color.RED);
		contentPane.add(l5);


		// Retrieve user information from the database
		try {
			ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
			while (rs.next()) {
				l2.setText(rs.getString("id_type"));
				l3.setText(rs.getString("number"));
				l4.setText(rs.getString("phone"));
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


		// Add button to calculate total price
		JButton b1 = new JButton("Check Price");
		b1.addActionListener(e -> {
			DBConnection conn = new DBConnection();
			try {
				String hotelName = c1.getSelectedItem();
				String query = "select * from hotels where name = '" + hotelName + "'";

				ResultSet rs = conn.s.executeQuery(query);


				if (rs.next()) {
					int costPerDay = Integer.parseInt(rs.getString("cost_per_day"));
					int foodCharges = Integer.parseInt(rs.getString("food_charges"));
					int acCharges = Integer.parseInt(rs.getString("air_conditioned"));

					int persons = Integer.parseInt(t1.getText());
					int days = Integer.parseInt(t2.getText());

					String airConditionedPrice = c2.getSelectedItem();
					String foodPrice = c3.getSelectedItem();

					if (persons * days > 0) {
						int total = 0;
						total += airConditionedPrice.equals("Air Conditioned") ? acCharges : 1;
						total += foodPrice.equals("Yes") ? foodCharges : 1;
						total += costPerDay;
						total = total * persons * days;
						l5.setText(total + " Euro");
					}
				}
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
			}
		});

		b1.setBounds(50, 470, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);



		// Add button to book the hotel
		JButton btnNewButton = new JButton("Book");

		btnNewButton.addActionListener(e -> {
			DBConnection conn = new DBConnection();
			try {
				String query = "insert into bookhotel values('" + l1.getText() + "', '" + c1.getSelectedItem() + "', '" + t1.getText() + "', '" + t2.getText() + "', '" + c2.getSelectedItem() + "', '" + c3.getSelectedItem() + "', '" + l2.getText() + "', '" + l3.getText() + "', '" + l4.getText() + "', '" + l5.getText() + "')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
				setVisible(false);
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
			}
		});


		btnNewButton.setBounds(200, 470, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		// Add button to exit booking
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(e -> setVisible(false));
		btnExit.setBounds(350, 470, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Set background color
		getContentPane().setBackground(Color.WHITE);
	}
}