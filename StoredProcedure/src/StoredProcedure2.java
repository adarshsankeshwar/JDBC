import java.sql.*;
import java.util.*;
public class StoredProcedure2 {

	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		Scanner sc = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/janfeb?user=root&password=886721";
		String sql = "call addStudent(?,?,?,?)";
		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url);
			cs = con.prepareCall(sql);
			System.out.println("Enter the id, name, marks and age");
			int id = sc.nextInt();
			String name = sc.next();
			int marks = sc.nextInt();
			int age = sc.nextInt();
			cs.setInt(1, id);
			cs.setString(2, name);
			cs.setInt(3, marks);
			cs.setInt(4, age);
			boolean res = cs.execute();
			if(res == true) {
				rs = cs.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
				}
			}
			else {
				int nora = cs.getUpdateCount();
				System.out.println(nora +" row(s) affected");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) con.close();
				if(rs != null) rs.close();
				if(cs != null) cs.close();
				if(sc != null) cs.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
