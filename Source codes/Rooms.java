package hotel_management;

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
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Rooms extends JFrame implements ActionListener{

	JTable t1;
	JButton b1, b2;
	
	Rooms() {
		t1 = new JTable();
		t1.setBounds(35, 85, 480, 450);
		add(t1);
		
		JLabel emp = new JLabel("Rooms");
		emp.setBounds(220, 0, 100, 40);
		emp.setForeground(Color.BLUE);
		emp.setFont(new Font("Century", Font.BOLD, 24));
		add(emp);
		
		JLabel l1 = new JLabel("Room No.");
		l1.setFont(new Font("Tahoma", Font.BOLD, 16));
		l1.setForeground(Color.BLACK);
		l1.setBounds(40, 50, 100, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Available");
		l2.setFont(new Font("Tahoma", Font.BOLD, 16));
		l2.setForeground(Color.BLACK);
		l2.setBounds(140, 50, 100, 30);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setFont(new Font("Tahoma", Font.BOLD, 16));
		l3.setForeground(Color.BLACK);
		l3.setBounds(250, 50, 100, 30);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setFont(new Font("Tahoma", Font.BOLD, 16));
		l4.setForeground(Color.BLACK);
		l4.setBounds(345, 50, 100, 30);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setFont(new Font("Tahoma", Font.BOLD, 16));
		l5.setForeground(Color.BLACK);
		l5.setBounds(430, 50, 100, 30);
		add(l5);
		
		b1 = new JButton("Load Data");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(130, 550, 130, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(280, 550, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/roombg1.jpg"));
		Image img = i1.getImage().getScaledInstance(500, 650, Image.SCALE_AREA_AVERAGING);
		ImageIcon i2 = new ImageIcon(img);
		JLabel imgl = new JLabel(i2);
		imgl.setBounds(550, 0, 500, 650);
		add(imgl);
		
		getContentPane().setBackground(new Color(255, 228, 181));
		t1.setSelectionBackground(new Color(175,238,238));
		t1.setRowHeight(35);
		t1.setBackground(new Color(255,250,205));
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		setBounds(320, 100, 1000, 650);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				ConnDrive c = new ConnDrive();
				String str = "select * from room";
				ResultSet rs = c.sm.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
}
