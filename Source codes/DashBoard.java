package hotel_management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DashBoard extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem i1, i2, i3, i4;
	
	DashBoard() {
		mb = new JMenuBar();
		add(mb);
		
		JLabel j1 = new JLabel("Hotel Signature 🏩 Welcomes you...");
		j1.setBounds(410, 50, 800, 80);
		j1.setFont(new Font("Century", Font.ITALIC, 45));
		j1.setForeground(Color.black);
		add(j1);
		
		m1 = new JMenu("Hotel Management");
		mb.add(m1);
		
		m2 = new JMenu("ADMIN");
		mb.add(m2);
		
		i1 = new JMenuItem("Reception");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2 = new JMenuItem("Add Employee");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3 = new JMenuItem("Add Rooms");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4 = new JMenuItem("Add Drivers");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(1, 0, 1920, 30);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/HotelBg1.jpg"));
		Image imge = img.getImage().getScaledInstance(1920, 1050, Image.SCALE_SMOOTH);
		ImageIcon i2 = new ImageIcon(imge);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(0, 0, 1920, 1050);
		add(l1);
		
		setLayout(null);
		setBounds(-8, 0, 1920, 1080);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Reception")) {
			new Reception().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Employee")) {
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Rooms")) {
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Drivers")) {
			new AddDriver().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new DashBoard().setVisible(true);;
	}
}
