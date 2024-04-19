package Electricity.Billing.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton login, cancel,signup;
	Login(){
		super("Login Page");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JTextField username= new JTextField();
		username.setBounds(400,20,150,20);
		add(username);
		
		JLabel lblusername= new JLabel("Username");
		lblusername.setBounds(300,20,100,20);
		add(lblusername);
		setSize(640,300);
		setLocation(400,200);
		setVisible(true);
		

		JTextField password= new JTextField();
		password.setBounds(400,60,150,20);
		add(password);

		JLabel lblpassword= new JLabel("Password");
		lblpassword.setBounds(300,60,100,20);
		add(lblpassword);
		setSize(640,300);
		setLocation(400,200);
		setVisible(true);
		
		Choice loginin = new Choice();
		loginin.add("Admin");
		loginin.add("Customer");
		loginin.setBounds(400,100,150,20);
		add(loginin);
		
		JLabel loggininas= new JLabel("Login in as");
		loggininas.setBounds(300,100,100,20);
		add(loggininas);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		
		
		 login=new JButton("Login",new ImageIcon(i2));
		login.setBounds(330,160,100,20);
		login.addActionListener(this);
		add(login);
		

		ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
		Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		
		 cancel=new JButton("Cancel",new ImageIcon(i4));
		cancel.setBounds(450,160,100,20);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		
		 signup=new JButton("Signup",new ImageIcon(i6));
		signup.setBounds(380,200,100,20);
		signup.addActionListener(this);
		add(signup);
		
		ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
		Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i9= new ImageIcon(i8);
		JLabel image= new JLabel(i9);
		image.setBounds(0,0,250,250);
		add(image);
		

		
		setSize(640,310);
		setLocation(400,200);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		  
		if(ae.getSource()==login) {
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup();
		}
	}
	public static void main(String[] args) {
		new Login();
	}

}
