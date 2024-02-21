package travel;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame{
    public static void main(String[] args) {
        new CheckPackage().setVisible(true);
    }

    CheckPackage() {
        setBounds(550, 220, 900, 600);
        setVisible(true);
        String[] package1 = new String[]{"package1.jpg","Gold Package","6 days and 7 Nights", "Airport Assistance at Airport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Only 135 Euro"};
        String[] package2 = new String[]{"package2.jpg","Silver Package","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Airport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Only 265  Euro"};
        String[] package3 = new String[]{"package3.jpg","Bronze Package","6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Summer Special", "Only 350  Euro"};

        // Set Frame to Open in the Center of the Screen at Runtime
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);


        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Package 3", null, p3);

        add(tabbedPane, BorderLayout.CENTER);
    }

    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i3 = i1.getImage().getScaledInstance(550, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,0,450,420);
        p1.add(l1);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 5, 350, 53);
        p1.add(lblName);

        JLabel l3 = new JLabel(pack[2]);
        l3.setForeground(Color.BLUE);
        l3.setBounds(35, 70, 200, 14);
        p1.add(l3);

        JLabel lblId = new JLabel(pack[3]);
        lblId.setForeground(Color.BLUE);
        lblId.setBounds(35, 110, 200, 14);
        p1.add(lblId);

        JLabel l2 = new JLabel(pack[4]);
        l2.setForeground(Color.BLUE);
        l2.setBounds(35, 150, 200, 14);
        p1.add(l2);

        JLabel lblName_1 = new JLabel(pack[5]);
        lblName_1.setForeground(Color.BLUE);
        lblName_1.setBounds(35, 190, 200, 14);
        p1.add(lblName_1);

        JLabel lblGender = new JLabel(pack[6]);
        lblGender.setForeground(Color.BLUE);
        lblGender.setBounds(35, 230, 200, 14);
        p1.add(lblGender);

        JLabel lblCountry = new JLabel(pack[7]);
        lblCountry.setForeground(Color.BLUE);
        lblCountry.setBounds(35, 270, 200, 14);
        p1.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel(pack[8]);
        lblReserveRoomNumber.setForeground(Color.BLUE);
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        p1.add(lblReserveRoomNumber);

        JLabel lblCheckInStatus = new JLabel(pack[9]);
        lblCheckInStatus.setForeground(Color.BLUE);
        lblCheckInStatus.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblCheckInStatus.setBounds(35, 400, 200, 30);
        p1.add(lblCheckInStatus);

        JLabel lblDeposit = new JLabel(pack[10]);
        lblDeposit.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblDeposit.setBounds(35, 460, 400, 40);
        p1.add(lblDeposit);

        JLabel la1 = new JLabel(pack[11]);
        la1.setForeground(Color.BLUE);
        la1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        la1.setBounds(600, 460, 400, 40);
        p1.add(la1);

        return p1;
    }
}
