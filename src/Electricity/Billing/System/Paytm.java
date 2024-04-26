package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    private String meter;
    private JButton back, pay;

    Paytm(String meter) {
        this.meter = meter;
        setLayout(null);

        JLabel heading = new JLabel("PAYTM");
        heading.setBounds(250, 20, 300, 40);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setForeground(new Color(0, 0, 255));
        add(heading);

        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        try {
            j.setPage("https://paytm.com/online-payments");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load<html>");
        }
        JScrollPane pane = new JScrollPane(j);
        pane.setBounds(50, 80, 700, 400);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);

        pay = new JButton("Pay");
        pay.setBounds(250, 500, 100, 30);
        pay.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pay.setBackground(new Color(0, 0, 155));
        pay.setForeground(new Color(255, 255, 255));
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(400, 500, 80, 30);
        back.setFont(new Font("Segoe UI", Font.BOLD, 18));
        back.setBackground(new Color(225, 102, 255));
        back.setForeground(new Color(255, 255, 255));
        back.addActionListener(this);
        add(back);

        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new PayBill(meter);
        } else if (ae.getSource() == pay) {
            // Implement payment logic here
            JOptionPane.showMessageDialog(this, "Payment successful!");
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Paytm("");
    }
}
