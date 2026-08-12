package com.kodnest.jdbcProblems;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class App {
    public static void main(String[] args) {
    		Scanner sc= new Scanner(System.in);
    		System.out.println("Enter the id, houseno, streetname, city, country, pincode");
    		Address addr = new Address(sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt());
    		System.out.println("ENter thr id, name, gender, age, collage, university, 10thM, 12ThM, degreeM");
    		Student stu = new Student(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), addr);
    		System.out.println(stu);
    		
    		Connection con = null;
    		PreparedStatement ps1 = null;
    		PreparedStatement ps2 = null;
    		
    		String dpath = "com.mysql.cj.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/janfeb?user=root&password=886721";
    		String sql1 = "insert into student values(?,?,?,?,?,?,?,?,?,?);";
    		String sql2 = "insert into address values(?,?,?,?,?,?);";
    		try {
    			Class.forName(dpath);
    			con = DriverManager.getConnection(url);
    			ps1 = con.prepareStatement(sql1);
    			ps2 = con.prepareStatement(sql2);
    			ps1.set
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    }
}
