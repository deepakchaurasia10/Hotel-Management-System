package hotel_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckOut extends JFrame implements ActionListener{
	JTextField t1;
	Choice c;
	JButton b1, b2, b3;
	CheckOut() {
		
		JLabel checkout = new JLabel("Check Out");
		checkout.setBounds(380, 0, 270, 40);
		checkout.setForeground(Color.BLUE);
		checkout.setFont(new Font("Century", Font.BOLD, 24));
		add(checkout);
		
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
		
		b1 = new JButton("Checkout");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(90, 190, 120, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(240, 190, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/tick2.jpg"));
		Image img = i1.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING);
		ImageIcon i2 = new ImageIcon(img);
		b3 = new JButton(i2);
		b3.setBounds(420, 67, 30, 30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/checkout.jpg"));
		Image img1 = i11.getImage().getScaledInstance(380, 230, Image.SCALE_AREA_AVERAGING);
		ImageIcon i21 = new ImageIcon(img1);
		JLabel imgl = new JLabel(i21);
		imgl.setBounds(450, 40, 380, 230);
		add(imgl);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(320, 200, 900, 350);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String id = c.getSelectedItem();
			String room = t1.getText();
			ConnDrive con = new ConnDrive();
			String st = "delete from customer where number = '"+id+"'";
			String st2 = "update room set available = 'Available' where room_no = '"+room+"'";
			try {
				con.sm.executeUpdate(st);
				con.sm.executeUpdate(st2);
				JOptionPane.showMessageDialog(null, "Checkout Successfully");
				new Reception().setVisible(true);
				this.setVisible(false);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
			
		} else if(e.getSource() == b3) {
			String id = c.getSelectedItem();
			
			ConnDrive conn = new ConnDrive();
			String str = "select * from customer where number = '"+id+"'";
			try {
				ResultSet rs = conn.sm.executeQuery(str);
				while(rs.next()) {
					t1.setText(rs.getString("room_no"));
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
