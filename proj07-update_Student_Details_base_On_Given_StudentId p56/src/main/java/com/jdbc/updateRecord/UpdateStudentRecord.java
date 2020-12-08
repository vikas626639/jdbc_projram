package com.jdbc.updateRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudentRecord {
	
	private static Scanner sc=new Scanner(System.in);
	//private static String query1="insert into student values("
	public static void main(String[] args) {
		//String query1="insert into student values(s1.nextval,'vikas','hyd')";
		int sno;
		int result;
		String sname;
		String sadd;
		Connection con=null;
		Statement st=null;
		try {
			System.out.println("Enter student number=");
			sno=sc.nextInt();
			System.out.println("Enter student number:-");
			sname=sc.next();
			System.out.println("Enter student address:-");
			sadd=sc.next();
			sname="'"+sname+"'";
			sadd="'"+sadd+"'";
			
			//load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//stablish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","manager");
			//create statement
			st=con.createStatement();
			//execute query
			//String query2="insert into student values("+sno+","+sname+","+sadd+")";
			String query2="update student set sname="+sname+",sadd="+sadd+" where sno="+sno;
			System.out.println("processing");
			result=st.executeUpdate(query2);
			System.out.println("query exequted");
			if(result==1) {
				System.err.println(result+" record updated");
			}else {
				System.out.println("record not found to update");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(st!=null)
					st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
