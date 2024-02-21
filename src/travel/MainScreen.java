package travel;

import java.awt.*;
import javax.swing.*;

// Main class representing the main screen of the application
public class MainScreen extends JFrame {
    String username;

    // Main method to start the application
    public static void main(String[] args) {
        // Create and display the main screen
        new MainScreen("").setVisible(true);
    }

    // Constructor to initialize the main screen
    public MainScreen(String username) {
        super("Travel & Tourism Management System");
        this.username = username;
        setForeground(Color.CYAN);
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundLabel = new JLabel(i3);
        backgroundLabel.setBounds(0, 0, 1950, 1000);
        add(backgroundLabel);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Customer menu
        JMenu customerMenu = new JMenu("Customer");
        customerMenu.setForeground(Color.BLACK); // Changed to black
        menuBar.add(customerMenu);

        // Menu items for customer operations
        JMenuItem addCustomerItem = new JMenuItem("Add Customer");
        customerMenu.add(addCustomerItem);

        JMenuItem updateCustomerItem = new JMenuItem("Update Customer Detail");
        customerMenu.add(updateCustomerItem);

        JMenuItem viewCustomerItem = new JMenuItem("View Customer Details");
        customerMenu.add(viewCustomerItem);

        JMenuItem deleteCustomerItem = new JMenuItem("Delete Customer Details");
        customerMenu.add(deleteCustomerItem);

        // ActionListener for adding customer
        addCustomerItem.addActionListener(ae -> {
            try {
                new AddCustomer(username).setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for updating customer details
        updateCustomerItem.addActionListener(ae -> {
            try {
                new UpdateCustomer(username).setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for viewing customer details
        viewCustomerItem.addActionListener(ae -> {
            try {
                new ViewCustomers().setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for deleting customer details
        deleteCustomerItem.addActionListener(ae -> {
            try {
                new DeleteCustomer().setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Packages menu
        JMenu packagesMenu = new JMenu("Packages");
        packagesMenu.setForeground(Color.BLACK); // Changed to black
        menuBar.add(packagesMenu);

        // Menu items for package operations
        JMenuItem checkPackageItem = new JMenuItem("Check Package");
        packagesMenu.add(checkPackageItem);

        JMenuItem bookPackageItem = new JMenuItem("Book Package");
        packagesMenu.add(bookPackageItem);

        JMenuItem viewPackageItem = new JMenuItem("View Package");
        packagesMenu.add(viewPackageItem);

        // ActionListener for checking package
        checkPackageItem.addActionListener(ae -> {
            try {
                new CheckPackage().setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for booking package
        bookPackageItem.addActionListener(ae -> {
            try {
                new BookPackage(username).setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for viewing package
        viewPackageItem.addActionListener(ae -> {
            try {
                new ViewPackage(username).setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Hotels menu
        JMenu hotelsMenu = new JMenu("Hotels");
        hotelsMenu.setForeground(Color.BLACK); // Changed to black
        menuBar.add(hotelsMenu);

        // Menu items for hotel operations
        JMenuItem bookHotelsItem = new JMenuItem("Book Hotels");
        hotelsMenu.add(bookHotelsItem);

        JMenuItem viewHotelsItem = new JMenuItem("View Hotels");
        hotelsMenu.add(viewHotelsItem);

        JMenuItem viewBookedHotelItem = new JMenuItem("View Booked Hotel");
        hotelsMenu.add(viewBookedHotelItem);

        // ActionListener for booking hotel
        bookHotelsItem.addActionListener(ae -> new BookHotel(username).setVisible(true));

        // ActionListener for viewing hotels
        viewHotelsItem.addActionListener(ae -> {
            try {
                new ViewHotels().setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for viewing booked hotels
        viewBookedHotelItem.addActionListener(ae -> {
            try {
                new ViewBookedHotel(username).setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        // Payment menu
        JMenu paymentMenu = new JMenu("Payment");
        paymentMenu.setForeground(Color.BLACK); // Changed to black
        menuBar.add(paymentMenu);

        // Menu item for payment
        JMenuItem payPaymentItem = new JMenuItem("Pay the Payment");
        paymentMenu.add(payPaymentItem);

        // ActionListener for payment
        payPaymentItem.addActionListener(ae -> new Payment().setVisible(true));

        // Utility menu
        JMenu utilityMenu = new JMenu("Utility");
        utilityMenu.setForeground(Color.BLACK); // Changed to black
        menuBar.add(utilityMenu);

        // Menu items for utility operations
        JMenuItem notepadItem = new JMenuItem("Notepad");
        utilityMenu.add(notepadItem);

        JMenuItem calculatorItem = new JMenuItem("Calculator");
        utilityMenu.add(calculatorItem);

        // ActionListener for opening Notepad
        notepadItem.addActionListener(ae -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                pb.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for opening Calculator
        calculatorItem.addActionListener(ae -> {
            try {
                ProcessBuilder calc = new ProcessBuilder("calc.exe");
                calc.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // About menu
        JMenu aboutMenu = new JMenu("About");
        aboutMenu.setForeground(Color.BLACK); // Changed to black
        menuBar.add(aboutMenu);

        // Menu item for About section
        JMenuItem aboutItem = new JMenuItem("About");
        aboutMenu.add(aboutItem);

        // ActionListener for About section
        aboutItem.addActionListener(ae -> new About().setVisible(true));

        // Logout menu
        JMenu logoutMenu = new JMenu("Logout");
        logoutMenu.setForeground(Color.BLACK); // Changed to black
        menuBar.add(logoutMenu);

        // Menu item for Logout
        JMenuItem logoutItem = new JMenuItem("Logout");
        logoutMenu.add(logoutItem);

        // ActionListener for Logout
        logoutItem.addActionListener(ae -> {
            // Close the current window
            setVisible(false);
            // Open the login window
            new Login().setVisible(true);
        });

        // Set the main screen to be maximized and visible
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}