//in this project we will perform select and non select operation
package com.jdbc.execute_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		String query=null;
		Connection con=null;
		Statement st=null;
		boolean flag=false;
		ResultSet rs=null;
		int count=0;
		try {
			//read input
			System.out.println("Enter query:-");
			query=sc.nextLine();
			//ragister jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection with database
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create statement
			st=con.createStatement();
			//execute the query
			flag=st.execute(query);
			if(flag==true) {
				System.out.println("Select query executed.......");
				rs=st.getResultSet();
				//print the result
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				}//while
			}//if
			else {
				System.out.println("Executing non select query");
				count=st.getUpdateCount();
				System.out.println(count+" record are effected");
			}//else
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
		}//finally

	}
}
//developers will not perform execute query in real time becouse this method makes programmer to get 
//query execution result by calling one additonal method which is extra burdon to programmer 
//so use execute query method for select query and execute update method for non-select queries execution
