package hotel_management;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem  extends JFrame {
	
	HotelManagementSystem() {

		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("hotel_management/Images/hotel1.jpg"));
		JLabel j1 = new JLabel(image);
		j1.setBounds(0, 0, 1024, 683);
		add(j1);
		
		JLabel j2 = new JLabel("Hotel Management System");
		j2.setForeground(Color.green);
		j2.setFont(new Font("serif", Font.HANGING_BASELINE, 40));
		j2.setBounds(200,120,800,88);
		j1.add(j2);
		
		JButton b1 = new JButton("Next");
		b1.setBackground(Color.WHITE); 
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("serif", Font.ROMAN_BASELINE, 30));
		b1.setBounds(750, 550, 140, 40);
		j1.add(b1);
		
		setBounds(250, 50, 1024, 683);
		setLayout(null);
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn();
				dispose();
			}	
		});
		
		// For Blinking of Hotel management system  
		setVisible(true);
		
		while(true) {
			j2.setVisible(false);
			try {
				Thread.sleep(600);
			} catch (Exception e) {}
			j2.setVisible(true);
			try {
				Thread.sleep(600);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		new HotelManagementSystem();
	}

}
