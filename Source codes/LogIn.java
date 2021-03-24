package hotel_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	
	LogIn() {
		l1 = new JLabel("Username");
		l1.setBounds(260, 60, 150, 30);
		add(l1);
		
		l2 = new JLabel("Password");
		l2.setBounds(260, 120, 150, 30);
		add(l2);
		
		l3 = new JLabel("Authorized Login");
		l3.setBounds(240, 12, 180, 30);
		l3.setFont(new Font("serif", Font.CENTER_BASELINE, 17));
		add(l3);
		
		t1 = new JTextField(20);
		t1.setBounds(260, 90, 200, 30);
		add(t1);
		
		t2 = new JPasswordField(20);
		t2.setBounds(260, 150, 200, 30);
		add(t2);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(260, 200, 120, 30);
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.black);
		b2.setBounds(390,200,120,30);
		b2.addActionListener(this);
		
		add(b1);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/login_icon.png"));
		JLabel j1 = new JLabel(i1);
		j1.setBounds(20,30,220,220);
		add(j1);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setSize(600,340);
		setLocation(350,200);
		setVisible(true);	
	}
	
	//ActionListener for Login & Cancel Button
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String username = t1.getText();
			String password = t2.getText();
			ConnDrive c = new ConnDrive();
			try {
				
				String str = ("select * from login where username = '"+username+"' and password = '"+password+"'");
				ResultSet rs = c.sm.executeQuery(str);
				
				if(rs.next()) {
					new DashBoard().setVisible(true);;
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username and password");
					dispose();
				}		
				
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource() == b2) {
			System.exit(0);
		}	
	}
	
	public static void main(String[] args) {
		new LogIn();
	}
}
