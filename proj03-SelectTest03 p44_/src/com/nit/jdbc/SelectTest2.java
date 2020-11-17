package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2 {
	public static void main(String[] args) {
		//taking input from keybord
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Boolean flag=false;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.err.println("Enter desg 1:-");
				desg1=sc.nextLine().toUpperCase();
				System.err.println("Enter desg 2:-");
				desg2=sc.nextLine().toUpperCase();
				System.err.println("Enter desg 3:-");
				desg3=sc.nextLine().toUpperCase();
			}//if
			//frame condition
			String cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			//ragister jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			if(con!=null)
				//create statement
				st=con.createStatement();
			//PRAPRE QUERY
			String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+cond+"order by job";
			System.err.println(query);
			//send and execute the query
			if(st!=null)
				rs=st.executeQuery(query);
			//process the resultset
			if(rs!=null) {
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getInt(4));
				}//while
			}//if
			if(flag==false)
				System.out.println("No records found");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close the objects
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
	}//main
}//class
