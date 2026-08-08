import java.sql.*;
import java.util.*;
public class StoredProcedure {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		Scanner sc = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/janfeb?user=root&password=886721";
		String sql = "call getStudentMarks(?)";
		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url);
			cs = con.prepareCall(sql);
			System.out.println("Enter marks to fetch students details");
			int marks = sc.nextInt();
			cs.setInt(1, marks);
			
			boolean res = cs.execute();
			if(res == true) {
				rs = cs.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
				}
			}else {
				int nora = cs.getUpdateCount();
				System.out.println(nora+" row(s) affected");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) con.close();
				if(rs != null) con.close();
				if(cs != null) con.close();
				if(sc != null) sc.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
