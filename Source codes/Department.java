package hotel_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener{

	JButton b1, b2;
	JTable tb;
	
	Department() {
		tb = new JTable();
		tb.setBounds(55, 100, 620, 220);
		add(tb);
		
		JLabel title = new JLabel("Department");
		title.setBounds(300, 0, 270, 40);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Century", Font.BOLD, 24));
		add(title);
		
		JLabel l1 = new JLabel("Department");
		l1.setFont(new Font("Century", Font.BOLD, 17));
		l1.setForeground(Color.BLACK);
		l1.setBounds(150, 50, 100, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Budget");
		l2.setFont(new Font("Century", Font.BOLD, 17));
		l2.setForeground(Color.BLACK);
		l2.setBounds(500, 50, 100, 30);
		add(l2);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(210, 350, 130, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(370, 350, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(new Color(255, 228, 181));
		tb.setSelectionBackground(new Color(175,238,238));
		tb.setRowHeight(35);
		tb.setBackground(new Color(255,250,205));
		tb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		setBounds(400, 200, 750, 500);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				ConnDrive conn = new ConnDrive();
				String str = "select * from department";
				ResultSet rs = conn.sm.executeQuery(str);
				tb.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
}


