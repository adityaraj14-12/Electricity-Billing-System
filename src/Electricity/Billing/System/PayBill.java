
package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class PayBill extends JFrame implements ActionListener {

    Choice cmonth;
    JButton pay, back;
    String meter;

    PayBill(String meter) {
        this.meter = meter;
        setLayout(null);
        setBounds(300, 150, 900, 600);

        JLabel heading = new JLabel("Electricity Bill");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setForeground(new Color(0x00698f));
        heading.setBounds(120, 5, 400, 30);
        add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblmeternumber.setForeground(new Color(0x333333));
        lblmeternumber.setBounds(35, 80, 200, 20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setFont(new Font("Segoe UI", Font.BOLD, 18));
        meternumber.setForeground(new Color(0x333333));
        meternumber.setBounds(300, 80, 200, 20);
        add(meternumber);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblname.setForeground(new Color(0x333333));
        lblname.setBounds(35, 140, 200, 20);
        add(lblname);

        JLabel labelname = new JLabel("");
        labelname.setFont(new Font("Segoe UI", Font.BOLD, 18));
        labelname.setForeground(new Color(0x333333));
        labelname.setBounds(300, 140, 200, 20);
        add(labelname);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblmonth.setForeground(new Color(0x333333));
        lblmonth.setBounds(35, 200, 200, 20);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setFont(new Font("Segoe UI", Font.BOLD, 18));
        cmonth.setForeground(new Color(0x333333));
        cmonth.setBounds(300, 200, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);

        JLabel lblunits = new JLabel("Units");
        lblunits.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblunits.setForeground(new Color(0x333333));
        lblunits.setBounds(35, 260, 200, 20);
        add(lblunits);

        JLabel labelunits = new JLabel("");
        labelunits.setFont(new Font("Segoe UI", Font.BOLD, 18));
        labelunits.setForeground(new Color(0x333333));
        labelunits.setBounds(300, 260, 200, 20);
        add(labelunits);

        JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lbltotalbill.setForeground(new Color(0x333333));
        lbltotalbill.setBounds(35, 320, 200, 20);
        add(lbltotalbill);

        JLabel labeltotalbill = new JLabel("");
        labeltotalbill.setFont(new Font("Segoe UI", Font.BOLD, 18));
        labeltotalbill.setForeground(new Color(0x333333));
        labeltotalbill.setBounds(300, 320, 200, 20);
        add(labeltotalbill);

        JLabel lblstatus = new JLabel("Status");
        lblstatus.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblstatus.setForeground(new Color(0x333333));
        lblstatus.setBounds(35, 380, 200, 20);
        add(lblstatus);

        JLabel labelstatus = new JLabel("");
        labelstatus.setFont(new Font("Segoe UI", Font.BOLD, 18));
        labelstatus.setForeground(new Color(0x333333));
        labelstatus.setBounds(300, 380, 200, 20);
        labelstatus.setForeground(Color.RED);
        add(labelstatus);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter + "'");
            while (rs.next()) {
                meternumber.setText(meter);
                labelname.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' AND month = 'January'");
            if (rs.next()) {
                labelunits.setText(rs.getString("units"));
                labeltotalbill.setText(rs.getString("totalbill"));
                labelstatus.setText(rs.getString("status"));
            } else {
                labelunits.setText("No bill available for this month");
                labeltotalbill.setText("");
                labelstatus.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cmonth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ae) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' AND month = '" + cmonth.getSelectedItem() + "'");
                    if (rs.next()) {
                        labelunits.setText(rs.getString("units"));
                        labeltotalbill.setText(rs.getString("totalbill"));
                        labelstatus.setText(rs.getString("status"));
                    } else {
                        labelunits.setText("No bill available for this month");
                        labeltotalbill.setText("");
                        labelstatus.setText("");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

 

        pay = new JButton("Pay");
        pay.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pay.setBackground(new Color(0, 128, 0));
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tahoma", Font.BOLD, 18));
        pay.setBounds(100, 460, 100, 25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setFont(new Font("Segoe UI", Font.BOLD, 18));
        back.setBackground(new Color(0, 0, 255));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.setBounds(230, 460, 100, 25);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(new Color(0xf0f0f0));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 120, 600, 300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '" + meter + "' AND month='" + cmonth.getSelectedItem() + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PayBill("");
    }
}



