package travel;


import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DeleteCustomer extends JFrame {
	private JPanel contentPane;
	Choice c1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

				try {
					DeleteCustomer frame = new DeleteCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

		});
	}

	public DeleteCustomer() throws SQLException {
		setBounds(580, 220, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);


		// Set Frame to Open in the Center of the Screen at Runtime
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
		setLocation(centerX, centerY);


		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		Image i3 = i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(500,100,300,300);
		add(l1);

		JLabel lblName = new JLabel("Delete Customer Details");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);

		JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);

		c1 = new Choice();
		DBConnection c = new DBConnection();
		try {
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()){
				c1.add(rs.getString("username"));
			}
			rs.close();
		} catch(Exception e){
			e.printStackTrace();
		}

		c1.setBounds(271, 70, 150, 30);
		add(c1);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

		JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);

		JLabel lb2 = new JLabel("Number :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);

		JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);

		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);

		JLabel l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);

		JLabel l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);

		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);

		JLabel l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);

		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);

		JLabel l8 = new JLabel();
		l8.setBounds(271, 350, 200, 14);
		contentPane.add(l8);

		JLabel lblDeposit = new JLabel("Email :");
		lblDeposit.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposit);

		JLabel l9 = new JLabel();
		l9.setBounds(271, 390, 200, 14);
		contentPane.add(l9);

		JButton b1 = new JButton("Check");
		b1.addActionListener(e -> {
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where username = '" + c1.getSelectedItem() + "'");
				if(rs.next()){
					l2.setText(rs.getString(2));
					l3.setText(rs.getString(3));
					l4.setText(rs.getString(4));
					l5.setText(rs.getString(5));
					l6.setText(rs.getString(6));
					l7.setText(rs.getString(7));
					l8.setText(rs.getString(8));
					l9.setText(rs.getString(9));
				}
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		});
		b1.setBounds(425, 70, 80, 22);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(e -> {
			try {
				String s1 = c1.getSelectedItem();
				String q1 = "delete from customer where username = '" + s1 + "'";
				c.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
				setVisible(false);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} catch (NumberFormatException s) {
				JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(e -> {
			setVisible(false);
		});
		btnExit.setBounds(260, 430, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}
}