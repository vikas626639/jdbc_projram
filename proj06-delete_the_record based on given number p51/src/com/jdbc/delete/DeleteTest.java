package com.jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query=null;
		int no=0;
		int result;
		try {
			//read data from keybord
			System.out.println("enter input:-");
			no=sc.nextInt();
			//load the jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//stablish the connection with data base
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create statement
			if(con!=null) {
				st=con.createStatement();
			}
			query="delete from product where pid="+no;
			//execute the query
			result=st.executeUpdate(query);//it will return int value either 0 or 1
			if(result==0) {
				System.err.println("no record available");
			}else {
				System.err.println(result+" record deleted");
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
