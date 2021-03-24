package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
	JComboBox c1;
	JCheckBox cb1;
	JButton b1, b2;
	JTable tb;
	
	SearchRoom() {
		tb = new JTable();
		tb.setBounds(55, 150, 780, 220);
		add(tb);
		
		JLabel search = new JLabel("Search For Room");
		search.setBounds(350, 0, 270, 40);
		search.setForeground(Color.BLUE);
		search.setFont(new Font("Century", Font.BOLD, 24));
		add(search);
		
		JLabel type = new JLabel("Room Bed Type");
		type.setFont(new Font("Century", Font.BOLD, 17));
		type.setBounds(50, 50, 150, 30);
		add(type);
		
		c1 = new JComboBox(new String [] {"Single Bed", "Double Bed"});
		c1.setBounds(200, 50, 180, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		cb1 = new JCheckBox("Only display available");
		cb1.setFont(new Font("Dialog", Font.BOLD, 14));
		cb1.setBackground(new Color(255, 228, 181));
		cb1.setBounds(630, 50, 180, 30);
		add(cb1);
		
		JLabel l1 = new JLabel("Room No.");
		l1.setFont(new Font("Century", Font.BOLD, 17));
		l1.setForeground(Color.BLACK);
		l1.setBounds(100, 120, 100, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Available");
		l2.setFont(new Font("Century", Font.BOLD, 17));
		l2.setForeground(Color.BLACK);
		l2.setBounds(250, 120, 100, 30);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setFont(new Font("Century", Font.BOLD, 17));
		l3.setForeground(Color.BLACK);
		l3.setBounds(410, 120, 100, 30);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setFont(new Font("Century", Font.BOLD, 17));
		l4.setForeground(Color.BLACK);
		l4.setBounds(580, 120, 100, 30);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setFont(new Font("Century", Font.BOLD, 17));
		l5.setForeground(Color.BLACK);
		l5.setBounds(720, 120, 100, 30);
		add(l5);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(300, 390, 130, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(460, 390, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(new Color(255, 228, 181));
		tb.setSelectionBackground(new Color(175,238,238));
		tb.setRowHeight(35);
		tb.setBackground(new Color(255,250,205));
		tb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		setBounds(320, 200, 900, 500);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				String type = (String) c1.getSelectedItem();
				ConnDrive conn = new ConnDrive();
				String str = "select * from room where bed_type = '"+type+"'";
				String str2 = "select * from room where available = 'Available' AND bed_type = '"+type+"'";
				ResultSet rs;
				
				
				if(cb1.isSelected()) {
					rs = conn.sm.executeQuery(str2);
					tb.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				else {
					rs = conn.sm.executeQuery(str);
					tb.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
}
