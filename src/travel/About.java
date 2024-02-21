package travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    Font f, f1, f2;
    TextArea t1;
    String s;

    public About() {

        setLayout(null);
        JButton b1 = new JButton("Exit");
        add(b1);
        b1.setBounds(180, 430, 120, 20);
        b1.addActionListener(this);


        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);

        s = """
                                         \s
                \s
                The aim of the Travel and Tourism Management system project is to create an automated platform that streamlines the operations and processes involved in travel management. This system is designed to enable users to seamlessly perform all tasks associated with travel arrangements.
                                
                This application facilitates easy access to information pertaining to travel to specific destinations. Users can effortlessly track details related to their tours through this application. Additionally, the application allows users to access information about travel agencies.
                                
                Key Advantages of the Project:
                                
                 Offers precise and accurate information
                 Streamlines manual tasks
                 Reduces the need for extensive documentation
                 Provides real-time updates
                 Establishes a user-friendly environment with warning messages
                 Enables the provision of traveler details
                 Sends booking confirmation notifications""";

        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);

        add(t1);

        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);

        Container contentPane = this.getContentPane();
        t1 = new TextArea();

        JLabel l1 = new JLabel("About Project");
        add(l1);
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.blue);

        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);

        setBounds(700, 220, 500, 550);

        // Set Frame to Open in the Center of the Screen at Runtime
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);

        setLayout(null);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }

}
