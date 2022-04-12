package vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	
	public static void main(String[] args) {
		String databaseURL = "jdbc:ucanaccess://Database.accdb";
		
		try {
			
			Connection connection = DriverManager.getConnection(databaseURL);
			
			System.out.println("connecté");
			
			String sql="INSERT INTO tabLogin (username, password) VALUES" + "('Bonjour','1235')";
			
			Statement statement = connection.createStatement();
			int rows= statement.executeUpdate(sql);
			
			if (rows>0) {
				System.out.println("infos insérées");
			}
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
