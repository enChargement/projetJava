package vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class login {
	
	Connection cnx = null;
	ResultSet Rs = null;
	PreparedStatement ps=null;
	

	public static Connection ConnectDB() {
		
		String url = "jdbc:ucanaccess://Database.accdb";

        try {

            Connection cnx=DriverManager.getConnection(url);

            System.out.println("connexion réussie");
            return cnx;



        }

        catch (SQLException e) {
            e.printStackTrace();
            return null;


        }

    }

}
