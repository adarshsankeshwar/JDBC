import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class UpdateRecord {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/janfeb?user=root&password=886721";
		String sql = "update employee set name=? where id=?";
		try {
			Class.forName(dpath);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement(sql);
			System.out.println("Enter the id to be update");
			int id = sc.nextInt();
			System.out.println("Enter the the newname");
			String newName = sc.next();
			ps.setInt(2,id);
			ps.setString(1, newName);
			int nora = ps.executeUpdate();
			System.out.println(nora+" rows affected");
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
