package com.jdbc.loginApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		//private String query="select count(*) from userlist where username='raja' and pwd='rani";
		String username=null,password=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int count = 0;

		try {
			//reading input from keybord
			System.err.println("enter username:-");
			username=sc.next();
			System.err.println("Enter password:-");
			password=sc.next();
			//convert String value to oracle dupport varchar values
			username="'"+username+"'";
			password="'"+password+"'";

			//ragister jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//stablish the connection with database
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create statement
			st=con.createStatement();
			//execute query
			String query="select count(*) from userlist where username="+username+" and pwd="+password;
			rs=st.executeQuery(query);
			//print data 
			if(rs.next()) {
				count=rs.getInt(1);
			}

			if(count==0) {
				System.out.println("inValid credentials");
			}else {
				System.out.println("valid credentials");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
