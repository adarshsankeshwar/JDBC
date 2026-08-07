import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class Transaction {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		Scanner sc = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/janfeb?user=root&password=886721";
		String sql1 = "update bank set balance=balance-? where accnum=? and password=?";
		String sql2 = "update bank set balance=balance+? where accnum=?";
		try {
			Class.forName(dpath);
			conn = DriverManager.getConnection(url);
			ps1 = conn.prepareStatement(sql1);
			ps2 = conn.prepareStatement(sql2);
			System.out.println("ENter the FromAccNum and Pwd");
			int fromAccNum = sc.nextInt();
			String pwd = sc.next();
			System.out.println("Enter the toAccNum");
			int toAccNum = sc.nextInt();
			System.out.println("Enter the amount");
			int amt = sc.nextInt();
			
			ps1.setInt(1, amt);
			ps1.setInt(2, fromAccNum);
			ps1.setString(3, pwd);
			ps2.setInt(1, amt);
			ps2.setInt(2, toAccNum);
			
			int nora1 = ps1.executeUpdate();
			System.out.println(nora1+ " row(s) affected");
			int nora2 = ps2.executeUpdate();
			System.out.println(nora2+ " rows affected");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null) conn.close();
				if(ps1 != null) ps1.close();
				if(ps2 != null) ps2.close();
				if(sc != null) sc.close();			
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
