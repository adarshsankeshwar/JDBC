package com.kodnest.jdbc.batchupdate;

import java.util.*;
import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        Connection con = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);
        String dpath = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/janfeb?user=root&password=886721";
        String sql = "insert into department values(?,?,?,?)";
        try {
        		Class.forName(dpath);
        		con = DriverManager.getConnection(url);
        		ps = con.prepareStatement(sql);
        		
        		loop1 : while(true) {
        			System.out.println("Enter 1 for insert OR 2 for Exit");
        			int choice = sc.nextInt();
        			switch(choice) {
        			case 1: {
        				System.out.println("Enter the id, name, loc and noe");
        				int id = sc.nextInt();
        				String name = sc.next();
        				String loc = sc.next();
        				int noe = sc.nextInt();
        				
        				ps.setInt(1,id);
        				ps.setString(2, name);
        				ps.setString(3, loc);
        				ps.setInt(4, noe);
        				
        				ps.addBatch();
        				break;
        			}
        			case 2 : {
        				break loop1;
        			}
        			default : System.out.println("Invalid choices");	
        			}
        		}
        		int res[] = ps.executeBatch();
        		for(int i : res) {
        			System.out.println(i+" ");
        		}
        		System.out.println();
        	
        }catch(Exception e) {
        		e.printStackTrace();
        }
        finally {
        		try {
        			if(con != null) con.close();
        			if(ps != null) ps.close();
        			if(sc != null) sc.close();
        		}catch(Exception e2) {
        			e2.printStackTrace();
        		}
        }
        
    }
}
