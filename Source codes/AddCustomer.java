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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {

	JTextField t1, t2, t3, t4, t5;
	JRadioButton male, female;
	JComboBox cb1;
	JButton b1, b2;
	Choice c;
	
	AddCustomer() {
		JLabel emp = new JLabel("New Customer Form");
		emp.setBounds(310, 0, 270, 40);
		emp.setForeground(Color.BLUE);
		emp.setFont(new Font("Century", Font.BOLD, 24));
		add(emp);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Century", Font.BOLD, 17));
		id.setBounds(100, 50, 120, 30);
		add(id);
		
		cb1 = new JComboBox(new String [] {"Passport", "Driving Licence", "Voter ID", "Aadhar Card", "PAN Card"});
		cb1.setBounds(250, 50, 180, 30);
		cb1.setBackground(Color.WHITE);
		add(cb1);
		
		JLabel num = new JLabel("Number");
		num.setFont(new Font("Century", Font.BOLD, 17));
		num.setBounds(100, 90, 120, 30);
		add(num);
		
		t1 = new JTextField();
		t1.setBounds(250, 90, 180, 30);
		add(t1);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Century", Font.BOLD, 17));
		name.setBounds(100, 130, 120, 30);
		add(name);
		
		t2 = new JTextField();
		t2.setBounds(250, 130, 180, 30);
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Century", Font.BOLD, 17));
		gender.setBounds(100, 170, 120, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setFont(new Font("Century", Font.BOLD, 16));
		male.setBounds(250, 170, 80, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setFont(new Font("Century", Font.BOLD, 16));
		female.setBounds(345, 170, 90, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		JLabel city = new JLabel("City");
		city.setFont(new Font("Century", Font.BOLD, 17));
		city.setBounds(100, 210, 120, 30);
		add(city);
		
		t3 = new JTextField();
		t3.setBounds(250, 210, 180, 30);
		add(t3);
		
		JLabel alot = new JLabel("Alloted Room no.");
		alot.setFont(new Font("Century", Font.BOLD, 17));
		alot.setBounds(80, 250, 150, 30);
		add(alot);
		
		c = new Choice();
		try {
			ConnDrive cn = new ConnDrive();
			String str = "select * from room";
			ResultSet rs = cn.sm.executeQuery(str);
			while(rs.next()) {
				c.add(rs.getString("room_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setBounds(250, 257, 200, 50);
		c.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(c);
		
		JLabel check = new JLabel("Checked In");
		check.setFont(new Font("Century", Font.BOLD, 17));
		check.setBounds(100, 290, 120, 30);
		add(check);
		
		t4 = new JTextField();
		t4.setBounds(250, 290, 180, 30);
		add(t4);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setFont(new Font("Century", Font.BOLD, 17));
		deposit.setBounds(100, 330, 120, 30);
		add(deposit);
		
		t5 = new JTextField();
		t5.setBounds(250, 330, 180, 30);
		add(t5);
		
		b1 = new JButton("Add Customer");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(110, 390, 165, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(290, 390, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/customer.jpg"));
		Image img = i1.getImage().getScaledInstance(400, 350, Image.SCALE_AREA_AVERAGING);
		ImageIcon i2 = new ImageIcon(img);
		JLabel imgl = new JLabel(i2);
		imgl.setBounds(450, 50, 400, 350);
		add(imgl);
		
		getContentPane().setBackground(Color.WHITE);
		
		setBounds(320, 200, 900, 500);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String id = (String) cb1.getSelectedItem();
			String numb = t1.getText();
			String name = t2.getText();
			String gender = null;
			if(male.isSelected()) {
				gender = "Male";
			}
			else if(female.isSelected()) {
				gender = "Female";
			}
			String city = t3.getText();
			String room = (String) c.getSelectedItem();
			String check = t4.getText();
			String depo = t5.getText();
		
			String str = "insert into customer values('"+id+"', '"+numb+"', '"+name+"', '"+gender+"', '"+city+"', '"+room+"', '"+check+"', '"+depo+"')";
			String str2 = "update room set available = 'Occupied' where room_no = '"+room+"'";
			try {
				ConnDrive c = new ConnDrive();
				c.sm.executeUpdate(str);
				c.sm.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "New Customer Added");
				this.setVisible(false);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

}
