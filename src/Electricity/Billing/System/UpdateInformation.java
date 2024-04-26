package Electricity.Billing.System;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener {

    private JTextField tfaddress, tfstate, tfcity, tfemail, tfphone;
    private JButton update, cancel;
    private String meter;
    private JLabel name;

    UpdateInformation(String meter) {
        this.meter = meter;
        setBounds(300, 150, 1050, 600);
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110, 30, 400, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
        heading.setForeground(new Color(100, 100, 100));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 100, 100, 20);
        lblname.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lblname);

        name = new JLabel("");
        name.setBounds(230, 100, 200, 20);
        name.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(name);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(30, 140, 180, 20);
        lblmeternumber.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(230, 140, 200, 20);
        meternumber.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(meternumber);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 180, 100, 20);
        lbladdress.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(230, 180, 200, 25);
        tfaddress.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(tfaddress);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(30, 220, 100, 20);
        lblcity.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(230, 220, 200, 25);
        tfcity.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(tfcity);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(30, 260, 100, 20);
        lblstate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(230, 260, 200, 25);
        tfstate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(tfstate);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 300, 100, 20);
        lblemail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(230, 300, 200, 25);
        tfemail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 340, 100, 20);
        lblphone.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(230, 340, 200, 25);
        tfphone.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(tfphone);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter + "'");
            while (rs.next()) {
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(new Color(0, 102, 255));
        update.setForeground(new Color(255, 255, 255));
        update.setBounds(70, 400, 100, 30);
        update.setFont(new Font("Segoe UI", Font.BOLD,18));
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(255, 0, 0));
        cancel.setForeground(new Color(255, 255, 255));
        cancel.setBounds(230, 400, 100, 30);
        cancel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 400, 300);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
        String address = tfaddress.getText();
        String city = tfcity.getText();
        String state = tfstate.getText();
        String email = tfemail.getText();
        String phone = tfphone.getText();
        try {
        Conn c = new Conn();
        c.s.executeUpdate("update customer set address = '" + address + "', city = '" + city + "', state = '" + state + "', email = '" + email + "', phone = '" + phone + "' where meter_no = '" + meter + "'");
        JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
        setVisible(false);
        } catch (Exception e) {
        e.printStackTrace();
        }
        } else {
        setVisible(false);
        }
        }

        public static void main(String[] args) {
        	new UpdateInformation("");
        }
}


