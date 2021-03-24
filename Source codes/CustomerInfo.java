package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame  implements ActionListener{

	JTable t1;
	JButton b1, b2;
	CustomerInfo() {
		t1 = new JTable();
		t1.setBounds(45, 85, 900, 450);
		add(t1);
		
		JLabel emp = new JLabel("All Customer Info");
		emp.setBounds(380, 0, 270, 40);
		emp.setForeground(Color.BLUE);
		emp.setFont(new Font("Century", Font.BOLD, 24));
		add(emp);
		
		JLabel l1 = new JLabel("ID");
		l1.setFont(new Font("Century", Font.BOLD, 17));
		l1.setForeground(Color.BLACK);
		l1.setBounds(85, 50, 100, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Number");
		l2.setFont(new Font("Century", Font.BOLD, 17));
		l2.setForeground(Color.BLACK);
		l2.setBounds(175, 50, 100, 30);
		add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setFont(new Font("Century", Font.BOLD, 17));
		l3.setForeground(Color.BLACK);
		l3.setBounds(295, 50, 100, 30);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setFont(new Font("Century", Font.BOLD, 17));
		l4.setForeground(Color.BLACK);
		l4.setBounds(410, 50, 100, 30);
		add(l4);
		
		JLabel l5 = new JLabel("City");
		l5.setFont(new Font("Century", Font.BOLD, 17));
		l5.setForeground(Color.BLACK);
		l5.setBounds(530, 50, 100, 30);
		add(l5);
		
		JLabel l6 = new JLabel("Room No.");
		l6.setFont(new Font("Century", Font.BOLD, 17));
		l6.setForeground(Color.BLACK);
		l6.setBounds(625, 50, 100, 30);
		add(l6);
		
		JLabel l7 = new JLabel("Check In");
		l7.setFont(new Font("Century", Font.BOLD, 17));
		l7.setForeground(Color.BLACK);
		l7.setBounds(740, 50, 100, 30);
		add(l7);
		
		JLabel l8 = new JLabel("Deposit");
		l8.setFont(new Font("Century", Font.BOLD, 17));
		l8.setForeground(Color.BLACK);
		l8.setBounds(850, 50, 100, 30);
		add(l8);
		
		b1 = new JButton("Load Data");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(350, 550, 130, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(500, 550, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(new Color(255, 228, 181));
		t1.setSelectionBackground(new Color(175,238,238));
		t1.setRowHeight(35);
		t1.setBackground(new Color(255,250,205));
		t1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		setBounds(260, 100, 1000, 650);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			ConnDrive c = new ConnDrive();
			try {
				String str = "select * from customer";
				ResultSet rs = c.sm.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}	
}

