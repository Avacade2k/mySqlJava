import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLcon {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static ArrayList<String> userbase = new ArrayList<String>();

	static boolean connectSQL() {

		try {

			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex);
			return false;
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/mySqlJava?serverTimezone=UTC", "root", "");
			return true;

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}

	static void updateSQL() {
		try {
			
			String username = myBean.getUsername();
			String password = myBean.getPassword();

			stmt = conn.createStatement();
			String st = "INSERT INTO users(username, password) VALUES ('"+username+"','"+password+"')";
			stmt.execute(st);
			

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			
		}

	}
	
	static void stateSQL() {

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM users");

			// ResultSet return
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				String moreUser = rs.getString(1) + " " + rs.getString(2);
				userbase.add(moreUser);

			}

			conn.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			
		}

	}

}