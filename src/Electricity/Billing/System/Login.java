package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel, signup;
    JTextField username;
    JPasswordField password; // Changed to JPasswordField
    Choice logginin;

    Login() {
        super("Login Page");
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        lblusername.setFont(new Font("Montserrat", Font.BOLD, 14));
        add(lblusername);

        username = new JTextField();
        username.setBounds(400, 20, 150, 25);
        username.setFont(new Font("Montserrat", Font.BOLD, 12));
        add(username);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(300, 60, 100, 20);
        lblpassword.setFont(new Font("Montserrat", Font.BOLD, 14));
        add(lblpassword);

        password = new JPasswordField(); // Changed to JPasswordField
        password.setBounds(400, 60, 150, 25);
        password.setFont(new Font("Montserrat", Font.BOLD, 12));
        add(password);

        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(300, 100, 100, 20);
        loggininas.setFont(new Font("Montserrat", Font.BOLD, 14));
        add(loggininas);

        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 25);
        logginin.setFont(new Font("Montserrat", Font.BOLD, 12));
        add(logginin);

        login = new JButton("Login");
        login.setBounds(330, 160, 100, 25); 
        login.setBackground(new Color(34, 139, 34));
        login.setForeground(new Color(245, 245, 245));
        login.setFont(new Font("Montserrat", Font.BOLD, 12));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 160, 100, 25);
        cancel.setBackground(new Color(255,0,0));
        cancel.setForeground(new Color(245, 245, 245));
        cancel.setFont(new Font("Montserrat", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);

        signup = new JButton("Signup");
        signup.setBounds(380, 200, 100, 25);
        signup.setBackground(new Color(10, 20, 245));
        signup.setForeground(new Color(245, 245, 245));
        signup.setFont(new Font("Montserrat", Font.BOLD, 12));
        signup.addActionListener(this);
        add(signup);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);

        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String susername = username.getText();
            String spassword = new String(password.getPassword()); // Changed to getPassword()
            String user = logginin.getSelectedItem();
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + susername + "' and password = '" + spassword + "' and user = '" + user + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user, meter);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
    } else if (ae.getSource() == signup) {
        setVisible(false);
        new Signup();
    }
}

public static void main(String[] args) {
    new Login();
	}
}

