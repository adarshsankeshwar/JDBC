package insertRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertRecord {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into employee values(?,?,?,?)";
		Scanner sc = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/janfeb";
		String user = "root";
		String pw = "886721";
		try {
			Class.forName(dpath);
			conn = DriverManager.getConnection(url, user, pw);
			ps = conn.prepareStatement(sql);
			System.out.println("Enter id, name, gender & salary");
			int id = sc.nextInt();
			String name = sc.next();
			String gender = sc.next();
			int salary = sc.nextInt();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setInt(4, salary);
			int nora = ps.executeUpdate();
			System.out.println(nora+" row(s) affected");	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				if(sc != null) sc.close();	
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
