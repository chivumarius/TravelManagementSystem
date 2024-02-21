package travel;

import javax.swing.*;
import java.awt.*;

public class Payment extends JFrame {

    public Payment() {
        // Setting up the frame
        setLayout(null);
        setBounds(600, 220, 800, 600);

        // Adding the label for payment
        JLabel label = new JLabel("Pay the Payment");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);

        // Set Frame to Open in the Center of the Screen at Runtime
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);

        // Adding the image
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 150, 800, 600);
        add(l4);

        // Adding the "Pay" button
        JButton pay = new JButton("Pay");
        pay.addActionListener(e -> JOptionPane.showMessageDialog(null, "Payment Done Successfully"));
        pay.setBounds(420, 20, 80, 40);
        add(pay);

        // Adding the "Back" button
        JButton back = new JButton("Back");
        back.addActionListener(e -> setVisible(false));
        back.setBounds(510, 20, 80, 40);
        add(back);

        // Setting background color
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        // Creating an instance of the Payment class and making it visible
        new Payment().setVisible(true);
    }

}