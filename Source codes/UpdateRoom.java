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

public class UpdateRoom extends JFrame implements ActionListener{
	JTextField t1, t2, t3;
	Choice c;
	JButton b1, b2, b3;
	UpdateRoom() {
		JLabel emp = new JLabel("Update Room Status");
		emp.setBounds(310, 0, 270, 40);
		emp.setForeground(Color.BLUE);
		emp.setFont(new Font("Century", Font.BOLD, 24));
		add(emp);
		
		JLabel l1 = new JLabel("Guest ID");
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
		c.setBounds(200, 70, 250, 120);
		c.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(c);
			
		JLabel l2 = new JLabel("Room no");
		l2.setFont(new Font("Century", Font.BOLD, 17));
		l2.setBounds(70, 120, 120, 30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(200, 120, 200, 30);
		add(t1);
	
		JLabel l3 = new JLabel("Availabilty");
		l3.setFont(new Font("Century", Font.BOLD, 17));
		l3.setBounds(70, 170, 120, 30);
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(200, 170, 200, 30);
		add(t2);
		
		JLabel l4 = new JLabel("Clean Status");
		l4.setFont(new Font("Century", Font.BOLD, 17));
		l4.setBounds(70, 220, 120, 30);
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(200, 220, 200, 30);
		add(t3);
		
		b1 = new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(80, 280, 130, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(230, 280, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Dialog", Font.BOLD, 17));
		b3.setBounds(150, 330, 130, 30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/UpdateRoom.jpg"));
		Image img = i1.getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING);
		ImageIcon i2 = new ImageIcon(img);
		JLabel imgl = new JLabel(i2);
		imgl.setBounds(450, 70, 400, 300);
		add(imgl);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(320, 200, 900, 500);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String room = null;
			String s1 = (String) c.getSelectedItem();
			ConnDrive cd = new ConnDrive();
			try {
				String str = "select * from customer where number = '"+s1+"'";
				ResultSet rs1 = cd.sm.executeQuery(str);
				while(rs1.next()) {
					t1.setText(rs1.getString("room_no"));
					room = rs1.getString("room_no");
				}
				
				String str2 = "select * from room where room_no = '"+room+"'";
				ResultSet rs2 = cd.sm.executeQuery(str2);
				while(rs2.next()) {
					t2.setText(rs2.getString("available"));
					t3.setText(rs2.getString("status"));
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
