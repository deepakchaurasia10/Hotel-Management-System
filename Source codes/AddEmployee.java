package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener{

	JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	JRadioButton male, female;
	JComboBox cb;
	
	AddEmployee() {
		
		JLabel emp = new JLabel("Add Employee Details");
		emp.setBounds(310, 0, 270, 40);
		emp.setForeground(Color.BLUE);
		emp.setFont(new Font("Century", Font.BOLD, 24));
		add(emp);
		
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("Century", Font.BOLD, 17));
		name.setBounds(100, 50, 120, 30);
		add(name);
	
		tf1 = new JTextField();
		tf1.setBounds(230, 50, 250, 30);
		add(tf1);
		
		JLabel age = new JLabel("AGE");
		age.setFont(new Font("Century", Font.BOLD, 17));
		age.setBounds(100, 90, 120, 30);
		add(age);
	
		tf2 = new JTextField();
		tf2.setBounds(230, 90, 250, 30);
		add(tf2);
		
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
		female.setBounds(320, 130, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		JLabel job = new JLabel("JOB");
		job.setFont(new Font("Century", Font.BOLD, 17));
		job.setBounds(100, 170, 120, 30);
		add(job);
		
		String list[] = {"Front Desk Clerks", "Porters", "House Keeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
		cb = new JComboBox(list);
		cb.setBackground(Color.WHITE);
		cb.setBounds(230, 170, 150, 30);
		add(cb);
		
		JLabel salary = new JLabel("SALARY");
		salary.setFont(new Font("Century", Font.BOLD, 17));
		salary.setBounds(100, 210, 120, 30);
		add(salary);
		
		tf3 = new JTextField();
		tf3.setBounds(230, 210, 250, 30);
		add(tf3);
		
		JLabel phone = new JLabel("PHONE");
		phone.setFont(new Font("Century", Font.BOLD, 17));
		phone.setBounds(100, 250, 120, 30);
		add(phone);
		
		tf4 = new JTextField();
		tf4.setBounds(230, 250, 250, 30);
		add(tf4);
		
		JLabel aadhar = new JLabel("AADHAR");
		aadhar.setFont(new Font("Century", Font.BOLD, 17));
		aadhar.setBounds(100, 290, 120, 30);
		add(aadhar);
		
		tf5 = new JTextField();
		tf5.setBounds(230, 290, 250, 30);
		add(tf5);
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Century", Font.BOLD, 17));
		email.setBounds(100, 330, 120, 30);
		add(email);
		
		tf6 = new JTextField();
		tf6.setBounds(230, 330, 250, 30);
		add(tf6);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/addEmp.jpg"));
		Image i = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i);
		JLabel icon = new JLabel(i2);
		icon.setBounds(520, 40, 350, 350);
		add(icon);
		getContentPane().setBackground(Color.white);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(230, 380, 120, 30);
		submit.setFont(new Font("Dialog", Font.BOLD, 17));
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		add(submit);
		submit.addActionListener(this);
		
		setBounds(320, 200, 900, 500);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tf1.getText(); 
		String age = tf2.getText(); 
		String salary = tf3.getText(); 
		String phone = tf4.getText(); 
		String aadhar = tf5.getText(); 
		String email = tf6.getText(); 
		
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		
		String job = (String) cb.getSelectedItem();
		
		ConnDrive c = new ConnDrive();
		
		String str = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+aadhar+"', '"+email+"')";
		
		try {
			c.sm.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "New Employee added");
			this.setVisible(false);
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AddEmployee().setVisible(true);
	}
}
