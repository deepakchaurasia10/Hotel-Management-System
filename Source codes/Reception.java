package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{

	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
	
	Reception() {
		
		b1 = new JButton("New Customer Form");
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.gray);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(30, 30, 200, 40);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Rooms");
		b2.setForeground(Color.BLACK);
		b2.setBackground(Color.gray);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(230, 70, 200, 40);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Department");
		b3.setForeground(Color.BLACK);
		b3.setBackground(Color.gray);
		b3.setFont(new Font("Dialog", Font.BOLD, 17));
		b3.setBounds(30, 110, 200, 40);
		b3.addActionListener(this);
		add(b3);
		
		b4 = new JButton("All Employee Info");
		b4.setForeground(Color.BLACK);
		b4.setBackground(Color.gray);
		b4.setFont(new Font("Dialog", Font.BOLD, 17));
		b4.setBounds(230, 150, 200, 40);
		b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("Customer Info");
		b5.setForeground(Color.BLACK);
		b5.setBackground(Color.gray);
		b5.setFont(new Font("Dialog", Font.BOLD, 17));
		b5.setBounds(30, 190, 200, 40);
		b5.addActionListener(this);
		add(b5);
		
		b6 = new JButton("Manager Info");
		b6.setForeground(Color.BLACK);
		b6.setBackground(Color.gray);
		b6.setFont(new Font("Dialog", Font.BOLD, 17));
		b6.setBounds(230, 230, 200, 40);
		b6.addActionListener(this);
		add(b6);
		
		b7 = new JButton("Check Out");
		b7.setForeground(Color.BLACK);
		b7.setBackground(Color.gray);
		b7.setFont(new Font("Dialog", Font.BOLD, 17));
		b7.setBounds(30, 270, 200, 40);
		b7.addActionListener(this);
		add(b7);
		
		b8 = new JButton("Update Check Status");
		b8.setForeground(Color.BLACK);
		b8.setBackground(Color.gray);
		b8.setFont(new Font("Dialog", Font.BOLD, 17));
		b8.setBounds(230, 310, 200,40);
		b8.addActionListener(this);
		add(b8);
		
		b9 = new JButton("Update Room Status");
		b9.setForeground(Color.BLACK);
		b9.setBackground(Color.gray);
		b9.setFont(new Font("Dialog", Font.BOLD, 17));
		b9.setBounds(30, 350, 200,40);
		b9.addActionListener(this);
		add(b9);
		
		b10 = new JButton("Pick-up Service");
		b10.setForeground(Color.BLACK);
		b10.setBackground(Color.gray);
		b10.setFont(new Font("Dialog", Font.BOLD, 17));
		b10.setBounds(230, 390, 200, 40);
		b10.addActionListener(this);
		add(b10);
		
		b11 = new JButton("Search Room");
		b11.setForeground(Color.BLACK);
		b11.setBackground(Color.gray);
		b11.setFont(new Font("Dialog", Font.BOLD, 17));
		b11.setBounds(30, 430, 200, 40);
		b11.addActionListener(this);
		add(b11);
		
		b12 = new JButton("Logout");
		b12.setForeground(Color.WHITE);
		b12.setBackground(Color.BLACK);
		b12.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 17));
		b12.setBounds(600, 470, 180, 40);
		b12.addActionListener(this);
		add(b12);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/Reception.jpg"));
		Image img = i1.getImage().getScaledInstance(380, 280, Image.SCALE_AREA_AVERAGING);
		ImageIcon i2 = new ImageIcon(img);
		JLabel imgl = new JLabel(i2);
		imgl.setBounds(480, 60, 380, 280);
		add(imgl);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(320, 150, 900, 580);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			new AddCustomer();
			this.setVisible(false);
			
		} else if(e.getSource() == b2) {
			new Rooms();
			this.setVisible(false);
			
		} else if(e.getSource() == b3) {
			new Department();
			this.setVisible(false);
			
		} else if(e.getSource() == b4) {
			new EmployeeInfo();
			this.setVisible(false);
			
		} else if(e.getSource() == b5) {
			new CustomerInfo();
			this.setVisible(false);
			
		} else if(e.getSource() == b6) {
			new ManagerInfo();
			this.setVisible(false);
			
		} else if(e.getSource() == b7) {
			new CheckOut();
			this.setVisible(false);
			
		} else if(e.getSource() == b8) {
			new UpdateCheck();
			this.setVisible(false);
			
		} else if(e.getSource() == b9) {
			new UpdateRoom();
			this.setVisible(false);
			
		} else if(e.getSource() == b10) {
			new PickUp();
			this.setVisible(false);
			
		} else if(e.getSource() == b11) {
			new SearchRoom();
			this.setVisible(false);
			
		} else if(e.getSource() == b12) {
			setVisible(false);
		}
		
	}
}
