package com.jdbc.insertOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PstInsertTest {

	private static Scanner sc=new Scanner(System.in);
	private static String query="INSERT INTO STUDENT VALUES(?,?,?)"; //sno, sname,sadd
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		int sno=0,result=0,count=0;
		String name=null,addrs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection between database
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create statement --> preparedStatemtn for dynamic record insertion and query execution only for one time 
			ps=con.prepareStatement(query);
			if(sc!=null) {
				//"readint input from the keybord
				System.err.println("HOW MANY STUDENT RECORDS YOU WANT TO INSERT:-");
				count=sc.nextInt();
				for(int i=1; i<=count; i++) {
					System.out.println("ENTER "+i+" STUDENT Roll_NUMBER:-\t");
					sno=sc.nextInt();sc.nextLine();
					System.out.println("ENTER STUDENT NAME:-\t");
					name=sc.nextLine();
					System.out.println("ENTER STUDENT ADDRESS:-\t");
					addrs=sc.nextLine();
					//convert String format to sql query format
					//set the input values read from enduser to query params
					ps.setInt(1, sno);
					ps.setString(2, name);
					ps.setString(3, addrs);

					//execute the query
					result=ps.executeUpdate();
					if(result==0) {
						System.out.println(i+" student details are not inserted");	
					}else {
						System.out.println(i+" student record are saved");
					}
				}//for
			}//if
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)
					ps.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
