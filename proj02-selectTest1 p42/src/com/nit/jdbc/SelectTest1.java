package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//write a jdbc application that gives student details based on the given city
public class SelectTest1 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//reading input from end user
			sc=new Scanner(System.in);
			System.err.println("ENTER THE CITY NAME:-");
			String city=sc.next();
			city="'"+city+"'";
			
			//load the jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection to database
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create statement
			st=con.createStatement();
			//execute the query
			rs=st.executeQuery("select * from vikas where city="+city);
			System.err.println("ID"+"\t"+"NAME"+"\t"+"CITY");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			//close all connections
			rs.close();
			st.close();
			con.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
