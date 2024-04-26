
package Electricity.Billing.System;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, username, name;
    JPasswordField password;

    Signup() {
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(new Color(34, 139, 34));
        heading.setFont(new Font("Montserrat", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        accountType.setFont(new Font("Montserrat", Font.BOLD, 12));
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(new Color(34, 139, 34));
        lblmeter.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        meter.setFont(new Font("Montserrat", Font.BOLD, 12));
        panel.add(meter);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(new Color(34, 139, 34));
        lblusername.setFont(new Font("Montserrat", Font.BOLD, 14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        username.setFont(new Font("Montserrat", Font.BOLD, 12));
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(new Color(34, 139, 34));
        lblname.setFont(new Font("Montserrat", Font.BOLD, 14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        name.setFont(new Font("Montserrat", Font.BOLD, 12));
        panel.add(name);

        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
            }

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '" + meter.getText() + "'");
                    while (rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(new Color(34, 139, 34));
        lblpassword.setFont(new Font("Montserrat", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JPasswordField(); // Changed to JPasswordField
        password.setBounds(260, 210, 150, 20);
        password.setFont(new Font("Montserrat", Font.BOLD, 12));
        panel.add(password);

        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });

        create = new JButton("Create");
        create.setBackground(new Color(255, 165, 0));
        create.setForeground(new Color(245, 245, 245));
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        create.setFont(new Font("Montserrat", Font.BOLD, 12));
     

        panel.add(create);
        back = new JButton("Back");
        back.setBackground(new Color(10, 25, 245));
        back.setForeground(new Color(245, 245, 245));
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        back.setFont(new Font("Montserrat", Font.BOLD, 12));
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 220, 210);
        panel.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = new String(password.getPassword()); // Changed to getPassword()
            String smeter = meter.getText();
            try {
                Conn c = new Conn();
                String query = null;
                if (atype.equals("Admin")) {
                    query = "insert into login values('" + smeter + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + atype + "')";
                } else {
                    query = "update login set username = '" + susername + "', password = '" + spassword + "', user = '" + atype + "' where meter_no = '" + smeter + "'";
                }
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}

