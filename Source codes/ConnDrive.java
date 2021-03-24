package hotel_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDrive {
	Connection c;
	Statement sm;
	
	public ConnDrive() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms", "root", "1015");
			sm = c.createStatement();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
}
