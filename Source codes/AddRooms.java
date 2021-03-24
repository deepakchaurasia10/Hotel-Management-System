package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener{
	JTextField t1, t2;
	JComboBox cb1, cb2, cb3;
	JButton b1, b2;
	
	AddRooms() {
		
		JLabel addRoom = new JLabel("Add Rooms");
		addRoom.setBounds(380, 0, 270, 40);
		addRoom.setForeground(Color.BLUE);
		addRoom.setFont(new Font("Century", Font.BOLD, 24));
		add(addRoom);
		
		JLabel room = new JLabel("Room Number");
		room.setFont(new Font("Century", Font.BOLD, 17));
		room.setBounds(60, 80, 160, 30);
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(220, 80, 150, 30);
		add(t1);
		
		JLabel available = new JLabel("Available");
		available.setFont(new Font("Century", Font.BOLD, 17));
		available.setBounds(60, 120, 160, 30);
		add(available);
		
		cb1 = new JComboBox(new String [] {"Available", "Occupied"});
		cb1.setBounds(220, 120, 150, 30);
		cb1.setBackground(Color.WHITE);
		add(cb1);
		
		JLabel status = new JLabel("Cleaning Status");
		status.setFont(new Font("Century", Font.BOLD, 17));
		status.setBounds(60, 160, 160, 30);
		add(status);
		
		cb2 = new JComboBox(new String [] {"Cleaned", "Dirty"});
		cb2.setBounds(220, 160, 150, 30);
		cb2.setBackground(Color.WHITE);
		add(cb2);
		
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Century", Font.BOLD, 17));
		price.setBounds(60, 200, 160, 30);
		add(price);
		
		t2 = new JTextField();
		t2.setBounds(220, 200, 150, 30);
		add(t2);
		
		JLabel bedType = new JLabel("Bed Type");
		bedType.setFont(new Font("Century", Font.BOLD, 17));
		bedType.setBounds(60, 240, 160, 30);
		add(bedType);
		
		cb3 = new JComboBox(new String [] {"Single Bed", "Double Bed"});
		cb3.setBounds(220, 240, 150, 30);
		cb3.setBackground(Color.WHITE);
		add(cb3);
		
		b1 = new JButton("Add Room");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Dialog", Font.BOLD, 17));
		b1.setBounds(60, 300, 130, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Dialog", Font.BOLD, 17));
		b2.setBounds(220, 300, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/room.jpg"));
		JLabel imgl = new JLabel(i1);
		imgl.setBounds(450, 80, 400, 250);
		add(imgl);
		

		setLayout(null);
		setBounds(320, 200, 900, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String roomNo = t1.getText();
			String available = (String) cb1.getSelectedItem();
			String status = (String) cb2.getSelectedItem();
			String price = t2.getText();
			String bedType = (String) cb3.getSelectedItem();
			
			ConnDrive c = new ConnDrive();
			try {
				String str = "insert into room values('"+roomNo+"', '"+available+"', '"+status+"', '"+price+"', '"+bedType+"')";
				c.sm.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "New Room added");
				this.setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource() == b2) {
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new AddRooms().setVisible(true);
	}
}
