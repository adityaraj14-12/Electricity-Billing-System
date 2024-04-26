package Electricity.Billing.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    String atype, meter;

    Project(String atype, String meter) {
        this.atype = atype;
        this.meter = meter;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK); // Set the background color to black

        // Create a menu bar
        JMenuBar mb = new JMenuBar();
        mb.setBackground(new Color(0, 0, 0));
        mb.setOpaque(true);

        // Add menus to the menu bar
        JMenu master = new JMenu("Master");
        master.setFont(new Font("Segoe UI", Font.BOLD, 14));
        master.setForeground(new Color(0,128,0));

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        newcustomer.setBackground(new Color(255, 255, 255));
        newcustomer.setForeground(new Color(0, 128, 0));
        newcustomer.addActionListener(this);

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        customerdetails.setBackground(new Color(255, 255, 255));
        customerdetails.setForeground(new Color(0, 128, 0));
        customerdetails.addActionListener(this);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        depositdetails.setBackground(new Color(255, 255, 255));
        depositdetails.setForeground(new Color(0, 128, 0));
        depositdetails.addActionListener(this);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        calculatebill.setBackground(new Color(255, 255, 255));
        calculatebill.setForeground(new Color(0, 128, 0));
        calculatebill.addActionListener(this);

        master.add(newcustomer);
        master.add(customerdetails);
        master.add(depositdetails);
        master.add(calculatebill);

        JMenu info = new JMenu("Information");
        info.setFont(new Font("Segoe UI", Font.BOLD, 14));
        info.setForeground(new Color(255,20,147));

        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        updateinformation.setBackground(new Color(255, 255, 255));
        updateinformation.setForeground(new Color(255,20,147));
        updateinformation.addActionListener(this);

        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        viewinformation.setBackground(new Color(255, 255, 255));
        viewinformation.setForeground(new Color(255,20,147));
        viewinformation.addActionListener(this);

        info.add(updateinformation);
        info.add(viewinformation);

        JMenu user = new JMenu("User");
        user.setFont(new Font("Segoe UI", Font.BOLD, 14));
        user.setForeground(new Color(127, 0, 255));

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        paybill.setBackground(new Color(255, 255, 255));
        paybill.setForeground(new Color(127, 0, 255));
        paybill.addActionListener(this);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        billdetails.setBackground(new Color(255, 255, 255));
        billdetails.setForeground(new Color(127, 0, 255));
        billdetails.addActionListener(this);

        user.add(paybill);
        user.add(billdetails);

        JMenu report = new JMenu("Report");
        report.setFont(new Font("Segoe UI", Font.BOLD, 14));
        report.setForeground(new Color(255,165,0));

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        generatebill.setBackground(new Color(255, 255, 255));
        generatebill.setForeground(new Color(255,145,0));
        generatebill.addActionListener(this);

        report.add(generatebill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Segoe UI", Font.BOLD, 14));
        utility.setForeground(new Color(0, 0, 255));

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        notepad.setBackground(new Color(255, 255, 255));
        notepad.setForeground(new Color(0, 0, 255));
        notepad.setIcon(new ImageIcon("icon15.png"));
        notepad.addActionListener(this);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        calculator.setBackground(new Color(255, 255, 255));
        calculator.setForeground(new Color(100, 0, 220));
        calculator.addActionListener(this);

        utility.add(notepad);
        utility.add(calculator);

        JMenu mexit = new JMenu("Exit");
        mexit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        mexit.setForeground(new Color(255, 0, 0));

        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        exit.setBackground(new Color(255, 255, 255));
        exit.setForeground(new Color(255, 0, 0));
        exit.setIcon(new ImageIcon("icon18.png"));
        exit.addActionListener(this);

        mexit.add(exit);

        if (atype.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(mexit);

        setJMenuBar(mb);

        // Create a modern and attractive content pane
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        add(panel, BorderLayout.CENTER);

        // Add some content to the panel
        JLabel label = new JLabel("Welcome to Electricity Billing System");
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(255, 255, 255));
        panel.add(label);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ele.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setLayout(new FlowLayout());
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();
        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new CalculateBill();
        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);
        } else if (msg.equals("Update Information")) {
            new UpdateInformation(meter);
        } else if (msg.equals("Bill Details")) {
            new BillDetails(meter);
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (msg.equals("Paint")) {
            try {
                Runtime.getRuntime().exec("mspaint.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meter);
        } else if (msg.equals("Generate Bill")) {
            new GenerateBill(meter);
        }
    }

    public static void main(String[] args) {
        new Project("", "");
    }
}
