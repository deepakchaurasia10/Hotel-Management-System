package hotel_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame implements ActionListener{
	JTextField t1, t2, t3, t4, t5;
	Choice c;
	JButton b1, b2, b3;
	
	UpdateCheck() {
		
		JLabel emp = new JLabel("Check-in Details");
		emp.setBounds(310, 0, 270, 40);
		emp.setForeground(Color.BLUE);
		emp.setFont(new Font("Century", Font.BOLD, 24));
		add(emp);
		
		JLabel l1 = new JLabel("Customer-ID");
		l1.setFont(new Font("Century", Font.BOLD, 17));
		l1.setBounds(70, 70, 120, 30);
		add(l1);
		
		c = new Choice();
		try {
			ConnDrive con = new ConnDrive();
			String str = "select * from customer";
			ResultSet rs = con.sm.executeQuery(str);
			while(rs.next()) {
				c.add(rs.getString("number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setBounds(210, 70, 250, 120);
		c.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(c);
		
		JLabel l2 = new JLabel("Room Number");
		l2.setFont(new Font("Century", Font.BOLD, 17));
		l2.setBounds(70, 120, 120, 30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(210, 120, 200, 30);
		add(t1);
		
		JLabel l3 = new JLabel("Name");
		l3.setFont(new Font("Century", Font.BOLD, 17));
		l3.setBounds(70, 170, 120, 30);
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(210, 170, 200, 30);
		add(t2);
		
		JLabel l4 = new JLabel("Check-in");
		l4.setFont(new Font("Century", Font.BOLD, 17));
		l4.setBounds(70, 220, 120, 30);
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(210, 220, 200, 30);
		add(t3);
		
		JLabel l5 = new JLabel("Amount Paid");
		l5.setFont(new Font("Century", Font.BOLD, 17));
		l5.setBounds(70, 270, 120, 30);
		add(l5);
		
		t4 = new JTextField();
		t4.setBounds(210, 270, 200, 30);
		add(t4);
		
		JLabel l6 = new JLabel("Pending Amount");
		l6.setFont(new Font("Century", Font.BOLD, 17));
		l6.setBounds(50, 320, 150, 30);
		add(l6);
		
		t5 = new JTextField();
		t5.setBounds(210, 320, 200, 30);
		add(t5);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/CheckInImage.jpg"));
		Image img = i1.getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING);
		ImageIcon i2 = new ImageIcon(img);
		JLabel imgl = new JLabel(i2);
		imgl.setBounds(450, 70, 400, 300);
		add(imgl);
		
		b1 = new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(40, 380, 120, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(170, 380, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Dialog", Font.BOLD, 17));
		b3.setBounds(300, 380, 120, 30);
		b3.addActionListener(this);
		add(b3);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(320, 200, 900, 500);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String room = null;
			String deposit = null;
			String price = null;
			int pending;
			String s1 = (String) c.getSelectedItem();
			ConnDrive cd = new ConnDrive();
			try {
				String str = "select * from customer where number = '"+s1+"'";
				ResultSet rs1 = cd.sm.executeQuery(str);
				while(rs1.next()) {
					t1.setText(rs1.getString("room_no"));
					t2.setText(rs1.getString("name"));
					t3.setText(rs1.getString("status"));
					t4.setText(rs1.getString("deposit"));
					room = rs1.getString("room_no");
					deposit = rs1.getString("deposit");
				}
				
				String str2 = "select * from room where room_no = '"+room+"'";
				ResultSet rs2 = cd.sm.executeQuery(str2);
				while(rs2.next()) {
					price = rs2.getString("price");
					pending = Integer.parseInt(price) - Integer.parseInt(deposit);
					t5.setText(Integer.toString(pending));
				}
			} catch (Exception e2) {
				
			}
			
		}else if(e.getSource() == b2) {
			try {
				String room = t1.getText();
				String available = t2.getText();
				String status = t3.getText();
				
				ConnDrive cd2 = new ConnDrive();
				String str3 = "update room set available = '"+available+"', status = '"+status+"' where room_no = '"+room+"'";
				cd2.sm.executeUpdate(str3);
				JOptionPane.showMessageDialog(null, "Room Updated Successfully");
				new Reception().setVisible(true);
				this.setVisible(false);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else if(e.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
}
