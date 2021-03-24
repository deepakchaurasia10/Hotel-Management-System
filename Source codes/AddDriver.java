package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener{

	JTextField t1, t2, t3, t4, t5;
	JComboBox cb1, cb2, cb3;
	JRadioButton male, female;
	JButton b1, b2;
	
	AddDriver() {
		
		JLabel addDriver = new JLabel("Add Driver");
		addDriver.setBounds(380, 0, 270, 40);
		addDriver.setForeground(Color.BLUE);
		addDriver.setFont(new Font("Century", Font.BOLD, 24));
		add(addDriver);
		
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("Century", Font.BOLD, 17));
		name.setBounds(100, 50, 120, 30);
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(230, 50, 220, 30);
		add(t1);
		
		JLabel age = new JLabel("AGE");
		age.setFont(new Font("Century", Font.BOLD, 17));
		age.setBounds(100, 90, 120, 30);
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(230, 90, 220, 30);
		add(t2);
		
		JLabel gender = new JLabel("GENDER");
		gender.setFont(new Font("Century", Font.BOLD, 17));
		gender.setBounds(100, 130, 120, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setFont(new Font("Century", Font.BOLD, 16));
		male.setBounds(230, 130, 80, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setFont(new Font("Century", Font.BOLD, 16));
		female.setBounds(320, 130, 100, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		JLabel car = new JLabel("Car Company");
		car.setFont(new Font("Century", Font.BOLD, 17));
		car.setBounds(100, 170, 120, 30);
		add(car);
		
		t3 = new JTextField();
		t3.setBounds(230, 170, 220, 30);
		add(t3);
		
		JLabel carModel = new JLabel("Car Model");
		carModel.setFont(new Font("Century", Font.BOLD, 17));
		carModel.setBounds(100, 210, 120, 30);
		add(carModel);
		
		t4 = new JTextField();
		t4.setBounds(230, 210, 220, 30);
		add(t4);
		
		JLabel available = new JLabel("Available");
		available.setFont(new Font("Century", Font.BOLD, 17));
		available.setBounds(100, 250, 120, 30);
		add(available);
		
		cb1 = new JComboBox(new String [] {"Available", "Busy"});
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(230, 250, 220, 30);
		add(cb1);
		
		JLabel location = new JLabel("Location");
		location.setFont(new Font("Century", Font.BOLD, 17));
		location.setBounds(100, 290, 120, 30);
		add(location);
		
		t5 = new JTextField();
		t5.setBounds(230, 290, 220, 30);
		add(t5);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/driver.jpg"));
		Image img = i1.getImage().getScaledInstance(380, 280, Image.SCALE_AREA_AVERAGING);
		ImageIcon i2 = new ImageIcon(img);
		JLabel imgl = new JLabel(i2);
		imgl.setBounds(480, 60, 380, 280);
		add(imgl);
		
		b1 = new JButton("Add Driver");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(130, 350, 130, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(280, 350, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(320, 200, 900, 500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String name = t1.getText();
			String age = t2.getText();
			String gender = null;
			if(male.isSelected()) {
				gender = "Male";
			}
			else if(female.isSelected()) {
				gender = "Female";
			}
			
			String carComp = t3.getText();
			String model = t4.getText();
			String available = (String) cb1.getSelectedItem();
			String location = t5.getText();
			
			ConnDrive c = new ConnDrive();
			try {
				String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+carComp+"', '"+model+"', '"+available+"', '"+location+"')";
				c.sm.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver Added Successfully");
				
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource() == b2) {
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new AddDriver().setVisible(true);
	}


}
